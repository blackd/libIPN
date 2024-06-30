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

package org.anti_ad.mc.common.gui.widgets

import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.vanilla.VanillaSound
import org.anti_ad.mc.common.vanilla.render.*
import org.anti_ad.mc.common.vanilla.render.glue.*

open class ColorSquareWidget(aClickEvent: (Int) -> Unit) : Widget() {

    var color: () -> Int = { 100.asRed().g(100).b(100).alpha(255) }

    private var clickEvent: (Int) -> Unit

    private val baseSprite = DynamicSizeSprite(Sprite(LIBIPN_WIDGETS_TEXTURE,
                                                      Rectangle(0,
                                                                50,
                                                                10,
                                                                10)),
                                               0)

    init {
        this.clickEvent = { button ->
            VanillaSound.playClick()
            aClickEvent(button)
        }
    }

    override var text: String
        get() {
            return color().htmlColor()
        }
        set(_) {

        }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        val outlineColor = if (contains(mouseX, mouseY)) {
            255.asRed().b(255).g(255).opaque
        } else {
            0
        }
        rDrawDynamicSizeSprite(context,
                               baseSprite,
                               screenX + 1,
                               screenY + 1,
                               width - 2,
                               height - 2)

        rFillOutline(context,
                     Rectangle(screenX, screenY, width, height),
                     color(),
                     outlineColor)

        rDrawCenteredText(context,
                          text,
                          screenX + width / 2,
                          screenY + (height - 8) / 2,
                          0xffffff)
        super.render(context,
                     mouseX,
                     mouseY,
                     partialTicks)
    }


    open fun onClick(button: Int) {
        clickEvent(button)
    }

    override fun mouseClicked(x: Int,
                              y: Int,
                              button: Int): Boolean {
        super.mouseClicked(x,
                           y,
                           button)
        if (active) onClick(button)
        return true
    }
}
