package org.anti_ad.mc.common.vanilla.alias

import org.anti_ad.mc.common.gui.NativeContext

open class IPNDrawableHelper : DrawableHelper() {

    fun ipnFill(context: NativeContext, x1: Int, y1: Int, x2: Int, y2: Int, color: Int) {
        fill(context.native, x1, y1, x2, y2, color)
    }

    fun ipnfillGradient(context: NativeContext, x1: Int, y1: Int, x2: Int, y2: Int, color1: Int, color2: Int) {
        fillGradient(context.native, x1,
                     y1,
                     x2,
                     y2,
                     color1,
                     color2)
    }

}
