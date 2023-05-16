package org.anti_ad.mc.common.gui

import org.anti_ad.mc.common.vanilla.alias.DrawContext
//import org.anti_ad.mc.common.vanilla.alias.MatrixStack

class NativeContext(ctx: DrawContext) {

    val native: DrawContext

    init {
        native = ctx
    }
}
