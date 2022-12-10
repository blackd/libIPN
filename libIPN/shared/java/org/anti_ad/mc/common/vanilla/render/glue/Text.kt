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

package org.anti_ad.mc.common.vanilla.render.glue

import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.vanilla.render.VanillaTextRenderer


fun rMeasureText(string: String): Int = VanillaTextRenderer.getWidth(string)

fun rDrawText(string: String,
              x: Int,
              y: Int,
              color: Int,
              shadow: Boolean = true) {
    if (shadow) {
        VanillaTextRenderer.drawWithShadow(string,
                                           x.toDouble(),
                                           y.toDouble(),
                                           color)
    } else {
        VanillaTextRenderer.draw(string,
                                 x.toDouble(),
                                 y.toDouble(),
                                 color)
    }
}


fun rDrawCenteredText(string: String,
                      x: Int,
                      y: Int,
                      color: Int,
                      shadow: Boolean = true) {
    rDrawText(string,
              x - rMeasureText(string) / 2,
              y,
              color,
              shadow)
}

fun rDrawCenteredText(string: String,
                      bounds: Rectangle,
                      color: Int,
                      shadow: Boolean = true) { // text height = 8
    val (x, y, width, height) = bounds
    rDrawText(string,
              x + (width - rMeasureText(string)) / 2,
              y + (height - 8) / 2,
              color,
              shadow)
}

fun rWrapText(string: String,
              maxWidth: Int): String = VanillaTextRenderer.wrapLines(string,
                                                                     maxWidth)
