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

package org.anti_ad.mc.libipn.forge

import net.minecraft.client.Minecraft
import net.minecraftforge.client.ConfigScreenHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.IExtensionPoint
import net.minecraftforge.fml.ModLoadingContext
import org.anti_ad.mc.alias.client.gui.screen.Screen
import org.anti_ad.mc.common.forge.CommonForgeEventHandler
import org.anti_ad.mc.common.gui.screen.ConfigScreenBase

import org.anti_ad.mc.common.init
import org.anti_ad.mc.libipn.config.ConfigScreenSettings

class LibIPNClientInit(val context: ModLoadingContext): Runnable {

    override fun run() {
        init()

        MinecraftForge.EVENT_BUS.register(CommonForgeEventHandler())
        MinecraftForge.EVENT_BUS.register(ForgeTicksSource())

        context.registerExtensionPoint(IExtensionPoint.DisplayTest::class.java) {
            IExtensionPoint.DisplayTest({ context.container.modInfo.version.toString() }) { remote: String?, isServer: Boolean? ->
                true
                }
        }
        context.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory::class.java) {
            ConfigScreenHandler.ConfigScreenFactory { minecraft: Minecraft?, screen: Screen? ->
                ConfigScreenBase(ConfigScreenSettings).apply {
                    parent = screen
                    dumpWidgetTree()
                }
            }
        }
    }
}
