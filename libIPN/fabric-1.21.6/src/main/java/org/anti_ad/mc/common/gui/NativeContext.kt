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

package org.anti_ad.mc.common.gui

import com.mojang.blaze3d.pipeline.RenderPipeline
import org.anti_ad.mc.alias.util.Identifier
import org.anti_ad.mc.common.vanilla.alias.DrawContext
import org.anti_ad.mc.common.vanilla.alias.RenderLayer
import org.joml.Matrix3x2fStack

data class NativeContext(val native: DrawContext,
                         var layer: RenderPipeline?): NativeContextBase() {

    fun pushMatrix(): Matrix3x2fStack  {
        val stack = native.matrices.pushMatrix()
        //FIXME this is a just make it compile fix
        native.matrices.translateLocal(0f, 0f/*, 400f*/)
        return stack
    }

    fun popMatrix(): Matrix3x2fStack {
        return native.matrices.popMatrix()
    }
}
