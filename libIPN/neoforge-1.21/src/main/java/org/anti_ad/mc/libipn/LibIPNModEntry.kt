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

import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.fml.loading.FMLEnvironment
import org.anti_ad.mc.common.events.OnetimeDelayedInit
import org.anti_ad.mc.libipn.forge.LibIPNClientInit
import org.anti_ad.mc.libipn.forge.LibIPNServerInit
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

@Mod(LibIPNModInfo.MOD_ID)
object LibIPNModEntry {

    private val toInit: Runnable = if (FMLEnvironment.dist === Dist.CLIENT) LibIPNClientInit() else LibIPNServerInit()

    init {


        OnetimeDelayedInit.register(-1000) {
            LibIPNModInfo.MOD_VERSION = LibIPNModInfo.getModVersion()
        }

        // Register the KDeferredRegister to the mod-specific event bus

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
            toInit.run()
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

    @SubscribeEvent
    fun onCommonSetup(event: FMLCommonSetupEvent) {
        Log.info("Hello! This is working!")
    }
}
