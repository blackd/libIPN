package org.anti_ad.mc.common.vanilla.alias

import net.minecraft.client.renderer.RenderType
import org.anti_ad.mc.common.gui.NativeContext

open class IPNDrawableHelper {

    fun ipnFill(context: NativeContext, x1: Int, y1: Int, x2: Int, y2: Int, color: Int) {
        if (context.isOverlay) {
            context.native.fill(RenderType.guiOverlay(), x1, y1, x2, y2, color)
        } else {
            context.native.fill(x1, y1, x2, y2, color)
        }
    }

    fun ipnfillGradient(context: NativeContext, x1: Int, y1: Int, x2: Int, y2: Int, color1: Int, color2: Int) {
        if (context.isOverlay) {
            context.native.fillGradient(RenderType.guiOverlay(),
                                        x1,
                                        y1,
                                        x2,
                                        y2,
                                        color1,
                                        color2,
                                        0)
        } else {
            context.native.fillGradient(x1,
                                        y1,
                                        x2,
                                        y2,
                                        color1,
                                        color2)
        }
    }

}
