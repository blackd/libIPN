/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2021-2024 Plamen K. Kosseff <p.kosseff@gmail.com>
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

import org.anti_ad.mc.alias.client.gui.widget.ClickableWidget
import org.anti_ad.mc.alias.client.gui.widget.VanillaButtonWidget
import org.anti_ad.mc.alias.text.Text
import org.anti_ad.mc.alias.util.math.MathHelper
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.widgets.glue.IButtonWidget
import org.anti_ad.mc.common.gui.widgets.glue.ISliderWidget
import org.anti_ad.mc.common.gui.widgets.glue.ITextFieldWidget
import org.anti_ad.mc.common.math2d.Size
import org.anti_ad.mc.common.vanilla.Vanilla
import org.anti_ad.mc.common.vanilla.VanillaSound
import org.anti_ad.mc.common.vanilla.alias.DrawContext
import org.anti_ad.mc.common.vanilla.alias.TextRenderer
import org.anti_ad.mc.common.vanilla.render.rStandardGlState
import org.anti_ad.mc.alias.client.gui.widget.SliderWidget as VanillaSliderWidget
import org.anti_ad.mc.alias.client.gui.widget.TextFieldWidget as VanillaTextFieldWidget

// ============
// vanillamapping code depends on mappings
// ============

open class VanillaWidget<T: ClickableWidget>(val vanilla: T): Widget() { init {
    sizeChanged += {
        vanilla.width = width // TODO set height
    }
    screenLocationChanged += {
        vanilla.x = screenX
        vanilla.y = screenY
    }
}

    var vanillaMessage: String
        get() = vanilla.message.string
        set(value) {
            vanilla.message = Text.literal(value)
        }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        rStandardGlState() // added this todo (unknown reason fixing text field overflow)
        vanilla.render(context.native, mouseX, mouseY, partialTicks)
        super.render(context, mouseX, mouseY, partialTicks)
    }

    override fun mouseClicked(x: Int,
                              y: Int,
                              button: Int): Boolean {
        if (!absoluteBounds.contains(x, y)) {
            return false
        }
        val sc = super.mouseClicked(x, y, button)
        if (!sc) {

            return vanilla.mouseClicked(x.toDouble(), y.toDouble(), button)
        }
        return true

    }

    override fun mouseReleased(x: Int,
                               y: Int,
                               button: Int): Boolean {
        if (!absoluteBounds.contains(x, y)) {
            return false
        }
        val sc = super.mouseClicked(x, y, button)
        if (!sc) {
            return vanilla.mouseReleased(x.toDouble(), y.toDouble(), button)
        }
        return true
    }

    override fun mouseScrolled(x: Int,
                               y: Int,
                               horizontal: Double,
                               vertical: Double): Boolean {
        if (!absoluteBounds.contains(x, y)) {
            return false
        }
        return super.mouseScrolled(x, y, horizontal, vertical) || vanilla.mouseScrolled(x.toDouble(), y.toDouble(), horizontal, vertical)
    }

    override fun mouseDragged(x: Double,
                              y: Double,
                              button: Int,
                              dx: Double,
                              dy: Double): Boolean {
        if (!absoluteBounds.contains(x, y)) {
            return false
        }
        return super.mouseDragged(x, y, button, dx, dy) || vanilla.mouseDragged(x, y, button, dx, dy)
    }

    override fun keyPressed(keyCode: Int,
                            scanCode: Int,
                            modifiers: Int): Boolean {
        return super.keyPressed(keyCode, scanCode, modifiers) || vanilla.keyPressed(keyCode, scanCode, modifiers)
    }

    override fun keyReleased(keyCode: Int,
                             scanCode: Int,
                             modifiers: Int): Boolean {
        return super.keyReleased(keyCode, scanCode, modifiers) || vanilla.keyReleased(keyCode, scanCode, modifiers)
    }

    override fun charTyped(charIn: Char,
                           modifiers: Int): Boolean {
        return super.charTyped(charIn, modifiers) || vanilla.charTyped(charIn, modifiers)
    }

}

private class CustomVanillaSliderWidget(val minValue: Double,
                                        val maxValue: Double): VanillaSliderWidget(0, 0, 0, 20, Text.literal(""), 0.5) {

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

    override fun renderWidget(drawContext: DrawContext,
                              i: Int,
                              j: Int,
                              f: Float) { // fix slider width > 400
        val hovered = isHovered

        super.renderWidget(drawContext, i, j, f)
        val l = if (active) if (hovered) 16777120 else 14737632 else 10526880
        drawContext.drawCenteredTextWithShadow(Vanilla.textRenderer(), message, x + width / 2, y + (height - 8) / 2, l or (MathHelper.ceil(alpha * 255.0f) shl 24))
    }
}

fun newSliderWidget(minValue: Double = 0.0,
                    maxValue: Double = 1.0): ISliderWidget = SliderWidget(minValue, maxValue)

private class SliderWidget(override val minValue: Double = 0.0,
                           override val maxValue: Double = 1.0): ISliderWidget, VanillaWidget<VanillaSliderWidget>(CustomVanillaSliderWidget(minValue, maxValue)) {

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

open class NativeButtonWidget(): VanillaButtonWidget(0, 0, 0, 20, Text.literal(""), {}, VanillaButtonWidget.DEFAULT_NARRATION_SUPPLIER) {

    var sHeight
        get() = super.height
        set(value) {
            super.height = value
        }

    override fun mouseClicked(mouseX: Double,
                              mouseY: Double,
                              button: Int): Boolean {
        return mouseClicked(mouseX.toInt(), mouseY.toInt(), button)

    }

    fun mouseClicked(x: Int,
                     y: Int,
                     button: Int): Boolean {
        return true
    }

}

open class CustomButtonWidget(): IButtonWidget, VanillaWidget<NativeButtonWidget>(NativeButtonWidget()) {

    override var clickEvent: (Int) -> Unit = {}

    override var clickThrough: Boolean = false

    var sizeModifier: Size = Size(0, 0)

    override var active: Boolean
        get() = vanilla.active
        set(value) {
            vanilla.active = value
        }

    override var size: Size
        get() = Size(vanilla.width, vanilla.sHeight)
        set(value) {
            vanilla.sHeight = value.height
            vanilla.width = value.width
            super.size = value
        }

    init {
        sizeChanged += {
            vanilla.sHeight = it.newValue.height
            vanilla.width = it.newValue.width
        }
    }

    override var text: String = ""
        set(value) {
            field = value
            vanilla.message = Text.literal(field)
        }

    constructor(clickEvent: (button: Int) -> Unit): this() {
        this.clickEvent = { button ->
            VanillaSound.playClick()
            clickEvent(button)
        }
    }

    constructor(clickEvent: () -> Unit): this() {
        this.clickEvent = { button ->
            if (button == 0) {
                VanillaSound.playClick()
                clickEvent()
            }
        }
    }

    override fun renderButton(context: NativeContext,
                              hovered: Boolean) {

    }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        vanilla.x = screenX
        vanilla.y = screenY
        vanilla.width = bounds.width + sizeModifier.width
        vanilla.sHeight = bounds.height + sizeModifier.height
        super.render(context, mouseX, mouseY, partialTicks)
    }

    override fun mouseClicked(x: Int,
                              y: Int,
                              button: Int): Boolean {
        if (active) onClick(button)
        return !clickThrough
    }

    override fun onClick(button: Int) {
        clickEvent(button)
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
                                    string: String?): VanillaTextFieldWidget(textRenderer, i, j, k, l, Text.literal(string)) {

    override fun setFocused(bl: Boolean) {
        super.setFocused(bl)
    }

    init {
        setMaxLength(32767)
    }
}

fun newTextFieldWidget(height: Int): ITextFieldWidget = TextFieldWidget(height)

private class TextFieldWidget(height: Int): ITextFieldWidget, VanillaWidget<VanillaTextFieldWidget>(CustomTextFieldWidget(Vanilla.textRenderer(), 0, 0, 0, height, "")) {

    override var textPredicate: (string: String) -> Boolean = { true }
        set(value) {
            field = value
            vanilla.setTextPredicate(value)
        }
    override var changedEvent: (string: String) -> Unit = { }
        set(value) {
            field = value
            vanilla.setChangedListener {
                value(it)
            }
        }

    override var vanillaText: String
        get() = vanilla.text
        set(value) {
            if (vanilla.text != value) {
                vanilla.text = value
            }
        }

    override var vanillaFocused: Boolean
        get() = vanilla.isFocused
        set(value) {
            (vanilla as CustomTextFieldWidget).isFocused = value
        }

    override fun gotFocus() {
        super.gotFocus()
        vanillaFocused = true
    }

    override fun lostFocus() {
        super.lostFocus()
        vanillaFocused = false
    }

    override fun editing(): Boolean = vanilla.isActive

    init {
        textPredicate = textPredicate
        changedEvent = changedEvent
    }
}
