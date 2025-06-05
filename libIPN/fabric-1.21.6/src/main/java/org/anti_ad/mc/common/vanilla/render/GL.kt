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

import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.math2d.intersect
import org.anti_ad.mc.common.vanilla.alias.Matrix4fStack
import org.anti_ad.mc.common.vanilla.alias.RenderSystem
import org.anti_ad.mc.common.vanilla.render.glue.rFillRect
import org.anti_ad.mc.common.vanilla.render.glue.rScreenBounds
import org.lwjgl.opengl.GL11

fun Matrix4fStack.push(): Matrix4fStack = this.pushMatrix()

fun Matrix4fStack.pop(): Matrix4fStack = this.popMatrix()

// ============
// api
// ============
// at Screen.render()
// do: rStandardGlState(); rClearDepth()
fun rStandardGlState() { // reset to standard state (for screen rendering)

    rEnableBlend()
    //gDisableDiffuse()
    LibIPNRenderSystem._enableDepthTest()
    LibIPNRenderSystem._depthMask(true)


}

// ============
// depth
// ============
fun rClearDepth(context: NativeContext) {
    LibIPNRenderSystem._enableDepthTest()
    LibIPNRenderSystem._depthMask(true)
    LibIPNRenderSystem._clear(GL11.GL_DEPTH_BUFFER_BIT)
    rOverwriteDepth(context,
                    rScreenBounds)
    depthBounds.clear() // added this
}

inline fun rDepthMask(context: NativeContext,
                      bounds: Rectangle,
                      block: () -> Unit) {
    //rDrawOutline(bounds, -6710887)
    rCreateDepthMask(context,
                     bounds)
    block()
    rRemoveDepthMask(context)
}

private val depthBounds = mutableListOf<Rectangle>()

//https://stackoverflow.com/questions/13742556/best-approach-to-draw-clipped-ui-elements-in-opengl
// can it be done without stencil?
// (maybe yes, if rectangle mask only)
fun rCreateDepthMask(context: NativeContext,
                     bounds: Rectangle) {
    rStandardGlState() // added this
    if (depthBounds.isEmpty()) {
        rCreateDepthMaskNoCheck(context,
                                bounds)
    } else {
        //rCreateDepthMaskNoCheck(depthBounds.last().intersect(bounds))
        rCreateDepthMaskNoCheck(context,
                                depthBounds.last().intersect(bounds))
    }
}

private fun rCreateDepthMaskNoCheck(context: NativeContext,
                                    bounds: Rectangle) {
    depthBounds.add(bounds)
    // GL11.glMatrixMode(GL11.GL_PROJECTION)
    val a = RenderSystem.getModelViewStack()
    a.push()
    a.translate(.0f,
                .0f,
                -400.0f)
    rOverwriteDepth(context,
                    bounds)
    //a.pop()
}

fun rRemoveDepthMask(context: NativeContext) {
    //rStandardGlState() // added this
    //gPopMatrix() this has already been done the 1.17 way
    val a = RenderSystem.getModelViewStack()
    a.pop()
    rOverwriteDepth(context,
                    depthBounds.removeLast())
}

private fun rOverwriteDepth(context: NativeContext,
                            bounds: Rectangle) {
//  rEnableDepth()
    LibIPNRenderSystem._depthFunc(GL11.GL_ALWAYS)

    rFillRect(context,
              bounds,
              0)
    LibIPNRenderSystem._depthFunc(GL11.GL_LEQUAL)
}

fun rDisableDepth() { // todo see if same with disableDepthTest (?)
    LibIPNRenderSystem._depthFunc(GL11.GL_ALWAYS)
    LibIPNRenderSystem._depthMask(false)
}

fun rEnableDepth() {
    LibIPNRenderSystem._depthMask(true)
    LibIPNRenderSystem._depthFunc(GL11.GL_LEQUAL)
}




// ============
// internal
// ============
private fun rEnableBlend() {
    // ref: AbstractButtonWidget.renderButton()
    LibIPNRenderSystem._enableBlend()
    LibIPNRenderSystem._blendFuncSeparate(LibIPNRenderSystem.SrcFactor.SRC_ALPHA.value,
                                      LibIPNRenderSystem.DstFactor.ONE_MINUS_SRC_ALPHA.value,
                                      LibIPNRenderSystem.SrcFactor.ONE.value,
                                      LibIPNRenderSystem.DstFactor.ZERO.value)
    LibIPNRenderSystem._blendFunc(LibIPNRenderSystem.SrcFactor.SRC_ALPHA.value, LibIPNRenderSystem.DstFactor.ONE_MINUS_SRC_ALPHA.value);
    /*RenderSystem.setShaderColor(1f, 1f, 1f, 1f)*/

}

// ============
// GlStateManager
// ============


