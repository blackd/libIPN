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

package org.anti_ad.mc.common.vanilla.render

import org.anti_ad.mc.alias.util.Identifier
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.math2d.resizeBottom
import org.anti_ad.mc.common.math2d.resizeBottomLeft
import org.anti_ad.mc.common.math2d.resizeBottomRight
import org.anti_ad.mc.common.math2d.resizeLeft
import org.anti_ad.mc.common.math2d.resizeRight
import org.anti_ad.mc.common.math2d.resizeTop
import org.anti_ad.mc.common.math2d.resizeTopLeft
import org.anti_ad.mc.common.math2d.resizeTopRight
import org.anti_ad.mc.common.math2d.split3x3
import org.anti_ad.mc.common.vanilla.alias.RenderSystem
import org.anti_ad.mc.common.vanilla.render.glue.DynamicSizeMode
import org.anti_ad.mc.common.vanilla.render.glue.DynamicSizeSprite
import org.anti_ad.mc.common.vanilla.render.glue.IdentifierHolder
import org.anti_ad.mc.common.vanilla.render.glue.Sprite

inline operator fun IdentifierHolder.invoke(): Identifier {
    return this.id as Identifier
}


fun makeIdentifier(ns: String, path: String): Any {
    return Identifier.fromNamespaceAndPath (ns, path)
}

// screen xy wh sprite xy wh texture wh
fun vanilla_rBlit(context: NativeContext,
                  identifier: IdentifierHolder,
                  x: Int,
                  y: Int,
                  w: Int,
                  h: Int,
                  sx: Int,
                  sy: Int,
                  sw: Int,
                  sh: Int,
                  tw: Int,
                  th: Int) {
    context.native.blit(context.layer!!,
                        identifier(),
                        x,
                        y,
                        sx.toFloat(),
                        sy.toFloat(),
                        w,
                        h,
                        sw,
                        sh,
                        tw,
                        th)
}



//private fun rBlit(screenLocation: Point, textureLocation: Point, size: Size) {
//  rBlit(screenLocation.x, screenLocation.y, textureLocation.x, textureLocation.y, size.width, size.height)
//}



fun internal_rDrawSprite(context: NativeContext,
                         sprite: Sprite,
                         tIndex: Int,
                         x: Int,
                         y: Int) {
    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)
    /*
    RenderSystem.setShaderTexture(tIndex,
                                  sprite.identifier())
    */
    RenderSystem.disableDepthTest();
    //rBindTexture(sprite.identifier)
    val (sx, sy, sw, sh) = sprite.spriteBounds
    val (tw, th) = sprite.textureSize
    vanilla_rBlit(context,
                  sprite.identifier,
                  x, y, sw, sh, sx,
                  sy, sw, sh, tw, th)
    RenderSystem.enableDepthTest();
}



// ============
// dynamic
// ============



private fun Int.split(a: Int = this / 2): Pair<Int, Int> {
    return a to this - a
}


private fun resizeClips(clips: List<Rectangle>,
                        xLeft: Int,
                        xRight: Int,
                        yTop: Int,
                        yBottom: Int): List<Rectangle> {
    return listOf(
        clips[0],
        clips[1].resizeBottomRight(xLeft,
                                   yTop),
        clips[2].resizeBottom(yTop),
        clips[3].resizeBottomLeft(xRight,
                                  yTop),
        clips[4].resizeRight(xLeft),
        clips[5], //.resizeTopLeft(xLeft, yTop).resizeBottomRight(xRight, yBottom),
        clips[6].resizeLeft(xRight),
        clips[7].resizeTopRight(xLeft,
                                yBottom),
        clips[8].resizeTop(yBottom),
        clips[9].resizeTopLeft(xRight,
                               yBottom),
    )
}

fun rDrawDynamicSizeSprite(context: NativeContext,
                           sprite: DynamicSizeSprite,
                           bounds: Rectangle,
                           mode: DynamicSizeMode = DynamicSizeMode.REPEAT_BOTH) {

    val (x, y, width, height) = bounds
    // draw corners
    val (cornerWidth, cornerHeight) = sprite.cornerSize
    val tw = width - cornerWidth // clips[2] or clips[8] width
    val th = height - cornerHeight // clips[4] or clips[6] height
    val (aw, bw) = (-tw).coerceAtLeast(0).split() // trimmed border
    val (ah, bh) = (-th).coerceAtLeast(0).split()

    val textureAreas = resizeClips(sprite.clips,
                                   aw,
                                   bw,
                                   ah,
                                   bh)
    val drawAreas = bounds.split3x3(textureAreas[1].size,
                                    textureAreas[9].size)


    mode.draw(context,
              sprite.identifier,
              drawAreas,
              textureAreas,
              sprite.textureSize)
}
