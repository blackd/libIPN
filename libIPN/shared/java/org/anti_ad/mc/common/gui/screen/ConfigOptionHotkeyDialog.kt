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

package org.anti_ad.mc.common.gui.screen

import org.anti_ad.mc.alias.text.getTranslatable
import org.anti_ad.mc.common.config.IConfigOption
import org.anti_ad.mc.common.config.options.ConfigAltHotkey
import org.anti_ad.mc.common.config.options.ConfigHotkey
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.TooltipsManager
import org.anti_ad.mc.common.gui.layout.AnchorStyles
import org.anti_ad.mc.common.gui.widgets.ConfigHotkeyWidget
import org.anti_ad.mc.common.gui.widgets.TextButtonWidget
import org.anti_ad.mc.common.gui.widgets.toConfigWidget
import org.anti_ad.mc.common.input.AlternativeKeybind
import org.anti_ad.mc.common.input.ConfigKeybindSettings
import org.anti_ad.mc.common.math2d.Size
import org.anti_ad.mc.common.vanilla.alias.glue.I18n
import org.anti_ad.mc.common.vanilla.render.rScreenWidth
import org.anti_ad.mc.common.vanilla.render.glue.rDrawCenteredText
import org.anti_ad.mc.common.vanilla.render.glue.rMeasureText

private const val COLOR_WHITE = -0x1

class ConfigOptionHotkeyDialog(val configHotkey: ConfigHotkey): BaseDialog(getTranslatable("libipn.common.gui.config.advanced_keybind_settings")) {

    private val altKeyTitle = I18n.translate("libipn.common.gui.config.advanced_keybind_settings.alt_key_title")

    private val altKeyLabels = listOf(I18n.translate("libipn.common.gui.config.advanced_keybind_settings.alt_key_label", 1),
                                      I18n.translate("libipn.common.gui.config.advanced_keybind_settings.alt_key_label", 2),
                                      I18n.translate("libipn.common.gui.config.advanced_keybind_settings.alt_key_label", 3))

    private val altKeyDescription = I18n.translate("libipn.common.gui.config.advanced_keybind_settings.alt_key_description")


    private val keybindSettingElement = with(configHotkey.realMainKeybind) {
        ConfigKeybindSettings(defaultSettings, settings)
    }
    val configs = keybindSettingElement.getConfigOptionList()

    private val IConfigOption.displayName
        get() = I18n.translate("libipn.common.gui.config.$key")
    private val IConfigOption.description
        get() = I18n.translate("libipn.common.gui.config.description.$key")

    private val maxTextWidth = configs.maxOfOrNull { rMeasureText(it.displayName) } ?: 0

    var showTooltips = false

    init {
        val dialogHeight = (configs.size + 3 + 2) * 20 + 2 + 10
        val altTitleWidth = rMeasureText("§l$altKeyTitle")
        val dialogWidth = maxOf(maxTextWidth + 150 + 2, rMeasureText("§l$titleString"), altTitleWidth) + 20
        dialogWidget.size = Size(dialogWidth, dialogHeight)
        val numOfAlts = 2
        val altTop = numOfAlts + 15 + configs.size * 20

        fun makeLabel(label: String,
                      description: String,
                      baseTop: Int): TextButtonWidget {
            return object: TextButtonWidget(label) {
                val hasTooltip = description.isNotEmpty()
                override fun render(context: NativeContext,
                                    mouseX: Int,
                                    mouseY: Int,
                                    partialTicks: Float) {
                    super.render(context, mouseX, mouseY, partialTicks)
                    if (hasTooltip && showTooltips && contains(mouseX, mouseY)) {
                        TooltipsManager.addTooltip(description, mouseX, mouseY, rScreenWidth * 2 / 3)
                    }
                }
            }.apply {
                left = 10
                top = baseTop + 6
                zIndex = 1
            }
        }

        configs.forEachIndexed { index, configOption ->
            val baseTop = 2 + 20 + index * 20
            configOption.toConfigWidget().apply {
                anchor = AnchorStyles.none
                dialogWidget.addChild(this)
                width = 150
                right = 10
                top = baseTop
            }
            dialogWidget.addChild(makeLabel(configOption.displayName, configOption.description, baseTop))
        }

        dialogWidget.addChild(makeLabel("§l$altKeyTitle", "", altTop + 6).apply {
            left = (dialogWidth - altTitleWidth) / 2
        })

        for (i in 0..numOfAlts) {
            val rowTop = altTop + 20 * i + 6 + 21
            if (i >= configHotkey.alternativeKeybinds.size) {
                configHotkey.alternativeKeybinds.add(AlternativeKeybind(configHotkey.realMainKeybind))
            }
            ConfigHotkeyWidget(ConfigAltHotkey(configHotkey, i),
                               true).apply {
                anchor = AnchorStyles.none
                dialogWidget.addChild(this)
                width = 150
                height = 20
                right = 10
                top = rowTop
                zIndex = 1

            }
            dialogWidget.addChild(makeLabel(altKeyLabels[i], altKeyDescription, rowTop))
        }
    }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        super.render(context,
                     mouseX, mouseY, partialTicks) //    Diffuse disable()
        configHotkey.realMainKeybind.settings = keybindSettingElement.settings
        rDrawCenteredText(context,
                          "§l$titleString", dialogWidget.screenX + dialogWidget.width / 2, dialogWidget.screenY + 2 + 6, COLOR_WHITE)
        TooltipsManager.renderAll(context)
    }

    override fun removed() {
        configHotkey.alternativeKeybinds.removeIf {
            it.keyCodes.isEmpty()
        }
    }
}
