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

package org.anti_ad.mc.libipn.config

import org.anti_ad.mc.common.IInputHandler
import org.anti_ad.mc.common.Savable
import org.anti_ad.mc.common.config.builder.CATEGORY
import org.anti_ad.mc.common.config.builder.*
import org.anti_ad.mc.common.extensions.htmlColorToMinecraftColor
import org.anti_ad.mc.common.input.GlobalInputHandler
import org.anti_ad.mc.common.input.KeybindSettings
import org.anti_ad.mc.common.vanilla.VanillaUtil
import org.anti_ad.mc.libipn.gui.ConfigScreeHelper
import org.anti_ad.mc.libipn.gui.ConfigScreeHelper.keyToggleBool



const val CONFIG_CATEGORY = "libIPN.config.category"

private val GUI_DEFAULT_NO_ORDER = KeybindSettings.GUI_DEFAULT.copy(orderSensitive = false)

object Demo : ConfigDeclaration {

    override val builder = createBuilder()

        .CATEGORY("§§vgap:3")
        .CATEGORY("$CONFIG_CATEGORY.demo")
    val OPEN_CONFIG_MENU                          /**/ by hotkey("",
                                                                 KeybindSettings.INGAME_DEFAULT)
    val COLOR_CHOOSER_BUTTON                      /**/ by color("#01600b8c".htmlColorToMinecraftColor(0x01600b8c)) //#8c01600b

            .CATEGORY("Second Tab")
    val COLOR_CHOOSER_BUTTON1                      /**/ by color("#01600b8c".htmlColorToMinecraftColor(0x01600b8c)) //#8c01600b

            .CATEGORY("Third Tab")
    val COLOR_CHOOSER_BUTTON2                      /**/ by color("#01600b8c".htmlColorToMinecraftColor(0x01600b8c)) //#8c01600b

    val TOGGLE_TEST                                /**/ by keyToggleBool(true, KeybindSettings.GUI_DEFAULT)

        .CATEGORY("$CONFIG_CATEGORY.debug")
    val DEBUG                                /**/ by bool(false)

        .CATEGORY("§§hide - first run")
    val FIRST_RUN                            /**/ by bool(true)
}

object Demo2 : ConfigDeclaration {

    override val builder = createBuilder()

            .CATEGORY("§§vgap:3")
            .CATEGORY("$CONFIG_CATEGORY.demo")
    val COLOR_CHOOSER_BUTTON                      /**/ by color("#01600b8c".htmlColorToMinecraftColor(0x01600b8c)) //#8c01600b

}

object Debugs: ConfigDeclaration {
    override val builder = createBuilder()

        .CATEGORY("§§vgap:3")
        .CATEGORY("$CONFIG_CATEGORY.debug")
    val TRACE_LOGS                                /**/ by bool(false)
}

fun initMainConfig() {
    registerConfigDeclaration(Demo, Demo2, Debugs)
    addInputListener()
    SaveLoadManager.load()
}

private fun addInputListener() {
    GlobalInputHandler.register(object : IInputHandler {
        override fun onInput(lastKey: Int, lastAction: Int): Boolean {

            ConfigScreeHelper.checkAll()
            return false
        }
    })
}


const val FILE_PATH = "libipn-demo-config.json"

private fun registerConfigDeclaration(vararg cd: ConfigDeclaration) {
    when (cd.size) {
        0 -> {
            return
        }
        1 -> {
            Configs.add(cd[0])
        }
        else -> {
            cd.forEach {
                Configs.add(it)
            }
        }
    }
}

val Configs = mutableListOf<ConfigDeclaration>()

object SaveLoadManager: Savable by ConfigSaveLoadManager(Configs.toMultiConfig(), "libipn",  FILE_PATH)
/*
{

    private val configFolder = VanillaUtil.configDirectory("libipn")

    private val manager: Lazy<ConfigSaveLoadManager> = lazy(LazyThreadSafetyMode.NONE) {
        ConfigSaveLoadManager(Configs.toMultiConfig(), "libipn",  FILE_PATH)
    }

    override fun load() {
        manager.value.load()
    }

    override fun save() {
        manager.value.save()
    }

}
*/
