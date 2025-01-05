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

import org.anti_ad.mc.common.config.IConfigOption
import org.anti_ad.mc.common.config.options.ConfigColorPicker
import org.anti_ad.mc.common.config.options.ConfigHotkey
import org.anti_ad.mc.common.config.options.ConfigKeyToggleBoolean
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.TooltipsManager
import org.anti_ad.mc.common.gui.layout.AnchorStyles
import org.anti_ad.mc.common.gui.screen.ColorPickerDialog
import org.anti_ad.mc.common.input.GlobalInputHandler
import org.anti_ad.mc.common.input.IKeybind
import org.anti_ad.mc.common.math2d.Rectangle
import org.anti_ad.mc.common.vanilla.VanillaScreenUtil
import org.anti_ad.mc.common.vanilla.alias.glue.I18n
import org.anti_ad.mc.common.vanilla.render.glue.IdentifierHolder
import org.anti_ad.mc.common.vanilla.render.glue.Sprite
import org.anti_ad.mc.common.vanilla.render.glue.rDrawSprite
import org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT
import org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_RIGHT

val LIBIPN_WIDGETS_TEXTURE = IdentifierHolder("libipn",
                                              "textures/gui/widgets.png")
private val baseSprite = Sprite(LIBIPN_WIDGETS_TEXTURE,
                                Rectangle(20,
                                          160,
                                          20,
                                          20))
private val modifiedSprite = baseSprite.right()
private const val textPrefix = "libipn.common.gui.config."
private fun translate(suffix: String): String {
    return I18n.translate(textPrefix + suffix)
}

class ConfigHotkeyWidget(configOption: ConfigHotkey,
                         var simple: Boolean = false) : ConfigWidgetBase<ConfigHotkey>(configOption) {
    private val setKeyButton = CustomButtonWidget { -> GlobalInputHandler.currentAssigningKeybind = configOption.realMainKeybind }
    private val iconButton = object : IPNButtonWidget({ button ->
                                                          if (button == GLFW_MOUSE_BUTTON_RIGHT) {
                                                              targetKeybind.resetSettingsToDefault()
                                                          } else if (button == GLFW_MOUSE_BUTTON_LEFT) {
                                                              onClickKeybindSettingsIcon()
                                                          }
                                                      }) {
        override fun renderButton(context: NativeContext,
                                  hovered: Boolean) {
            val spriteX = if (targetKeybind.isSettingsModified || configOption.alternativeKeybinds.isNotEmpty()) modifiedSprite else baseSprite
            val spriteY = spriteX.down(targetKeybind.settings.activateOn.ordinal)
            rDrawSprite(context,
                        spriteY,
                        screenX,
                        screenY)
        }
    }

    var targetKeybind: IKeybind = configOption.realMainKeybind
    val keybindDisplayText
        get() = targetKeybind.displayText.let {
            if (GlobalInputHandler.currentAssigningKeybind === targetKeybind) "> §e$it§r <" else it
        }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        setKeyButton.text = keybindDisplayText
        super.render(context,
                     mouseX,
                     mouseY,
                     partialTicks)
        if (iconButton.contains(mouseX, mouseY)) { // show Advanced Keybind Settings
            TooltipsManager.addTooltip(keybindSettingsTooltipText,
                                       mouseX,
                                       mouseY)
        }
    }

    private val keybindSettingsTooltipText: String
        get() {
            val yes = translate("yes")
            val no = translate("no")
            return with(targetKeybind.settings) {
                """§n${translate("advanced_keybind_settings")}
                    |${translate("activate_on")}: §9$activateOn
                    |${translate("context")}: §9$context
                    |${translate("allow_extra_keys")}: §6${if (allowExtraKeys) yes else no}
                    |${translate("order_sensitive")}: §6${if (orderSensitive) yes else no}
                    |${translate("modifier_key")}: §9$modifierKey
                    |
                    |${translate("keybind_settings_tips")}""".trimMargin()
            }
        }

    protected fun onClickKeybindSettingsIcon() {
        //VanillaScreenUtil.openScreen(ConfigOptionHotkeyDialog(configOption))
        VanillaScreenUtil.openScreenConfigOptionHotkeyDialog(configOption)
    }

    override fun reset() {
        targetKeybind.resetKeyCodesToDefault()
    }

    override fun resetButtonActive(): Boolean {
        return targetKeybind.isKeyCodesModified
    }

    init {
        if (!simple) {
            flex.normal.add(iconButton, 20, false, 20)
            flex.normal.addSpace(2)
        }
        flex.addAndFit(setKeyButton)
    }
}

class ConfigColorWidget(configOption: ConfigColorPicker): ConfigWidgetBase<ConfigColorPicker>(configOption) {


    var colorSquare = ColorSquareWidget {
        VanillaScreenUtil.openScreen(ColorPickerDialog(configOption))
    }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        super.render(context,
                     mouseX,
                     mouseY,
                     partialTicks)
    }


    init {
        colorSquare.color = { configOption.value }
        colorSquare.anchor = AnchorStyles.topRight
        flex.addAndFit(colorSquare)
    }
}

class ConfigKeyToggleBooleanWidget(configOption: ConfigKeyToggleBoolean) : ConfigWidgetBase<ConfigKeyToggleBoolean>(configOption) {

    var trueText = if (configOption.importance == IConfigOption.Importance.IMPORTANT) {
        I18n.translate("libipn.common.gui.config.true")
    } else {
        I18n.translate("libipn.common.gui.config.yes")
    }
    var falseText = if (configOption.importance == IConfigOption.Importance.IMPORTANT) {
        I18n.translate("libipn.common.gui.config.false")
    } else {
        I18n.translate("libipn.common.gui.config.no")
    }
    val booleanButton = ConfigOptionToggleableButtonWidget(configOption) {
        if (configOption.booleanValue) trueText else falseText
    }

    private val setKeyButton = CustomButtonWidget { ->
        GlobalInputHandler.currentAssigningKeybind = configOption.realMainKeybind
    }

    private val iconButton = object : IPNButtonWidget({ button ->
                                                          if (button == GLFW_MOUSE_BUTTON_RIGHT) {
                                                              targetKeybind.resetSettingsToDefault()
                                                          } else if (button == GLFW_MOUSE_BUTTON_LEFT) {
                                                              onClickKeybindSettingsIcon()
                                                          }
                                                      }) {
        override fun renderButton(context: NativeContext,
                                  hovered: Boolean) {
            val spriteX = if (targetKeybind.isSettingsModified || configOption.alternativeKeybinds.isNotEmpty()) modifiedSprite else baseSprite
            val spriteY = spriteX.down(targetKeybind.settings.activateOn.ordinal)
            rDrawSprite(context,
                        spriteY,
                        screenX,
                        screenY)
        }
    }

    var targetKeybind: IKeybind = configOption.realMainKeybind

    val keybindDisplayText
        get() = targetKeybind.displayText.let {
            if (GlobalInputHandler.currentAssigningKeybind === targetKeybind) "> §e$it§r <" else it
        }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        setKeyButton.text = keybindDisplayText
        super.render(context,
                     mouseX,
                     mouseY,
                     partialTicks)
        if (iconButton.contains(mouseX, mouseY)) { // show Advanced Keybind Settings

            TooltipsManager.addTooltip(keybindSettingsTooltipText,
                                       mouseX,
                                       mouseY)
        }
    }

    private val keybindSettingsTooltipText: String
        get() {
            val yes = translate("yes")
            val no = translate("no")
            return with(targetKeybind.settings) {
                """§n${translate("advanced_keybind_settings")}
                    |${translate("activate_on")}: §9$activateOn
                    |${translate("context")}: §9$context
                    |${translate("allow_extra_keys")}: §6${if (allowExtraKeys) yes else no}
                    |${translate("order_sensitive")}: §6${if (orderSensitive) yes else no}
                    |${translate("modifier_key")}: §9$modifierKey
                    |
                    |${translate("keybind_settings_tips")}""".trimMargin()
            }
        }

    protected fun onClickKeybindSettingsIcon() {
        //VanillaScreenUtil.openScreen(ConfigOptionHotkeyDialog(configOption))
        VanillaScreenUtil.openScreenConfigOptionHotkeyDialog(configOption)
    }

    override fun reset() {
        configOption.resetToDefault()
        //targetKeybind.resetKeyCodesToDefault()
    }

    override fun resetButtonActive(): Boolean {
        return configOption.isModified
    }

    init {


        booleanButton.anchor = AnchorStyles.topRight

        flex.normal.add(booleanButton,
                        44,
                        true)
        flex.normal.addSpace(2)
        flex.normal.add(iconButton,
                        20,
                        false,
                        20)
        flex.normal.addSpace(2)
        flex.addAndFit(setKeyButton)

    }
}
