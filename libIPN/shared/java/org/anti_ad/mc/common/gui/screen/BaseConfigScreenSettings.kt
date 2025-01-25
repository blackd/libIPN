/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2025 Plamen K. Kosseff <p.kosseff@gmail.com>
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

package org.anti_ad.mc.common.gui.screen

import org.anti_ad.mc.alias.text.Text
import org.anti_ad.mc.alias.text.fromSerializedJson
import org.anti_ad.mc.common.IInputHandler
import org.anti_ad.mc.common.Savable
import org.anti_ad.mc.common.config.builder.ConfigDeclaration
import org.anti_ad.mc.common.config.options.ConfigHotkey
import org.anti_ad.mc.common.config.options.ConfigKeyToggleBoolean
import org.anti_ad.mc.common.input.GlobalInputHandler
import org.anti_ad.mc.common.vanilla.Vanilla
import org.anti_ad.mc.common.vanilla.VanillaScreenUtil

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

    private fun addInputListener() {
        GlobalInputHandler.register(object : IInputHandler {
            override fun onInput(lastKey: Int, lastAction: Int): Boolean {
                checkAll()
                val hotkey = openConfigHotkey
                if (hotkey?.isActivated() == true) {
                    VanillaScreenUtil.openScreen(ConfigScreenBase(this@BaseConfigScreenSettings))
                }
                return false
            }
        })
    }

    open fun initMainConfig() {
        addInputListener()
        saveManager.load()
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
