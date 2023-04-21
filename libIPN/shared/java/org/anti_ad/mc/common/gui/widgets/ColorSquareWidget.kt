package org.anti_ad.mc.common.gui.widgets

import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.vanilla.VanillaSound
import org.anti_ad.mc.common.vanilla.render.*
import org.anti_ad.mc.common.vanilla.render.glue.*

open class ColorSquareWidget(aClickEvent: (Int) -> Unit) : Widget() {

    var color: () -> Int = { 100.asRed().g(100).b(100).alpha(255) }

    private var clickEvent: (Int) -> Unit

    private val baseSprite = DynamicSizeSprite(Sprite(LIBIPN_WIDGETS_TEXTURE,
                                                      Rectangle(0,
                                                                50,
                                                                10,
                                                                10)),
                                               0)

    init {
        this.clickEvent = { button ->
            VanillaSound.playClick()
            aClickEvent(button)
        }
    }

    override var text: String
        get() {
            return color().htmlColor()
        }
        set(_) {

        }

    override fun render(mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        val outlineColor = if (contains(mouseX, mouseY)) {
            255.asRed().b(255).g(255).opaque
        } else {
            0
        }
        rDrawDynamicSizeSprite(baseSprite,
                               screenX + 1,
                               screenY + 1,
                               width - 2,
                               height - 2)

        rFillOutline(Rectangle(screenX, screenY, width, height),
                     color(),
                     outlineColor)

        rDrawCenteredText(text,
                          screenX + width / 2,
                          screenY + (height - 8) / 2,
                          0xffffff)
        super.render(mouseX,
                     mouseY,
                     partialTicks)
    }


    open fun onClick(button: Int) {
        clickEvent(button)
    }

    override fun mouseClicked(x: Int,
                              y: Int,
                              button: Int): Boolean {
        super.mouseClicked(x,
                           y,
                           button)
        if (active) onClick(button)
        return true
    }
}
