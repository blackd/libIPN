/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2022 Plamen K. Kosseff <p.kosseff@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anti_ad.mc.common.moreinfo

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.anti_ad.mc.libipn.Log
import java.net.URL
import java.util.concurrent.*
import java.security.MessageDigest;
import javax.net.ssl.HttpsURLConnection

abstract class InfoManagerBase {

    abstract var mcVersion: String
    abstract var version: String
    abstract var modId: String
    abstract var modName: String
    abstract var loader: String

    protected abstract val defaultRequest: Map<String, String>
    private val session: MutableMap<String, String> = mutableMapOf()
    protected abstract val target: URL

    abstract var isEnabled: () -> Boolean

    private val isBeta by lazy { version.contains("BETA") }
    private val currentVer by lazy { SemVer.parse(if (isBeta) version.substringBefore("-")  else { version }) }
    private val mcVersionClean by lazy { mcVersion.split(".").joinToString(separator = "") }


    protected val executor: ExecutorService = Executors.newFixedThreadPool(2)


    open fun event(name: Lazy<String>, value: Lazy<String>) {
        if (isEnabled()) {
            doEvent(name.value, value.value)
        }
    }

    open fun event(name: String, value: Lazy<String>) {
        if (isEnabled()) {
            doEvent(name, value.value)
        }
    }

    open fun event(name: String, value: String = "") {
        if (isEnabled()) {
            doEvent(name, value)
        }
    }

    open fun event(name: Lazy<String>, value: String = "") {
        if (isEnabled()) {
            doEvent(name.value, value)
        }
    }

    private fun doEvent(name: String, value: String) {
        if (session[name] == null) {
            session[name] = name
            executor.execute {
                try {
                    sendEvent(name, value)
                } catch (t: Throwable) {
                    Log.error("", t)
                }
            }
        }
    }

    private fun sendEvent(name: String,
                          value: String) {
        val body = mutableMapOf<String, String>().apply {
            putAll(defaultRequest)
            put("url", "https://ipn-stats.anti-ad.org/$name/?$loader&$mcVersion&$modId&$version$value")
        }
        with(target.openConnection() as HttpsURLConnection) {
            val reqBody = Json.encodeToJsonElement<Map<String, String>>(body).toString()
            //Log.trace("request body $reqBody")
            val bodyBytes = reqBody.toByteArray()

            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json; utf-8")
            setRequestProperty("User-Agent", "Minecraft/$mcVersionClean IPN/${currentVer.major}${currentVer.minor}${currentVer.patch}")
            setRequestProperty("Content-Length", bodyBytes.size.toString())
            doOutput = true

            with(outputStream) {
                write(bodyBytes)
                close()
            }
            with(inputStream) {
                readBytes()
                close()
            }
        }
        Log.trace("Event Sent!")
    }

    protected fun String.sha256() = hashString("SHA-256", this)

    private fun ByteArray.toHex(): String {
        return joinToString("") { "%02x".format(it) }
    }

    private fun hashString(type: String, input: String): String {
        val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
        return bytes.toHex()
    }

    open fun checkVersion(versionCheckURL: URL,
                          modId: String,
                          salt: String,
                          function: (SemVer, SemVer, Boolean) -> Unit) {

        executor.execute {
            try {
                doCheckVersion(versionCheckURL,
                               modId,
                               if (salt != " InvalidName") salt.sha256() else "Invalid!!!",
                               function)
            } catch (t: Throwable) {
                Log.warn("Update check failed with message - ${t.message}")
            }
        }
    }

    protected fun doCheckVersion(versionCheckURL: URL,
                                 modId: String,
                                 salt: String,
                                 function: (SemVer, SemVer, Boolean) -> Unit) {
        with(versionCheckURL.openConnection() as HttpsURLConnection) {
            val isBeta = version.contains("BETA")
            val currentVer = SemVer.parse(if (isBeta) version.substringBefore("-")  else { version })

            setRequestProperty("User-Agent", "Minecraft/$mcVersion; $loader; ${modId}/$currentVer; $salt;" + if (isBeta) " Beta" else "")

            instanceFollowRedirects = false
            val xIpn = getHeaderField("X-IPN")
            if (responseCode == 302 && xIpn != null) {
                val latestVer = SemVer.parse(xIpn)
                if (latestVer > currentVer || (isBeta && latestVer >= currentVer) ) {
                    function(latestVer, currentVer, isBeta)
                }
            }
        }
    }
}
