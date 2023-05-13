package org.anti_ad.mc.common.gui

import org.anti_ad.mc.common.vanilla.alias.MatrixStack

class NativeContext(ctx: MatrixStack) {

    val native: MatrixStack

    init {
        native = ctx
    }
}
