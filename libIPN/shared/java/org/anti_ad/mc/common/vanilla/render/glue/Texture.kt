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

import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.math2d.*
import org.anti_ad.mc.common.math2d.Corner.*
import org.anti_ad.mc.common.vanilla.render.internal_rDrawSprite
import org.anti_ad.mc.common.vanilla.render.makeIdentifier
import org.anti_ad.mc.common.vanilla.render.rDrawDynamicSizeSprite
import org.anti_ad.mc.common.vanilla.render.vanilla_rBlit


fun rDrawDynamicSizeSprite(context: NativeContext,
                           sprite: DynamicSizeSprite,
                           x: Int,
                           y: Int,
                           width: Int,
                           height: Int,
                           mode: DynamicSizeMode = DynamicSizeMode.REPEAT_BOTH) {
    rDrawDynamicSizeSprite(context,
                           sprite,
                           Rectangle(x,
                                     y,
                                     width,
                                     height),
                           mode)
}

private fun rBlit(context: NativeContext,
                  identifier: IdentifierHolder,
                  drawArea: Rectangle,
                  spriteBounds: Rectangle,
                  textureSize: Size) {
    val (x, y, w, h) = drawArea
    val (sx, sy, sw, sh) = spriteBounds
    val (tw, th) = textureSize
    vanilla_rBlit(context,
                  identifier,
                  x, y, w, h, sx, sy, sw, sh, tw, th)
}

// ============
// sprite
// ============

fun rDrawSprite(context: NativeContext,
                sprite: Sprite,
                location: Point) = internal_rDrawSprite(context,
                                                        sprite,
                                                        0,
                                                        location.x,
                                                        location.y)

fun rDrawSprite(context: NativeContext,
                sprite: Sprite,
                x: Int,
                y: Int) = internal_rDrawSprite(context,
                                               sprite,
                                               0,
                                               x,
                                               y)

fun rDrawCenteredSprite(context: NativeContext,
                        sprite: Sprite,
                        location: Point) = rDrawCenteredSprite(context,
                                                               sprite,
                                                               location.x,
                                                               location.y)

fun rDrawCenteredSprite(context: NativeContext,
                        sprite: Sprite,
                        tIndex: Int,
                        location: Point) = rDrawCenteredSprite(context,
                                                               sprite,
                                                               tIndex,
                                                               location.x,
                                                               location.y)


fun rDrawCenteredSprite(context: NativeContext,
                        sprite: Sprite,
                        tIndex: Int,
                        x: Int,
                        y: Int) {
    val (w, h) = sprite.size
    internal_rDrawSprite(context,
                         sprite,
                         tIndex,
                         x - w / 2,
                         y - h / 2)
}

fun rDrawCenteredSprite(context: NativeContext,
                        sprite: Sprite,
                        x: Int,
                        y: Int) {
    rDrawCenteredSprite(context,
                        sprite,
                       0,
                       x,
                       y)
}


class IdentifierHolder(var id: Any) {
    constructor(ns: String, name: String) : this(makeIdentifier(ns, name))
}


data class Sprite(val identifier: IdentifierHolder,
                  val textureSize: Size,
                  val spriteBounds: Rectangle) {

    constructor(identifier: IdentifierHolder,
                spriteBounds: Rectangle, ) : this(identifier,
                                                  Size(256,
                                                       256),
                                                  spriteBounds)

    val size: Size
        get() = spriteBounds.size

    fun left(amount: Double) = right(-amount)
    fun right(amount: Double) =
        copy(spriteBounds = spriteBounds.repeatX(amount))

    fun up(amount: Double) = down(-amount)
    fun down(amount: Double) =
        copy(spriteBounds = spriteBounds.repeatY(amount))

    fun left(amount: Int = 1) = left(amount.toDouble())
    fun right(amount: Int = 1) = right(amount.toDouble())
    fun up(amount: Int = 1) = up(amount.toDouble())
    fun down(amount: Int = 1) = down(amount.toDouble())
}

class ThriSprite()

class DynamicSizeSprite(private val sprite: Sprite,
                        centerBounds: Rectangle) {
    constructor(sprite: Sprite,
                borderWidth: Int) : this(sprite,
                                         sprite.spriteBounds.inflated(-borderWidth))

    val clips = sprite.spriteBounds.split3x3(centerBounds)
    val identifier
        get() = sprite.identifier
    val textureSize
        get() = sprite.textureSize
    private val centerBounds
        get() = clips[5]
    val cornerSize // min size for no cutting corner texture
        get() = clips[0].size - clips[5].size

    private fun getCenterBounds(spriteBounds: Rectangle): Rectangle {
        return relativeBounds(centerBounds,
                              sprite.spriteBounds.location,
                              spriteBounds.location)
    }

    private val Sprite.dynamic
        get() = DynamicSizeSprite(this,
                                  getCenterBounds(spriteBounds))

    fun left(amount: Double) = sprite.left(amount).dynamic
    fun right(amount: Double) = sprite.right(amount).dynamic
    fun up(amount: Double) = sprite.up(amount).dynamic
    fun down(amount: Double) = sprite.down(amount).dynamic

    fun left(amount: Int = 1) = left(amount.toDouble())
    fun right(amount: Int = 1) = right(amount.toDouble())
    fun up(amount: Int = 1) = up(amount.toDouble())
    fun down(amount: Int = 1) = down(amount.toDouble())
}

private fun relativeBounds(fromBounds: Rectangle,
                           fromLocation: Point,
                           toLocation: Point): Rectangle {
    val location = toLocation + fromBounds.location - fromLocation
    return Rectangle(location,
                     fromBounds.size)
}

enum class DynamicSizeMode {
    STRETCH,
    REPEAT,
    REPEAT_BOTH, // repeat from both direction (left/right, top/bottom)
    ;

    // drawArea to spriteBounds
    private fun drawStretch(context: NativeContext,
                            identifier: IdentifierHolder,
                            pair: Pair<Rectangle, Rectangle>,
                            textureSize: Size) {
        val (drawArea, spriteBounds) = pair
        rBlit(context,
              identifier,
              drawArea,
              spriteBounds,
              textureSize)
    }

    private fun drawRepeat(context: NativeContext,
                           identifier: IdentifierHolder,
                           pair: Pair<Rectangle, Rectangle>,
                           textureSize: Size) {
        val (drawArea, spriteBounds) = pair
        drawRepeat(context,
                   identifier,
                   drawArea,
                   spriteBounds,
                   textureSize,
                   TOP_LEFT)
    }

    private fun drawRepeat(context: NativeContext,
                           identifier: IdentifierHolder,
                           drawArea: Rectangle,
                           spriteBounds: Rectangle,
                           textureSize: Size,
                           corner: Corner) {
        val chunked = drawArea.chunked(spriteBounds.size,
                                       corner)
        for (chunk in chunked) {
            if (chunk == spriteBounds) {
                rBlit(context,
                      identifier,
                      chunk,
                      spriteBounds,
                      textureSize) // ref: drawStretch
            } else { // trim
                val (rw, rh) = spriteBounds.size - chunk.size
                val croppedSpriteBounds = when (corner) {
                    TOP_LEFT -> spriteBounds.resizeBottomRight(-rw,
                                                               -rh)
                    TOP_RIGHT -> spriteBounds.resizeBottomLeft(rw,
                                                               -rh)
                    BOTTOM_LEFT -> spriteBounds.resizeTopRight(-rw,
                                                               rh)
                    BOTTOM_RIGHT -> spriteBounds.resizeTopLeft(rw,
                                                               rh)
                }
                rBlit(context,
                      identifier,
                      chunk,
                      croppedSpriteBounds,
                      textureSize)
            }
        }
    }

    fun draw(context: NativeContext,
             identifier: IdentifierHolder,
             drawAreas: List<Rectangle>,
             textureAreas: List<Rectangle>,
             textureSize: Size) {
        // draw corners
        val pairs = drawAreas zip textureAreas
        drawStretch(context,
                    identifier,
                    pairs[1],
                    textureSize)
        drawStretch(context,
                    identifier,
                    pairs[3],
                    textureSize)
        drawStretch(context,
                    identifier,
                    pairs[7],
                    textureSize)
        drawStretch(context,
                    identifier,
                    pairs[9],
                    textureSize)
        val (w, h) = drawAreas[5].size // if <= 0 don't draw
        when (this) {
            STRETCH, REPEAT -> {
                val draw = { index: Int ->
                    if (this == STRETCH) {
                        drawStretch(context, identifier, pairs[index], textureSize)
                    }
                    else {
                        drawRepeat(context, identifier, pairs[index], textureSize)
                    }
                }
                if (w > 0) {
                    draw(2)
                    draw(8)
                }
                if (h > 0) {
                    draw(4)
                    draw(6)
                }
                if (w > 0 && h > 0) {
                    draw(5)
                }
            }
            REPEAT_BOTH -> {
                if (w > 0) {
                    val (a, b) = drawAreas[2].splitWidth()
                    val (c, d) = drawAreas[8].splitWidth()
                    drawRepeat(context,
                               identifier,
                               a,
                               textureAreas[2],
                               textureSize,
                               TOP_LEFT)
                    drawRepeat(context,
                               identifier,
                               b,
                               textureAreas[2],
                               textureSize,
                               TOP_RIGHT)
                    drawRepeat(context,
                               identifier,
                               c,
                               textureAreas[8],
                               textureSize,
                               BOTTOM_LEFT)
                    drawRepeat(context,
                               identifier,
                               d,
                               textureAreas[8],
                               textureSize,
                               BOTTOM_RIGHT)
                }
                if (h > 0) {
                    val (a, b) = drawAreas[4].splitHeight()
                    val (c, d) = drawAreas[6].splitHeight()
                    drawRepeat(context,
                               identifier,
                               a,
                               textureAreas[4],
                               textureSize,
                               TOP_LEFT)
                    drawRepeat(context,
                               identifier,
                               b,
                               textureAreas[4],
                               textureSize,
                               BOTTOM_LEFT)
                    drawRepeat(context,
                               identifier,
                               c,
                               textureAreas[6],
                               textureSize,
                               TOP_RIGHT)
                    drawRepeat(context,
                               identifier,
                               d,
                               textureAreas[6],
                               textureSize,
                               BOTTOM_RIGHT)
                }
                if (w > 0 && h > 0) {
                    val (a, b, c, d) = drawAreas[5].split()
                    drawRepeat(context,
                               identifier,
                               a,
                               textureAreas[5],
                               textureSize,
                               TOP_LEFT)
                    drawRepeat(context,
                               identifier,
                               b,
                               textureAreas[5],
                               textureSize,
                               TOP_RIGHT)
                    drawRepeat(context,
                               identifier,
                               c,
                               textureAreas[5],
                               textureSize,
                               BOTTOM_LEFT)
                    drawRepeat(context,
                               identifier,
                               d,
                               textureAreas[5],
                               textureSize,
                               BOTTOM_RIGHT)
                }
            }
        }
    }
}


private fun Rectangle.splitWidth(aw: Int = width / 2): Pair<Rectangle, Rectangle> {
    return copy(width = aw) to resizeLeft(aw)
}

private fun Rectangle.splitHeight(ah: Int = height / 2): Pair<Rectangle, Rectangle> {
    return copy(height = ah) to resizeTop(ah)
}

private fun Rectangle.split(aw: Int = width / 2,
                            ah: Int = height / 2): List<Rectangle> {
    val pair = splitHeight(ah)
    val (a, b) = pair.first.splitWidth(aw)
    val (c, d) = pair.second.splitWidth(aw)
    return listOf(a,
                  b,
                  c,
                  d)
}
