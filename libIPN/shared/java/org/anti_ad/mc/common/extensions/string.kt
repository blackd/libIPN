/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2022 Plamen K. Kosseff <p.kosseff@gmail.com>
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

package org.anti_ad.mc.common.extensions

import org.anti_ad.mc.common.vanilla.render.*
import org.anti_ad.mc.libipn.Log

fun String.dashedSanitized(): String {
    if (this == ".." || this == ".") return "-dot_dot"
    return if (this.isNotEmpty()) {
        "-" + this.sanitized()
    } else {
        this
    }
}

fun String.sanitized(): String {
    if (this == ".." || this == ".") return "-dot_dot"
    return if (this.isNotEmpty()) {
        this.replace("/","(slash)")
            .replace("\\","(bslash)")
            .replace(":", "(colon)")
            .replace("<", "(lt)")
            .replace(">","(gt)")
            .replace("|","(pipe)")
            .replace("?","(qm)")
            .replace("*", "(asterisk)")
            .replace("\"","(dquote)")
    } else {
        this
    }
}



fun String.htmlColorToMinecraftColor(defaultValue: Int): Int {
    return if (this[0] == '#') {
        val colors =  drop(1).chunked(2).map { it.toInt(16) }
        try {
            if (colors.size == 3) {
                val r = colors[0].asRed()
                val g = colors[1].asGreen()
                val b = colors[2].asBlue()
                255.asAlpha() or b or g or r
            } else {
                val r = colors[0].asRed()
                val g = colors[1].asGreen()
                val b = colors[2].asBlue()
                val a = colors[3].asAlpha()
                a or b or g or r
            }
        } catch (nfe: NumberFormatException) {
            Log.error("Cannot convert '$this' to color, using default '${defaultValue.htmlColor()}'. Invalid format!", nfe)
            defaultValue
        }
    } else {
        Log.error("Cannot convert '$this' to color, using default '${defaultValue.htmlColor()}'. Invalid format!")
        defaultValue
    }
}
