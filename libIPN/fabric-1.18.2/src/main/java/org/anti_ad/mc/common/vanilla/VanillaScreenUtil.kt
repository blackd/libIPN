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

package org.anti_ad.mc.common.vanilla

import org.anti_ad.mc.common.config.options.ConfigHotkey
import org.anti_ad.mc.common.gui.screen.ConfigOptionHotkeyDialog
import org.anti_ad.mc.common.vanilla.alias.Screen
import org.anti_ad.mc.common.vanilla.glue.IScreenMarker

object VanillaScreenUtil {
    fun closeScreen() = Vanilla.mc().setScreen(null)
    fun openScreen(screen: IScreenMarker) = Vanilla.mc().setScreen(screen as Screen)
    fun openScreenNullable(screen: IScreenMarker?) = Vanilla.mc().setScreen(screen as Screen)
    fun openDistinctScreen(screen: IScreenMarker) { // do nothing if screen is same type as current
        if (Vanilla.screen()?.javaClass != screen.javaClass) openScreen(screen)
    }

    fun openDistinctScreenQuiet(screen: IScreenMarker) { // don't trigger Screen.remove()
        if (Vanilla.screen()?.javaClass != screen.javaClass) {
            Vanilla.mc().currentScreen = null
            openScreen(screen)

        }
    }

    fun openScreenConfigOptionHotkeyDialog(configOption: ConfigHotkey) {
        openScreen(ConfigOptionHotkeyDialog(configOption))
    }

    fun closeScreenGracefully() {
        Vanilla.screen()?.close()
        Vanilla.mc().setScreen(null)
    }

    fun openScreenNullable(screen: Screen?) {
        Vanilla.mc().setScreen(screen)
    }
}
