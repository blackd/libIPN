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

package org.anti_ad.mc.common.config.options

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.jsonArray
import org.anti_ad.mc.libipn.Log
import org.anti_ad.mc.common.config.ConfigOptionBase
import org.anti_ad.mc.common.config.IConfigElementObject
import org.anti_ad.mc.common.input.AlternativeKeybind
import org.anti_ad.mc.common.input.IKeybind
import org.anti_ad.mc.common.input.KeybindSettings
import org.anti_ad.mc.common.input.MainKeybind

open class ConfigHotkey(defaultStorageString: String,
                        defaultSettings: KeybindSettings) : ConfigOptionBase(), IConfigElementObject {

    val mainKeybind: MainKeybind
        get() = realMainKeybind as MainKeybind

    open val realMainKeybind: IKeybind = MainKeybind(defaultStorageString,
                                                     defaultSettings)
    val alternativeKeybinds = mutableListOf<AlternativeKeybind>()

    fun isActivated(): Boolean =
        realMainKeybind.isActivated() || alternativeKeybinds.any { it.isActivated() }

    fun isPressing(): Boolean =
        realMainKeybind.isPressing() || alternativeKeybinds.any { it.isPressing() }

    override val isModified
        get() = alternativeKeybinds.isNotEmpty() || realMainKeybind.isModified

    override fun resetToDefault() {
        alternativeKeybinds.forEach {
            it.resetToDefault()
        }
        realMainKeybind.resetToDefault()
    }

    override fun toJsonElement() = JsonObject(getConfigAsMap())

    protected open fun getConfigAsMap(): MutableMap<String, JsonElement> = mutableMapOf<String, JsonElement>().apply {
        if (realMainKeybind.isModified) {
            this["main"] = realMainKeybind.toJsonElement()
        }
        if (alternativeKeybinds.isNotEmpty()) {
/*
            val altMap: Map<String, JsonElement> = alternativeKeybinds.mapIndexed { index, keybind ->
                index.toString(10) to keybind.toJsonElement()
            }.toMap()
            this["alternatives"] = JsonObject(altMap)
*/

            this["alternatives"] = buildJsonArray {
                alternativeKeybinds.forEach {
                    add(it.toJsonElement())
                }
            }
        }
    }

    override fun fromJsonObject(obj: JsonObject) {
        try {
            obj["main"]?.let { realMainKeybind.fromJsonElement(it) }
/*
            obj["alternatives"]?.jsonObject?.forEach { (index, value) ->
                index.toIntOrNull(10)?.let { i ->
                    if (i > -1 && i < alternativeKeybinds.size) {
                        alternativeKeybinds[i].fromJsonElement(value)
                    }
                }
            }
*/
            obj["alternatives"]?.jsonArray?.forEach {
                val alt = AlternativeKeybind(realMainKeybind).apply { fromJsonElement(it) }
                if (alt.isModified) alternativeKeybinds.add(alt)
            }
        } catch (e: Exception) {
            Log.warn("Failed to read JSON element '${obj["alternatives"]}' as a JSON array")
        }
    }

    override fun fromJsonElement(element: JsonElement) {
        super.fromJsonElement(element)
    }
}

open class ConfigAltHotkey(val parent: ConfigHotkey,
                           val index: Int): ConfigHotkey("", KeybindSettings.INGAME_DEFAULT) {
    override val realMainKeybind = parent.alternativeKeybinds[index]

}
