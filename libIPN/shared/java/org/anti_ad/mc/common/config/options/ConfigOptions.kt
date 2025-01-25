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
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.jsonPrimitive
import org.anti_ad.mc.libipn.Log
import org.anti_ad.mc.common.config.ConfigOptionBase
import org.anti_ad.mc.common.config.ConfigOptionNumericBase
import org.anti_ad.mc.common.config.IConfigOptionPrimitive
import org.anti_ad.mc.common.config.IConfigOptionToggleable
import org.anti_ad.mc.common.extensions.*
import org.anti_ad.mc.common.gui.widgets.ConfigButtonInfo
import org.anti_ad.mc.common.vanilla.render.*

open class ConfigDouble(defaultValue: Double,
                   minValue: Double,
                   maxValue: Double) : ConfigOptionNumericBase<Double>(defaultValue,
                                                                       minValue,
                                                                       maxValue) {

    override fun setNumericValue(value: Number) = run {
        this.value = value.toDouble()
    }

    val doubleValue
        get() = value
}

open class ConfigInteger(defaultValue: Int,
                    minValue: Int,
                    maxValue: Int) :
    ConfigOptionNumericBase<Int>(defaultValue,
                                 minValue,
                                 maxValue) {
    override fun setNumericValue(value: Number) = run { this.value = value.toInt() }
    val integerValue
        get() = value
}

open class ConfigBoolean(override val defaultValue: Boolean,
                         val assignKey: Boolean = false): ConfigOptionBase(), IConfigOptionPrimitive<Boolean>, IConfigOptionToggleable {

    override var value = defaultValue
    override fun toggleNext() = run { value = !value }
    override fun togglePrevious() = run { value = !value }
    val booleanValue
        get() = value
}

open class ConfigEnum<E : Enum<E>>(override val defaultValue: E) : ConfigOptionBase(), IConfigOptionPrimitive<E>, IConfigOptionToggleable {
    override var value = defaultValue
    override fun toggleNext() = run { value = value.next() }
    override fun togglePrevious() = run { value = value.previous() }
}


open class ConfigColorPicker(override val defaultValue: Int) : ConfigOptionBase(), IConfigOptionPrimitive<Int> {

    override var value: Int = defaultValue

    private var valueAsString: String
        get() {
            return value.htmlColor()
        }
        set(v) {
            value = v.htmlColorToMinecraftColor(defaultValue)
        }

    override fun toJsonElement(): JsonElement = toJsonPrimitive(valueAsString)
    override fun fromJsonElement(element: JsonElement) {
        resetToDefault()
        try {
            valueAsString = element.jsonPrimitive.value(defaultValue.htmlColor())
        } catch (e: Exception) {
            Log.warn("Failed to set config value for '$key' from the JSON element '$element'")
        }
    }

    fun copy(): ConfigColorPicker {
        return ConfigColorPicker(defaultValue).apply {
            value = this@ConfigColorPicker.value
        }
    }
}


open class HandledConfigString(override val defaultValue: String, val changeHandler: () -> Unit) : ConfigString(defaultValue), IConfigOptionPrimitive<String> {
    override var value = defaultValue
        set(value) {
            field = value
            changeHandler()
        }
}

open class ConfigString(override val defaultValue: String) : ConfigOptionBase(), IConfigOptionPrimitive<String> {
    override var value = defaultValue
}

open class ConfigButton(val info: ConfigButtonInfo) : ConfigOptionBase() { // fake config that acts as button

    override fun toJsonElement(): JsonElement {
        Log.error("this is a config button") // shouldn't be called
        return JsonNull
    }

    override fun fromJsonElement(element: JsonElement) {
        Log.warn("this is a config button $element")
    }

    override val isModified = false
    override fun resetToDefault() {}
}
