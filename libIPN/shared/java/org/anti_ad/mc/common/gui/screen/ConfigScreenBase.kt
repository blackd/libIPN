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

import org.anti_ad.mc.common.config.CategorizedMultiConfig
import org.anti_ad.mc.common.config.IConfigOption
import org.anti_ad.mc.common.config.builder.ConfigDeclaration
import org.anti_ad.mc.common.config.builder.toMultiConfigList
import org.anti_ad.mc.common.config.options.ConfigHotkey
import org.anti_ad.mc.common.config.options.ConfigString
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.TooltipsManager
import org.anti_ad.mc.common.gui.layout.AnchorStyles
import org.anti_ad.mc.common.gui.layout.Flex
import org.anti_ad.mc.common.gui.layout.FlexDirection.TOP_DOWN
import org.anti_ad.mc.common.gui.widgets.*
import org.anti_ad.mc.common.input.GlobalInputHandler
import org.anti_ad.mc.common.math2d.Size
import org.anti_ad.mc.common.vanilla.alias.glue.I18n
import org.anti_ad.mc.common.vanilla.render.glue.rDrawText
import org.anti_ad.mc.common.vanilla.render.glue.rMeasureText
import org.anti_ad.mc.common.vanilla.render.rScreenWidth
import kotlin.math.max

private const val COLOR_WHITE = 0xFFFFFFFF.toInt()

open class ConfigScreenBase(val configHelper: BaseConfigScreenSettings) : BaseScreen(configHelper.configScreenTitle) {


    val configDeclarations: List<ConfigDeclaration>
        get() = configHelper.configDeclarations

    val labelIdPrefix: String = "${configHelper.configOptionsPrefix}name."

    val descriptionIdPrefix: String = "${configHelper.configOptionsPrefix}description."

    open fun getDisplayNameId(key: String): String {
        val id = labelIdPrefix + key
        return id
    }

    open fun getDescriptionNameId(key: String): String {
        val id = descriptionIdPrefix + key
        return id
    }

    fun CategorizedMultiConfig.toListWidget() =
        this.toListWidget({ I18n.translateOrElse(getDisplayNameId(it)) { it } },
                          { I18n.translateOrEmpty(getDescriptionNameId(it)) },
                          { I18n.translateOrElse(it) { it.substringAfterLast('.') } })

    var openConfigMenuHotkeyWidget: ConfigHotkeyWidget? = null
        private set(value) {
            field?.parent = null
            field = value?.apply {
                anchor = AnchorStyles.topRight
                this@ConfigScreenBase.addWidget(this)
                size = Size(150,
                            20)
                top = 5
                right = 10 // do set right after add
            }
        }


    var openConfigMenuHotkey: ConfigHotkey? = null
        set(value) {
            field = value
            openConfigMenuHotkeyWidget = value?.toWidget()
        }

    private val IConfigOption.displayName
        get() = I18n.translate("libipn.common.gui.config.settings_screen.$key")
    private val IConfigOption.description
        get() = I18n.translate("libipn.common.gui.config.description.settings_screen.$key")

    val searchTerm = ConfigString("").apply {
        key = "search-box"
        importance = IConfigOption.Importance.NORMAL
    }

    val searchBoxDescription = object: TextButtonWidget(searchTerm.displayName) {
        override fun render(context: NativeContext,
                            mouseX: Int,
                            mouseY: Int,
                            partialTicks: Float) {
            super.render(context,
                         mouseX,
                         mouseY,
                         partialTicks)
            if (contains(mouseX,
                         mouseY)
            ) {
                TooltipsManager.addTooltip(searchTerm.description,
                                           mouseX,
                                           mouseY,
                                           rScreenWidth * 2 / 3)
            }
        }
    }.apply {
        anchor = AnchorStyles.topLeft
        this@ConfigScreenBase.addWidget(this)
        size = Size(rMeasureText(searchTerm.displayName) + 5, 16)
        top = 32
        left = 20
    }

    var searchBox: ConfigStringWidget = ConfigStringWidget(searchTerm, 10).apply {
        anchor = AnchorStyles.topRight
        this@ConfigScreenBase.addWidget(this)
        left = 20 + 5 +  rMeasureText(searchTerm.displayName)
        val width = rScreenWidth - left - 10
        size = Size(width, 10)
        //this.width = width
        top = 30

        //left = 10 + 5 +  rMeasureText(searchTerm.displayName)
    }

    val navigationButtonsContainer = Widget().apply {
        anchor = AnchorStyles.noRight
        this@ConfigScreenBase.addWidget(this)
        top = searchBox.top + searchBox.height + 5
        left = 10
        bottom = 0
    }

    private val navigationButtonsFlowLayout =
        Flex(navigationButtonsContainer,
             TOP_DOWN)

    var currentConfigList: Widget? = null
        set(value) {
            field?.parent = null
            field = value?.apply {
                anchor = AnchorStyles.all
                this@ConfigScreenBase.addWidget(this)
                top = searchBox.top + searchBox.height + 5
                left = 10 + navigationButtonsContainer.width + 5
                right = 10
                bottom = 10
                zIndex = 1
            }
        }

    private val navigationButtonsInfo = mutableListOf<Pair<String, () -> Unit>>()

    var selectedIndex = -1
        set(value) {
            if (value < 0 || value >= navigationButtonsContainer.childCount) {
                field = -1
                updateButtonsActive()
                selectedIndexChanged()
            } else if (value != field) {
                field = value
                updateButtonsActive()
                navigationButtonsInfo[value].second()
                selectedIndexChanged()
            }
        }

    init {
        val configsToUse = configDeclarations.toList<ConfigDeclaration>()
        configsToUse.toMultiConfigList().forEach { multi ->
            addNavigationButtonWithWidget(I18n.translate(configHelper.configLabelsPrefix + multi.key)) { multi.toListWidget() }
        }
        selectedIndex = configHelper.storedSelectedIndex
        configHelper.checkAll()
    }

    open fun selectedIndexChanged() {}

    private fun updateButtonsActive() {
        navigationButtonsContainer.children.forEachIndexed { index, child ->
            child.active = selectedIndex != index
        }
    }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        //renderBackground(context.native, mouseX, mouseY, partialTicks)
        renderBackground(context.native, mouseX, mouseY, partialTicks)
        //rRenderVanillaScreenBackground(context, mouseX, mouseY, partialTicks)
        rDrawText(context,
                  this.titleString,
                  20,
                  10,
                  COLOR_WHITE)
        super.render(context,
                     mouseX,
                     mouseY,
                     partialTicks)
    }

    fun addNavigationButton(buttonText: String,
                            action: () -> Unit) {

        val id = navigationButtonsContainer.childCount
        navigationButtonsContainer.apply {
            width = max(width, rMeasureText(buttonText) + 20)
        }
        navigationButtonsInfo.add(Pair(buttonText,
                                       action))
        navigationButtonsFlowLayout.add(CustomButtonWidget { ->
                    selectedIndex = id
        }.apply {
            text = buttonText
        },
                                        20)
        navigationButtonsFlowLayout.addSpace(2)
    }

    fun addNavigationButtonWithWidget(buttonText: String,
                                      widgetSupplier: () -> Widget?) {
        addNavigationButton(buttonText) {
            currentConfigList = widgetSupplier().apply {
                (this as? ConfigListWidget)?.searchTermSource = { searchTerm.value }
            }
        }
    }

    fun addNavigationButton(buttonText: String) {
        addNavigationButtonWithWidget(buttonText) { null }
    }

    override fun closeScreen() {
        if (GlobalInputHandler.currentAssigningKeybind != null) return
        configHelper.storedSelectedIndex = selectedIndex
        configHelper.saveManager.save()
        configHelper.onClosed()
        super.closeScreen()
    }

    override val screenInfo: ScreenInfo = ScreenInfo.pausing

    init {
        rootWidget.sizeChanged += { ev: SizeChangedEvent ->
            val newWidth = ev.newValue.width - 10
            val left = searchBoxDescription.left + searchBoxDescription.width + 5
            searchBox.left = left
            searchBox.width = newWidth - left
        }
        openConfigMenuHotkey = configHelper.openConfigHotkey
    }

}
