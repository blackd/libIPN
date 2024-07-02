package org.anti_ad.mc.common.gui

import org.anti_ad.mc.common.vanilla.alias.DrawContext

//import org.anti_ad.mc.common.vanilla.alias.DrawContext

class NativeContext(ctx: DrawContext): NativeContextBase() {

    val native: DrawContext

    init {
        native = ctx
    }
}
