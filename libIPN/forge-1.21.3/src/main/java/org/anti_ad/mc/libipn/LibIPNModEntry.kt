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

package org.anti_ad.mc.libipn

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.anti_ad.mc.common.events.OnetimeDelayedInit
import org.anti_ad.mc.libipn.forge.LibIPNClientInit
import org.anti_ad.mc.libipn.gen.ModInfo
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

@Mod(ModInfo.MOD_ID)
object LibIPNModEntry {

    init {
        val obj = runForDist(
            clientTarget = {
                MOD_BUS.addListener(::onClientSetup)
            },
            serverTarget = {
                MOD_BUS.addListener(::onServerSetup)
                "test"
            })

    }



    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        Log.info("Initializing client...")
        try {
            LibIPNClientInit(LOADING_CONTEXT).run()
            Log.info("libIPN - init in Kotlin")
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        Log.info("Server starting...")
    }

}
