/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2019-2020 jsnimda <7615255+jsnimda@users.noreply.github.com>
 *   Copyright (c) 2021-2022 Plamen K. Kosseff <p.kosseff@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anti_ad.mc.common.gui.widgets

import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.widgets.glue.IButtonWidget
import org.anti_ad.mc.common.gui.widgets.glue.ISliderWidget
import org.anti_ad.mc.common.gui.widgets.glue.ITextFieldWidget
import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.math2d.Size
import org.anti_ad.mc.common.vanilla.Vanilla
import org.anti_ad.mc.common.vanilla.VanillaSound
import org.anti_ad.mc.common.vanilla.alias.*
import org.anti_ad.mc.common.vanilla.render.glue.DynamicSizeSprite
import org.anti_ad.mc.common.vanilla.render.glue.IdentifierHolder
import org.anti_ad.mc.common.vanilla.render.glue.Sprite
import org.anti_ad.mc.common.vanilla.render.glue.rDrawCenteredText
import org.anti_ad.mc.common.vanilla.render.rDrawDynamicSizeSprite
import org.anti_ad.mc.common.vanilla.render.rStandardGlState
import org.anti_ad.mc.common.vanilla.alias.SliderWidget as VanillaSliderWidget
import org.anti_ad.mc.common.vanilla.alias.TextFieldWidget as VanillaTextFieldWidget

// ============
// vanillamapping code depends on mappings
// ============

open class VanillaWidget<T : AbstractWidget>(val vanilla: T) : Widget() {
    init {
        sizeChanged += {
            vanilla.width = width
            // TODO set height
        }
        screenLocationChanged += {
            vanilla.x = screenX
            vanilla.y = screenY
        }
    }

    var vanillaMessage: String
        get() = vanilla.message.string //asString()
        //    get() = vanilla.func_230458_i_().unformattedComponentText
        set(value) {
            vanilla.message = getLiteral(value)
        }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        rStandardGlState() // added this todo (unknown reason fixing text field overflow)
        vanilla.render(context.native,
                       mouseX,
                       mouseY,
                       partialTicks)
        super.render(context,
                     mouseX,
                     mouseY,
                     partialTicks)
    }

    override fun mouseClicked(x: Int,
                              y: Int,
                              button: Int): Boolean {
        return super.mouseClicked(x,
                                  y,
                                  button) || vanilla.mouseClicked(x.toDouble(),
                                                                  y.toDouble(),
                                                                  button)
    }

    override fun mouseReleased(x: Int,
                               y: Int,
                               button: Int): Boolean {
        return super.mouseReleased(x,
                                   y,
                                   button) || vanilla.mouseReleased(x.toDouble(),
                                                                    y.toDouble(),
                                                                    button)
    }

    override fun mouseScrolled(x: Int,
                               y: Int,
                               horizontal: Double,
                               vertical: Double): Boolean {
        return super.mouseScrolled(x,
                                   y,
                                   horizontal,
                                   vertical) || vanilla.mouseScrolled(x.toDouble(),
                                                                    y.toDouble(),
                                                                      /*orizontal,*/
                                                                      vertical)
    }

    override fun mouseDragged(x: Double,
                              y: Double,
                              button: Int,
                              dx: Double,
                              dy: Double): Boolean {
        return super.mouseDragged(x,
                                  y,
                                  button,
                                  dx,
                                  dy) || vanilla.mouseDragged(x,
                                                              y,
                                                              button,
                                                              dx,
                                                              dy)
    }

    override fun keyPressed(keyCode: Int,
                            scanCode: Int,
                            modifiers: Int): Boolean {
        return super.keyPressed(keyCode,
                                scanCode,
                                modifiers) || vanilla.keyPressed(keyCode,
                                                                 scanCode,
                                                                 modifiers)
    }

    override fun keyReleased(keyCode: Int,
                             scanCode: Int,
                             modifiers: Int): Boolean {
        return super.keyReleased(keyCode,
                                 scanCode,
                                 modifiers) || vanilla.keyReleased(keyCode,
                                                                   scanCode,
                                                                   modifiers)
    }

    override fun charTyped(charIn: Char,
                           modifiers: Int): Boolean {
        return super.charTyped(charIn,
                               modifiers) || vanilla.charTyped(charIn,
                                                               modifiers)
    }
}

private class CustomVanillaSliderWidget(val minValue: Double,
                                        val maxValue: Double) : VanillaSliderWidget(0,
                                                                                    0,
                                                                                    0,
                                                                                    20,
                                                                                    getLiteral(""),
                                                                                    0.5) {

    var valueChangedEvent: () -> Unit = { }

    override fun updateMessage() {}
    override fun applyValue() {
        valueChangedEvent()
    }

    var translatedValue: Double
        get() = (maxValue - minValue) * super.value + minValue
        set(value) {
            super.value = (value - minValue) / (maxValue - minValue)
        }

    override fun renderButton(matrixStack: MatrixStack,
                              i: Int,
                              j: Int,
                              f: Float) {
        // fix slider width > 400
        val hovered = isHovered
        val absoluteBounds = Rectangle(x,
                                       y,
                                       width,
                                       height)

//    val k = if (active) if (hovered) 2 else 1 else 0
        val k = 0
        val sprite = rVanillaButtonSprite.down(k)
        rDrawDynamicSizeSprite(NativeContext(matrixStack),
                               sprite,
                               absoluteBounds)

        // ref: AbstractButtonWidget.renderButton()
        //renderBackground(
        super.renderButton(matrixStack, i, j, f)
        renderBg(matrixStack,
                 Vanilla.mc(),
                 i,
                 j)
//    val l = if (active) 16777215 else 10526880
        val l = if (active) if (hovered) 16777120 else 14737632 else 10526880
        DrawableHelper.drawCenteredString(
            matrixStack,
            Vanilla.textRenderer(),
            message,
            x + width / 2,
            y + (height - 8) / 2,
            l or (MathHelper.ceil(alpha * 255.0f) shl 24)
        )
    }
}

fun newSliderWidget(minValue: Double = 0.0,
                    maxValue: Double = 1.0): ISliderWidget = SliderWidget(minValue, maxValue)

private class SliderWidget(override val minValue: Double = 0.0,
                           override val maxValue: Double = 1.0) : ISliderWidget,
                                                                  VanillaWidget<VanillaSliderWidget>(CustomVanillaSliderWidget(minValue,
                                                                                                                               maxValue)) {

    private val silder
        get() = vanilla as CustomVanillaSliderWidget

    override var valueChangedEvent: () -> Unit
        get() = silder.valueChangedEvent
        set(value) {
            silder.valueChangedEvent = value
        }

    override var value: Double
        get() = silder.translatedValue
        set(value) {
            silder.translatedValue = value
        }
}

open class NativeButtonWidget(): VanillaButtonWidget(0,
                                                     0,
                                                     0,
                                                     20,
                                                     Text.literal(""),
                                                     {}) {

    var sHeight
        get() = super.height
        set(value) {
            super.height = value
        }
    var sHovered
        get() = super.isHovered
        set(value) {
            super.isHovered = value
        }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        return mouseClicked(mouseX.toInt(), mouseY.toInt(), button)

    }

    override fun renderButton(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        getRenderButton()(NativeContext(matrices), sHovered)
    }

    var getRenderButton: () -> (NativeContext, hovered: Boolean) -> Unit = {
        {_, _ -> }
    }

    fun mouseClicked(x: Int, y: Int, button: Int): Boolean {
        return true
    }

}

val VANILLA_TEXTURE_WIDGETS: IdentifierHolder
    get() = IdentifierHolder( VanillaButtonWidget.WIDGETS_LOCATION )

val rVanillaButtonSpriteF = Sprite(VANILLA_TEXTURE_WIDGETS,
                                   Rectangle(0,
                                             46,
                                             200,
                                             20))

val rVanillaButtonSprite: DynamicSizeSprite
    get() {
        return DynamicSizeSprite(rVanillaButtonSpriteF,
                                 3)
    }

open class CustomButtonWidget(): IButtonWidget, IPNButtonWidget() {

    constructor(clickEvent: (button: Int) -> Unit) : this() {
        this.clickEvent = { button ->
            VanillaSound.playClick()
            clickEvent(button)
        }
    }

    constructor(clickEvent: () -> Unit) : this() {
        this.clickEvent = { button ->
            if (button == 0) {
                VanillaSound.playClick()
                clickEvent()
            }
        }
    }

    var vanillaMessage: String = ""

    override fun renderButton(context: NativeContext,
                              hovered: Boolean) {

        val k = if (active) if (hovered) 2 else 1 else 0
        val sprite = rVanillaButtonSprite.down(k)
        val ab = absoluteBounds
        rDrawDynamicSizeSprite(context,
                               sprite,
                               ab.copy(width = ab.width, height = ab.height))
        val textColor = if (active) if (hovered) 16777120 else 14737632 else 10526880
        rDrawCenteredText(context,
                          text,
                          screenX + width / 2,
                          screenY + (height - 8) / 2,
                          textColor)
    }
}

fun newButtonWidget(): IButtonWidget = CustomButtonWidget()
fun newButtonWidget(clickEvent: () -> Unit): IButtonWidget = CustomButtonWidget(clickEvent)
fun newButtonWidget(clickEvent: (button: Int) -> Unit): IButtonWidget = CustomButtonWidget(clickEvent)

private class CustomTextFieldWidget(textRenderer: TextRenderer,
                                    i: Int,
                                    j: Int,
                                    k: Int,
                                    l: Int,
                                    string: String) :
    VanillaTextFieldWidget(textRenderer,
                           i,
                           j,
                           k,
                           l,
                           getLiteral(string)) {
    public override fun setFocused(bl: Boolean) {
        super.setFocused(bl)
    }

    init {
        setMaxLength(32767)
    }
}

fun newTextFieldWidget(height: Int): ITextFieldWidget = TextFieldWidget(height)

private class TextFieldWidget(height: Int) : ITextFieldWidget,
                                             VanillaWidget<VanillaTextFieldWidget>(CustomTextFieldWidget(Vanilla.textRenderer(),
                                                                                                         0,
                                                                                                         0,
                                                                                                         0,
                                                                                                         height,
                                                                                                         "")) {

    override var textPredicate: (string: String) -> Boolean = { true }
        set(value) {
            field = value
            //vanilla.setValidator(value)
            vanilla.setFilter(value)
        }
    override var changedEvent: (string: String) -> Unit = { }
        set(value) {
            field = value
            vanilla.setResponder { // setChangedListener
                value(it)
            }
        }

    override var vanillaText: String
        get() =  vanilla.value  //vanilla.text
        set(value) {
            if (vanilla.value != value) {
                vanilla.value = value
            }
        }

    override var vanillaFocused: Boolean
        get() = vanilla.isFocused
        set(value) {
            (vanilla as CustomTextFieldWidget).isFocused = value
        }

    override fun lostFocus() {
        super.lostFocus()
        vanillaFocused = false
    }

    override fun editing(): Boolean =
        vanilla.isFocused// canWrite() // func_212955_f() = method_20315() = isActive = forge canWrite()

    init {
        textPredicate = textPredicate
        changedEvent = changedEvent
    }
}
