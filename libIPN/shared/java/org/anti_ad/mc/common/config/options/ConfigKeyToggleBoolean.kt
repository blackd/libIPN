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
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive
import org.anti_ad.mc.alias.text.Text
import org.anti_ad.mc.alias.text.fromSerializedJson
import org.anti_ad.mc.common.Savable
import org.anti_ad.mc.libipn.Log
import org.anti_ad.mc.common.config.IConfigElementObject
import org.anti_ad.mc.common.config.IConfigOptionPrimitive
import org.anti_ad.mc.common.config.IConfigOptionToggleable
import org.anti_ad.mc.common.config.builder.ConfigDeclaration
import org.anti_ad.mc.common.extensions.toJsonPrimitive
import org.anti_ad.mc.common.extensions.value
import org.anti_ad.mc.common.input.KeybindSettings
import org.anti_ad.mc.common.input.KeybindSettings.Companion.INGAME_DEFAULT
import org.anti_ad.mc.common.vanilla.Vanilla

abstract class BaseConfigScreenSettings {

    abstract val configScreenTitle: Text

    abstract val saveManager: Savable

    abstract val configOptionsPrefix: String

    abstract val configLabelsPrefix: String

    abstract val openConfigHotkey: ConfigHotkey?

    abstract val configDeclarations: List<ConfigDeclaration>

    open val onClosed: () -> Unit  = {}

    var storedSelectedIndex: Int = 0

    val allToggleSettings: MutableSet<ConfigKeyToggleBoolean> = mutableSetOf()

    fun checkAll() {
        val finishToCall = mutableSetOf<() -> Unit>()
        allToggleSettings.forEach {
            it.toggleIfActivated()?.also {
                finishToCall.add(it)
            }
        }
        finishToCall.forEach {
            it()
        }
    }

    fun finish() {
        saveManager.save()
    }

    fun toggleBooleanSettingMessage(value: Boolean,
                                    key: String) {
        val message: () -> String = {
            val newLine = """{"text": " : ", "color": "#FFFFFF"},"""
            val color = if (value) {
                "#1f9716"
            } else {
                "#c60926"
            }
            val yesNo = if (value) {
                "libipn.common.gui.config.on"
            } else {
                "libipn.common.gui.config.off"
            }
            val name = "${configOptionsPrefix}name.$key"

            """[
             {"translate" : "$name", "color" : "#20fdf6" },
             $newLine
             {"translate" : "$yesNo", "color": "$color"}
             ]"""
        }

        fromSerializedJson(message())?.let {
            Vanilla.inGameHud().setOverlayMessage(
                it, true)
        }
    }
}

class ConfigKeyToggleBoolean(override val defaultValue: Boolean,
                             val finish: () -> Unit = {},
                             val toggleNotificationHandler: (value: Boolean, message: String) -> Unit = { _: Boolean, _: String ->  } ,
                             defaultSettings: KeybindSettings = INGAME_DEFAULT): ConfigHotkey("", defaultSettings),
                                                                                 IConfigOptionPrimitive<Boolean>,
                                                                                 IConfigOptionToggleable,
                                                                                 IConfigElementObject {


    override var value: Boolean = defaultValue

    val booleanValue: Boolean
        get() = value

    override fun toggleNext() = run { value = !value }

    override fun togglePrevious() = run { value = !value }

    override val isModified
        get() = super<ConfigHotkey>.isModified || super<IConfigOptionPrimitive>.isModified

    override fun resetToDefault() {
        super<ConfigHotkey>.resetToDefault()
        super<IConfigOptionPrimitive>.resetToDefault()
    }

    override fun toJsonElement(): JsonObject = super<ConfigHotkey>.toJsonElement()

    override fun getConfigAsMap(): MutableMap<String, JsonElement> {
        return super.getConfigAsMap().apply {
            if (value != defaultValue) {
                this["value"] = toJsonPrimitive(value)
            }
        }
    }

    override fun fromJsonElement(element: JsonElement) {
        if (element is JsonPrimitive) {
            value = element.jsonPrimitive.value(defaultValue)
        } else if (element is JsonObject) {
            super<ConfigHotkey>.fromJsonElement(element)
        }
    }

    override fun fromJsonObject(obj: JsonObject)  {
        try {
            obj["value"]?.let {
                value = it.jsonPrimitive.value(defaultValue)
            }
        } catch (e: Exception) {
            Log.warn("Failed to read JSON element '${obj["value"]}' as a JSON array")
        }
        super<ConfigHotkey>.fromJsonObject(obj)
    }

    fun toggleIfActivated(): (() -> Unit)? {
        if (realMainKeybind.isModified && isActivated()) {
            value = !value
            toggleNotificationHandler(value, key)
            return finish
        }
        return null
    }
    

}
