/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2024 Plamen K. Kosseff <p.kosseff@gmail.com>
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

package org.anti_ad.mc.common.vanilla.alias

import org.anti_ad.mc.alias.client.gui.screen.Screen
import org.anti_ad.mc.alias.client.gui.screen.ingame.ContainerScreen
import org.anti_ad.mc.common.gui.NativeContext

open class IPNDrawableHelper() {

    fun ipnfillGradient(context: NativeContext,
                        i: Int,
                        j: Int,
                        k: Int,
                        l: Int,
                        m: Int,
                        n: Int) {

        val overlay = if (context.isOverlay) {
            RenderLayer.getGuiOverlay()
        } else if (context.layer != null && context.isSlotBackground) {
            context.layer!!(ContainerScreen.SLOT_HIGHLIGHT_BACK_TEXTURE)
        } else {
            RenderLayer.getGui()
        }
        context.native.fillGradient(overlay, i, j, k, l, m, n, 0)

    }

    fun ipnFill(context: NativeContext,
             x1: Int,
             y1: Int,
             x2: Int,
             y2: Int,
             color: Int) {
        val overlay = if (context.isOverlay) {
            RenderLayer.getGuiOverlay()
        } else if (context.layer != null && context.isSlotBackground) {
            context.layer!!(ContainerScreen.SLOT_HIGHLIGHT_BACK_TEXTURE)
        } else {
            RenderLayer.getGui()
        }
        context.native.fill(overlay, x1, y1, x2, y2, 0, color)
    }

}
