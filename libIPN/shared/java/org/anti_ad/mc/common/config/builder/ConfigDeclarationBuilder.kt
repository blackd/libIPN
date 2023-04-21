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

@file:Suppress("unused")

package org.anti_ad.mc.common.config.builder

import org.anti_ad.mc.common.config.CategorizedMultiConfig
import org.anti_ad.mc.common.config.IConfigOption
import org.anti_ad.mc.common.config.options.*
import org.anti_ad.mc.common.config.toMultiConfig
import org.anti_ad.mc.common.extensions.ByPropertyName
import org.anti_ad.mc.common.gui.widgets.ConfigButtonInfo
import org.anti_ad.mc.common.input.KeybindSettings
import org.anti_ad.mc.common.input.KeybindSettings.Companion.INGAME_DEFAULT


// ============
// api
// ============

// bool, int, hotkey, hotkeyedBool, enum
fun ConfigDeclaration.bool(defaultValue: Boolean) = ConfigBoolean(defaultValue).addTo(this)


fun ConfigDeclaration.int(defaultValue: Int,
                          minValue: Int,
                          maxValue: Int) = ConfigInteger(defaultValue,
                                                         minValue,
                                                         maxValue).addTo(this)

fun ConfigDeclaration.hotkey(defaultValue: String, defaultSettings: KeybindSettings = INGAME_DEFAULT) =
    ConfigHotkey(defaultValue,
                 defaultSettings).addTo(this)

fun ConfigDeclaration.keyToggleBool(defaultValue: Boolean,
                                    finishHandler: () -> Unit,
                                    notificationHandler: (value: Boolean, message: String) -> Unit,
                                    defaultSettings: KeybindSettings = INGAME_DEFAULT) = ConfigKeyToggleBoolean(defaultValue,
                                                                                                                finishHandler,
                                                                                                                notificationHandler,
                                                                                                                defaultSettings = defaultSettings).addTo(this)

fun <T : Enum<T>> ConfigDeclaration.enum(defaultValue: T) = ConfigEnum(defaultValue).addTo(this)

fun <T : Enum<T>> ConfigDeclaration.enumForMinMCVersion(minMCVersion:Int,
                                                        currentMCVersion: Int,
                                                        defaultValue: T) =
        if (currentMCVersion >= minMCVersion) {
            ConfigEnum(defaultValue).addTo(this)
        } else {
            ConfigEnum(defaultValue).fakeAddTo(this)
        }

fun ConfigDeclaration.string(defaultValue: String) = ConfigString(defaultValue).addTo(this)

fun ConfigDeclaration.handledStringForMinMCVersion(minMCVersion:Int,
                                                   currentMCVersion: Int,
                                                   defaultValue: String,
                                                   changeHandler: () -> Unit) =
        if (currentMCVersion >= minMCVersion) {
            HandledConfigString(defaultValue, changeHandler).addTo(this)
        } else {
            HandledConfigString(defaultValue, changeHandler).fakeAddTo(this)
        }

fun ConfigDeclaration.handledString(defaultValue: String, changeHandler: () -> Unit) =
        HandledConfigString(defaultValue, changeHandler).addTo(this)

fun ConfigDeclaration.color(defaultValue: Int) =
    ConfigColorPicker(defaultValue).addTo(this)

fun ConfigDeclaration.button(info: ConfigButtonInfo) =
    ConfigButton(info).addTo(this)

// createBuilder()
fun ConfigDeclaration.createBuilder() = ConfigDeclarationBuilder().apply {
    innerConfig.key = this@createBuilder.javaClass.simpleName
}

fun ConfigDeclaration.createBuilder(mcVersion: Int) = ConfigDeclarationBuilder().apply {
    innerConfig.key = this@createBuilder.javaClass.simpleName
}

interface ConfigDeclaration {

    val builder: ConfigDeclarationBuilder
}

// .CATEGORY()
@Suppress("FunctionName")
fun ConfigDeclarationBuilder.CATEGORY(name: String) =
    this.also { innerConfig.addCategory(name) }

class ConfigDeclarationBuilder {
    val innerConfig = CategorizedMultiConfig()
}

// ============
// internal
// ============

fun <T : IConfigOption> T.addTo(declaration: ConfigDeclaration): ConfigOptionDelegateProvider<T> {
    declaration.builder.innerConfig.addConfigOption(this)
    return ConfigOptionDelegateProvider(this,
                                        declaration)
}

fun <T : IConfigOption> T.fakeAddTo(declaration: ConfigDeclaration): ConfigOptionDelegateProvider<T> {
    return ConfigOptionDelegateProvider(this,
                                        declaration)
}

class ConfigOptionDelegateProvider<T : IConfigOption>(value: T, val declaration: ConfigDeclaration)
    : ByPropertyName<T>({ name ->
                            value.apply { key = name.lowercase() }
                        })

@Suppress("FunctionName")
fun <T : IConfigOption> ConfigOptionDelegateProvider<T>.CATEGORY(name: String) =
    this.also { declaration.builder.CATEGORY(name) }

// ============
// extensions
// ============

fun List<ConfigDeclaration>.toMultiConfig() = toMultiConfigList().toMultiConfig()

fun List<ConfigDeclaration>.toMultiConfigList(): List<CategorizedMultiConfig> = this.map {
    it.builder.innerConfig
}
