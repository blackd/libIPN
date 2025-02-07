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

import net.minecraft.network.chat.Style
import org.anti_ad.mc.alias.text.getLiteral
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.vanilla.Vanilla

import kotlin.math.roundToInt

object VanillaTextRenderer {
    fun wrapLines(s: String,
                  maxWidth: Int) = Vanilla.textRenderer().splitter.splitLines(getLiteral(s), // characterManager.func_238362_b_(
                                                                              maxWidth,
                                                                              Style.EMPTY).joinToString("\n") {
        it.string
    }

    fun getWidth(s: String) = Vanilla.textRenderer().width(s)

    fun drawWithShadow(context: NativeContext,
                       string: String,
                       x: Double,
                       y: Double,
                       color: Int) = context.native.drawString(Vanilla.textRenderer(),
                                                               string,
                                                               x.roundToInt(),
                                                               y.roundToInt(),
                                                               color)

    fun draw(context: NativeContext,
             string: String,
             x: Double,
             y: Double,
             color: Int) = context.native.drawString(Vanilla.textRenderer(),
                                                     string,
                                                     x.toFloat(),
                                                     y.toFloat(),
                                                     color,
                                                     false)
}
