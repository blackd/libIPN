package org.anti_ad.mc.common.gui

import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation
import org.anti_ad.mc.common.vanilla.alias.DrawContext
import java.util.function.Function

//import org.anti_ad.mc.common.vanilla.alias.DrawContext

class NativeContext(val native: DrawContext,
                    var layer: Function<ResourceLocation, RenderType>): NativeContextBase() {

}
