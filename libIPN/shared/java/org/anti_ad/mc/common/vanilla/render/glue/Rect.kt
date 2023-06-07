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

@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package org.anti_ad.mc.common.vanilla.render.glue


import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.layout.AnchorStyles
import org.anti_ad.mc.common.math2d.Point
import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.vanilla.alias.IPNDrawableHelper

object DrawableHelperAccess: IPNDrawableHelper() {

    fun fillRect(context: NativeContext,
                 x1: Int,
                 y1: Int,
                 x2: Int,
                 y2: Int,
                 color: Int) {
        ipnFill(context, x1, y1, x2, y2, color)
    }


}

// top to bottom
fun rFillGradient(context: NativeContext,
                  x1: Int,
                  y1: Int,
                  x2: Int,
                  y2: Int,
                  color1: Int,
                  color2: Int) {
    DrawableHelperAccess.ipnfillGradient(context,
                                      x1,
                                      y1,
                                      x2,
                                      y2,
                                      color1,
                                      color2)
}

fun rFillGradient(context: NativeContext,
                  bounds: Rectangle,
                  color1: Int,
                  color2: Int) {
    rFillGradient(context,
                  bounds.left,
                  bounds.top,
                  bounds.right,
                  bounds.bottom,
                  color1,
                  color2)
}

// ============
// fill rect
// ============

fun rFillRect(context: NativeContext,
              x1: Int,
              y1: Int,
              x2: Int,
              y2: Int,
              color: Int) {
    DrawableHelperAccess.fillRect(context, x1, y1, x2, y2, color)
}

fun rFillRect(context: NativeContext,
              bounds: Rectangle,
              color: Int) {
    rFillRect(context,
              bounds.left,
              bounds.top,
              bounds.right,
              bounds.bottom,
              color)
}

fun rFillOutline(context: NativeContext,
                 bounds: Rectangle,
                 fillColor: Int,
                 outlineColor: Int) {
    rFillRect(context,
              bounds.inflated(-1),
              fillColor)
    rDrawOutline(context,
                 bounds,
                 outlineColor)
}

fun rFillOutline(context: NativeContext,
                 bounds: Rectangle,
                 fillColor: Int,
                 outlineColor: Int,
                 top: Boolean,
                 bottom: Boolean,
                 left: Boolean,
                 right: Boolean, // border switch
                 outlineWidth: Int = 1) {
    val (l, lz) = outlineWidth to outlineWidth * 2
    val (x, y, width, height) = bounds
    listOf(
        //@formatter:off
        (top || left) to Rectangle(x,
                                   y,
                                   l,
                                   l),
        (top) to Rectangle(x + l,
                           y,
                           width - lz,
                           l),
        (top || right) to Rectangle(x + width - l,
                                    y,
                                    l,
                                    l),
        (left) to Rectangle(x,
                            y + l,
                            l,
                            height - lz),
        false to Rectangle(x + l,
                           y + l,
                           width - lz,
                           height - lz),
        (right) to Rectangle(x + width - l,
                             y + l,
                             l,
                             height - lz),
        (bottom || left) to Rectangle(x,
                                      y + height - l,
                                      l,
                                      l),
        (bottom) to Rectangle(x + l,
                              y + height - l,
                              width - lz,
                              l),
        (bottom || right) to Rectangle(x + width - l,
                                       y + height - l,
                                       l,
                                       l),
        //@formatter:on
    ).forEach { (outline, rect) ->
        rFillRect(context,
                  rect,
                  if (outline) outlineColor else fillColor)
    }
}

fun rFillOutline(context: NativeContext,
                 bounds: Rectangle,
                 fillColor: Int,
                 outlineColor: Int,
                 borders: AnchorStyles,
                 outlineWidth: Int = 1) {
    val (top, bottom, left, right) = borders
    rFillOutline(context,
                 bounds,
                 fillColor,
                 outlineColor,
                 top,
                 bottom,
                 left,
                 right,
                 outlineWidth)
}

fun rDrawPixel(context: NativeContext,
               x: Int,
               y: Int,
               color: Int) {
    rFillRect(context,
              x,
              y,
              x + 1,
              y + 1,
              color)
}

fun rDrawPixel(context: NativeContext,
               point: Point,
               color: Int) {
    rDrawPixel(context,
               point.x,
               point.y,
               color)
}

// fix 1.14.4 DrawableHelper hLine/vLine offsetted by 1 px
fun rDrawHorizontalLine(context: NativeContext,
                        x1: Int,
                        x2: Int,
                        y: Int,
                        color: Int) { // x1 x2 inclusive
    val (xLeast, xMost) = if (x2 < x1) x2 to x1 else x1 to x2
    rFillRect(context,
              xLeast,
              y,
              xMost + 1,
              y + 1,
              color)
}

fun rDrawVerticalLine(context: NativeContext,
                      x: Int,
                      y1: Int,
                      y2: Int,
                      color: Int) { // y1 y2 inclusive
    val (yLeast, yMost) = if (y2 < y1) y2 to y1 else y1 to y2
    rFillRect(context,
              x,
              yLeast,
              x + 1,
              yMost + 1,
              color)
}

fun rDrawOutline(context: NativeContext,
                 x1: Int,
                 y1: Int,
                 x2: Int,
                 y2: Int,
                 color: Int) { // same size with fill(...)
    rInclusiveOutline(context,
                      x1,
                      y1,
                      x2 - 1,
                      y2 - 1,
                      color)
}

fun rDrawOutline(context: NativeContext,
                 bounds: Rectangle,
                 color: Int) { // same size with fill(...)
    rDrawOutline(context,
                 bounds.left,
                 bounds.top,
                 bounds.right,
                 bounds.bottom,
                 color)
}

fun rDrawOutlineNoCorner(context: NativeContext,
                         bounds: Rectangle,
                         color: Int) {
    rInclusiveOutlineNoCorner(context,
                              bounds.left,
                              bounds.top,
                              bounds.right - 1,
                              bounds.bottom - 1,
                              color)
}

// top to bottom
fun rDrawOutlineGradient(context: NativeContext,
                         bounds: Rectangle,
                         color1: Int,
                         color2: Int) { // full top/bottom, -2 left/right
    with(bounds) {
        rFillRect(context,
                  copy(height = 1),
                  color1)
        rFillRect(context,
                  copy(y = bottom - 1,
                       height = 1),
                  color2)
        rFillGradient(context,
                      Rectangle(x,
                                y + 1,
                                1,
                                height - 2),
                      color1,
                      color2)
        rFillGradient(context,
                      Rectangle(right - 1,
                                y + 1,
                                1,
                                height - 2),
                      color1,
                      color2)
    }
}

// ============
// private
// ============

private fun rInclusiveOutline(context: NativeContext,
                              x1: Int,
                              y1: Int,
                              x2: Int,
                              y2: Int,
                              color: Int) {
    rDrawHorizontalLine(context,
                        x1,
                        x2,
                        y1,
                        color)
    rDrawHorizontalLine(context,
                        x1,
                        x2,
                        y2,
                        color)
    rDrawVerticalLine(context,
                      x1,
                      y1 + 1,
                      y2 - 1,
                      color) // -2
    rDrawVerticalLine(context,
                      x2,
                      y1 + 1,
                      y2 - 1,
                      color) // -2
}

private fun rInclusiveOutlineNoCorner(context: NativeContext,
                                      x1: Int,
                                      y1: Int,
                                      x2: Int,
                                      y2: Int,
                                      color: Int) {
    rDrawHorizontalLine(context,
                        x1 + 1,
                        x2 - 1,
                        y1,
                        color)
    rDrawHorizontalLine(context,
                        x1 + 1,
                        x2 - 1,
                        y2,
                        color)
    rDrawVerticalLine(context,
                      x1,
                      y1 + 1,
                      y2 - 1,
                      color) // -2
    rDrawVerticalLine(context,
                      x2,
                      y1 + 1,
                      y2 - 1,
                      color) // -2
}
