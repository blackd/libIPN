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

import net.neoforged.fml.ModLoadingContext
import net.neoforged.neoforge.client.gui.IConfigScreenFactory
import net.neoforged.neoforge.common.NeoForge
import org.anti_ad.mc.common.forge.CommonForgeEventHandler
import org.anti_ad.mc.common.forge.NeoForgeTicksSource
import org.anti_ad.mc.common.gui.screen.ConfigScreenBase
import org.anti_ad.mc.common.init
import org.anti_ad.mc.libipn.config.ConfigScreenSettings

class LibIPNClientInit: Runnable {

    override fun run() {

        init()

        NeoForge.EVENT_BUS.register(CommonForgeEventHandler())
        NeoForge.EVENT_BUS.register(NeoForgeTicksSource())

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory::class.java) {
            IConfigScreenFactory { _, p ->
                ConfigScreenBase(ConfigScreenSettings).apply {
                    parent = p
                    dumpWidgetTree()
                }
            }
        }
    }
}
