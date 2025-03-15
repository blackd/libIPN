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

package org.anti_ad.mc.common.gui.screen

import org.anti_ad.mc.alias.text.Text
import org.anti_ad.mc.common.extensions.ifTrue
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.layout.AnchorStyles
import org.anti_ad.mc.common.gui.layout.moveToCenter
import org.anti_ad.mc.common.gui.widgets.Widget
import org.anti_ad.mc.common.vanilla.render.alpha
import org.anti_ad.mc.common.vanilla.render.blue
import org.anti_ad.mc.common.vanilla.render.glue.rFillOutline
import org.anti_ad.mc.common.vanilla.render.glue.rRenderBlackOverlay
import org.anti_ad.mc.common.vanilla.render.green
import org.anti_ad.mc.common.vanilla.render.rDepthMask
import org.anti_ad.mc.common.vanilla.render.red

private const val COLOR_BORDER = -0x666667
private val COLOR_BG = 0.alpha(255).red(0).green(0).blue(0).toInt()

open class BaseDialog : BaseOverlay {
    constructor(text: Text) : super(text)
    constructor() : super()

    var renderBlackOverlay = true
    var closeWhenClickOutside = true

    val dialogWidget =
        object : Widget() {
            override fun render(context: NativeContext,
                                mouseX: Int,
                                mouseY: Int,
                                partialTicks: Float) {
/*
                val oldContext = context.isOverlay
                context.isOverlay = true
*/
                rFillOutline(context, absoluteBounds, COLOR_BG, COLOR_BORDER)
                super.render(context, mouseX, mouseY, partialTicks)
/*
                context.isOverlay = oldContext
*/
            }
        }.apply {
            anchor = AnchorStyles.none
            addWidget(this)
            moveToCenter()
            sizeChanged += {
                moveToCenter()
            }
            rootWidget.mouseClicked += { (x, y, button), handled ->
                handled || (button == 0 && closeWhenClickOutside && !contains(x,
                                                                              y)).ifTrue { closeScreen() }
            }
        }

    override fun renderParentPost(context: NativeContext,
                                  mouseX: Int,
                                  mouseY: Int,
                                  partialTicks: Float) {
        if (renderBlackOverlay) {
            val oldOverlay = context.isOverlay
            context.isOverlay = true
            rRenderBlackOverlay(context)
            context.isOverlay = oldOverlay
        }
    }
}
