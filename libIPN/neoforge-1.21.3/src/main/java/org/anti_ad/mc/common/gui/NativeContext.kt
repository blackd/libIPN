package org.anti_ad.mc.common.gui

import net.minecraft.client.renderer.RenderType
import org.anti_ad.mc.alias.util.Identifier
import org.anti_ad.mc.common.vanilla.alias.DrawContext

//import org.anti_ad.mc.common.vanilla.alias.DrawContext

class NativeContext(val native: DrawContext,
                    var layer: ((Identifier) -> RenderType)?): NativeContextBase() {

}
