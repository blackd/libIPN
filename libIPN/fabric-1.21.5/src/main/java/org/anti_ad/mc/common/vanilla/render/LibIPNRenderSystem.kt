/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2025 Plamen K. Kosseff <p.kosseff@gmail.com>
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

import com.mojang.blaze3d.systems.RenderSystem
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL14
import java.util.*

object LibIPNRenderSystem {

    val isMacOs = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("mac");

    enum class SrcFactor(val value: Int) { CONSTANT_ALPHA(32771),
        CONSTANT_COLOR(32769),
        DST_ALPHA(772),
        DST_COLOR(774),
        ONE(1),
        ONE_MINUS_CONSTANT_ALPHA(32772),
        ONE_MINUS_CONSTANT_COLOR(32770),
        ONE_MINUS_DST_ALPHA(773),
        ONE_MINUS_DST_COLOR(775),
        ONE_MINUS_SRC_ALPHA(771),
        ONE_MINUS_SRC_COLOR(769),
        SRC_ALPHA(770),
        SRC_ALPHA_SATURATE(776),
        SRC_COLOR(768),
        ZERO(0)
    }

    enum class DstFactor(val value: Int) { CONSTANT_ALPHA(32771),
        CONSTANT_COLOR(32769),
        DST_ALPHA(772),
        DST_COLOR(774),
        ONE(1),
        ONE_MINUS_CONSTANT_ALPHA(32772),
        ONE_MINUS_CONSTANT_COLOR(32770),
        ONE_MINUS_DST_ALPHA(773),
        ONE_MINUS_DST_COLOR(775),
        ONE_MINUS_SRC_ALPHA(771),
        ONE_MINUS_SRC_COLOR(769),
        SRC_ALPHA(770),
        SRC_COLOR(768),
        ZERO(0)
    }

    internal abstract class AbstractStateKeeper {
        abstract val stateId: Int
        var capState: Boolean = true
            set(value) {
                if (field != value) {
                    field = value
                    if (value) {
                        GL11.glEnable(stateId)
                    } else {
                        GL11.glDisable(stateId)
                    }
                }
            }
            get() {
               return GL11.glIsEnabled(stateId)
            }
        fun enable() {
            capState = true
        }
        fun disable() {
            capState = false
        }
    }

    internal class BlendFuncState: AbstractStateKeeper() {
        override val stateId: Int = 3042
        var srcFactorRGB: Int = 1
        var dstFactorRGB: Int = 0
        var srcFactorAlpha: Int = 1
        var dstFactorAlpha: Int = 0
    }

    private val BLEND: BlendFuncState = BlendFuncState()


    internal class DepthTestState: AbstractStateKeeper() {

        override val stateId: Int = 2929
        var mask: Boolean = true
        var func: Int = 513
    }

    private val DEPTH: DepthTestState = DepthTestState()

    fun _enableDepthTest() {
        DEPTH.enable()
    }

    fun _disableDepthTest() {
        DEPTH.disable()
    }

    fun _clear(mask: Int) {
        GL11.glClear(mask)
        if (isMacOs) {
            GL11.glGetError();
        }
    }

    fun _depthFunc(func: Int) {
        if (func != DEPTH.func) {
            DEPTH.func = func;
            GL11.glDepthFunc(func);
        }
    }

    fun _depthMask(mask: Boolean) {
        if (mask != DEPTH.mask) {
            DEPTH.mask = mask
            GL11.glDepthMask(mask)
        }
    }


    fun _blendFuncSeparate(srcFactorRGB: Int,
                           dstFactorRGB: Int,
                           srcFactorAlpha: Int,
                           dstFactorAlpha: Int) {
        if (srcFactorRGB != BLEND.srcFactorRGB ||
            dstFactorRGB != BLEND.dstFactorRGB ||
            srcFactorAlpha != BLEND.srcFactorAlpha ||
            dstFactorAlpha != BLEND.dstFactorAlpha) {
            BLEND.srcFactorRGB = srcFactorRGB
            BLEND.dstFactorRGB = dstFactorRGB
            BLEND.srcFactorAlpha = srcFactorAlpha
            BLEND.dstFactorAlpha = dstFactorAlpha
            glBlendFuncSeparate(srcFactorRGB, dstFactorRGB, srcFactorAlpha, dstFactorAlpha)
        }
    }

    fun glBlendFuncSeparate(srcFactorRGB: Int,
                            dstFactorRGB: Int,
                            srcFactorAlpha: Int,
                            dstFactorAlpha: Int) {
        GL14.glBlendFuncSeparate(srcFactorRGB, dstFactorRGB, srcFactorAlpha, dstFactorAlpha)
    }

    fun _enableBlend() {
        BLEND.enable()
    }

    fun _disableBlend() {
        BLEND.disable()
    }

    fun _blendFunc(srcFactor: Int,
                   dstFactor: Int) {
        if (srcFactor != BLEND.srcFactorRGB || dstFactor != BLEND.dstFactorRGB) {
            BLEND.srcFactorRGB = srcFactor
            BLEND.dstFactorRGB = dstFactor
            GL11.glBlendFunc(srcFactor, dstFactor)
        }
    }
}
