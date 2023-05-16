package org.anti_ad.mc.common.vanilla.alias

open class DrawableHelper() {

    fun fillGradient(native: DrawContext,
                     i: Int,
                     j: Int,
                     k: Int,
                     l: Int,
                     m: Int,
                     n: Int) {

        native.fillGradient(i,j, k,l,m,n)
    }

    fun fill(native: DrawContext,
             x1: Int,
             y1: Int,
             x2: Int,
             y2: Int,
             color: Int) {
        native.fill(x1, y1, x2, y2, color)
    }

}
