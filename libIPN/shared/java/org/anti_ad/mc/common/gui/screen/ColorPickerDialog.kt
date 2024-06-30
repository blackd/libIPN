/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2024 Plamen K. Kosseff <p.kosseff@gmail.com>
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

package org.anti_ad.mc.common.gui.screen

import org.anti_ad.mc.alias.text.getTranslatable
import org.anti_ad.mc.common.config.IConfigOption
import org.anti_ad.mc.common.config.options.ConfigColorPicker
import org.anti_ad.mc.common.config.options.ConfigInteger
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.TooltipsManager
import org.anti_ad.mc.common.gui.layout.AnchorStyles
import org.anti_ad.mc.common.gui.widgets.ColorSquareWidget
import org.anti_ad.mc.common.gui.widgets.TextButtonWidget
import org.anti_ad.mc.common.gui.widgets.toConfigWidget
import org.anti_ad.mc.common.math2d.Size
import org.anti_ad.mc.common.vanilla.alias.glue.I18n
import org.anti_ad.mc.common.vanilla.render.*
import org.anti_ad.mc.common.vanilla.render.glue.rDrawCenteredText
import org.anti_ad.mc.common.vanilla.render.glue.rMeasureText
import kotlin.math.max


class ColorPickerDialog(val colorConfig: ConfigColorPicker): BaseDialog(getTranslatable("libipn.common.gui.config.color_picker_dialog")) {

    val red = ConfigInteger(colorConfig.value.red, 0, 255).apply { key = "red" }
    val green = ConfigInteger(colorConfig.value.green, 0, 255).apply { key = "green" }
    val blue = ConfigInteger(colorConfig.value.blue, 0, 255).apply { key = "blue" }
    val alpha = ConfigInteger(colorConfig.value.alpha, 0, 255).apply { key = "alpha" }

    val widgetsList = listOf(alpha, red, green, blue)

    private val IConfigOption.displayName
        get() = I18n.translate("libipn.common.gui.config.colorpicker.$key")
    private val IConfigOption.description
        get() = I18n.translate("libipn.common.gui.config.description.colorpicker.$key")

    var showTooltips = false

    val itemsMargin = 10
    val usableWidth = 180

    private val maxTextWidth = widgetsList.maxOfOrNull { rMeasureText(it.displayName) } ?: 0

    val colorDisplay: ColorSquareWidget = ColorSquareWidget{}.apply {
        this.color = { val c = red.integerValue.asRed()
            .green(green.integerValue)
            .blue(blue.integerValue)
            .alpha(alpha.integerValue)
            colorConfig.value = c
            c
        }
    }

    init {
        val dialogHeight = 4 * 24 + 80
        val dialogWidth =  max(maxTextWidth + usableWidth + 2, rMeasureText("§l$titleString")) + 2 * itemsMargin
        dialogWidget.size = Size(dialogWidth, dialogHeight)
        var i = 0
        //var baseTop: Int
        widgetsList.forEachIndexed { index, cfg ->
            val baseTop = 2 + 20 + index * 20
            cfg.toConfigWidget().apply {
                anchor = AnchorStyles.none
                dialogWidget.addChild(this)
                width = usableWidth
                right = itemsMargin
                top = baseTop
            }
            object: TextButtonWidget(cfg.displayName) {
                override fun render(context: NativeContext,
                                    mouseX: Int,
                                    mouseY: Int,
                                    partialTicks: Float) {
                    super.render(context, mouseX, mouseY, partialTicks)
                    if (showTooltips && contains(mouseX, mouseY)) {
                        TooltipsManager.addTooltip(cfg.description, mouseX, mouseY, rScreenWidth * 2 / 3)
                    }
                }
            }.apply {
                dialogWidget.addChild(this)
                left = 10
                top = baseTop + 6
                zIndex = 1
            }
            i = index + 1
        }
        val baseTop = 6 + 20 + i * 20
        colorDisplay.apply {
            anchor = AnchorStyles.none
            dialogWidget.addChild(this)
            width = dialogWidth - 2 * itemsMargin
            right = itemsMargin
            height = 62
            top = baseTop
        }
    }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        super.render(context, mouseX, mouseY, partialTicks) //    Diffuse disable()
        rDrawCenteredText(context,"§l$titleString", dialogWidget.screenX + dialogWidget.width / 2, dialogWidget.screenY + 2 + 6, COLOR_WHITE)
        TooltipsManager.renderAll(context)
    }

}
