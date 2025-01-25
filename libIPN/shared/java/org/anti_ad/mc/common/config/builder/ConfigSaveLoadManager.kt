/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2019-2020 jsnimda <7615255+jsnimda@users.noreply.github.com>
 *   Copyright (c) 2021-2022 Plamen K. Kosseff <p.kosseff@gmail.com>
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

package org.anti_ad.mc.common.config.builder

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToStream
import org.anti_ad.mc.libipn.Log
import org.anti_ad.mc.common.Savable
import org.anti_ad.mc.common.config.IConfigElement
import org.anti_ad.mc.common.extensions.*
import org.anti_ad.mc.common.vanilla.VanillaUtil
import java.io.IOException
import java.nio.file.Path
import kotlin.io.path.outputStream
import kotlin.io.path.readText

open class ConfigSaveLoadManager(modId: String,
                                 fileName: String,
                                 private val configSource: () -> IConfigElement) : Savable {

    private val configFile: Path = VanillaUtil.configDirectory(modId) / fileName
    private val path = configFile.loggingPath

    private var config: IConfigElement? = null
        get() {
            if (field == null) {
                field = configSource()
            }
            return field
        }
        set(value) {
            if (value == null) {
                field = null
            }
        }

    @OptIn(ExperimentalSerializationApi::class)
    private val encoder = Json {
        prettyPrintIndent = "    "
        prettyPrint = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun save() {
        try {
            val el = config!!.toJsonElement()
            encoder.encodeToStream(JsonElement.serializer(), el, configFile.outputStream())
        } catch (e: IOException) {
            Log.error("I/O error while writing config file $path", e)
        } catch (e: Exception) {
            Log.error("Error write config file $path", e)
        }
    }

    override fun load() {
        try {
            if (!configFile.exists()) return
            val j = configFile.readText().toJsonElement()
            config!!.fromJsonElement(j)
        } catch (e: IOException) {
            Log.error("Failed to read config file $path", e)
        } catch (e: SerializationException) {
            Log.error("Failed to parse config file $path as JSON", e)
        } catch (e: Exception) {
            Log.error("Error write config file $path", e)
        }
    }

}
