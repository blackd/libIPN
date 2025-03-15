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

@file:Suppress("unused")


package org.anti_ad.mc.common

import org.anti_ad.mc.common.events.OnetimeDelayedInit
import org.anti_ad.mc.common.gui.screen.ConfigScreenBase
import org.anti_ad.mc.common.vanilla.Vanilla.mc
import org.anti_ad.mc.libipn.Log
import org.anti_ad.mc.libipn.config.ConfigScreenSettings
import kotlin.concurrent.timer

@Suppress("unused")
fun init() {
    try {
        ConfigScreenSettings.initMainConfig()
    } catch (t: Throwable) {
        t.printStackTrace()
    }
    OnetimeDelayedInit.init()


/*
    timer("", true, 30000, 120000) {
        Log.error("showing config")
        this.cancel()
        mc().execute {
            mc().setScreen(ConfigScreenBase(ConfigScreenSettings))
        }
    }
*/
}
