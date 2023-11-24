package org.anti_ad.mc.common.vanilla.alias

import org.anti_ad.mc.common.gui.NativeContext

open class IPNDrawableHelper() {

    fun ipnfillGradient(context: NativeContext,
                     i: Int,
                     j: Int,
                     k: Int,
                     l: Int,
                     m: Int,
                     n: Int) {
        if (context.isOverlay) {
            context.native.fillGradient(RenderLayer.getGuiOverlay(), i, j, k, l, m, n, 0)
        } else {
            context.native.fillGradient(i, j, k, l, m, n)
        }
    }

    fun ipnFill(context: NativeContext,
             x1: Int,
             y1: Int,
             x2: Int,
             y2: Int,
             color: Int) {
        if (context.isOverlay) {
            context.native.fill(RenderLayer.getGuiOverlay(), x1, y1, x2, y2, 0, color)
        } else {
            context.native.fill(x1, y1, x2, y2, color)
        }
    }

}
