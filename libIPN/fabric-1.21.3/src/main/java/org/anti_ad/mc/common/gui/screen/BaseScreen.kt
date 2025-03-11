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

import org.anti_ad.mc.alias.client.gui.screen.Screen
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.gui.widgets.RootWidget
import org.anti_ad.mc.common.gui.widgets.Widget
import org.anti_ad.mc.common.math2d.Size
import org.anti_ad.mc.common.vanilla.VanillaScreenUtil
import org.anti_ad.mc.common.vanilla.alias.DrawContext
import org.anti_ad.mc.alias.client.MinecraftClient
import org.anti_ad.mc.alias.text.Text
import org.anti_ad.mc.common.vanilla.alias.RenderLayer
import org.anti_ad.mc.common.vanilla.glue.IScreenMarker
import org.anti_ad.mc.common.vanilla.render.rClearDepth
import org.anti_ad.mc.common.vanilla.render.rStandardGlState

// ============
// vanillamapping code depends on mappings (package org.anti_ad.mc.common.gui.screen)
// ============

abstract class BaseScreen(text: Text) : Screen(text), IScreenMarker {

    constructor() : this(Text.literal(""))

    var isClosing: Boolean = false

    var parent: Screen? = null


    val titleString: String
        get() = this.title.string // todo .asFormattedString()

    open val screenInfo: ScreenInfo
        get() {
            parent?.let { p ->
                if (p is BaseScreen) {
                    return p.screenInfo
                } else {
                    return if (p.shouldPause()) {
                        ScreenInfo.pausing
                    } else {
                        ScreenInfo.default
                    }
                }
            }
            return ScreenInfo.default
        }

    open fun closeScreen() {
        this.isClosing = true
        VanillaScreenUtil.openScreenNullable(parent)
        this.isClosing = false
    }

    fun hasParent(screen: Screen): Boolean {
        val parents = mutableSetOf<BaseScreen>()
        var currentParent = this
        while (currentParent != screen) {
            parents.add(currentParent)
            currentParent = (currentParent.parent as? BaseScreen) ?: return (currentParent.parent == screen)
            if (currentParent in parents) { // loop
                return false
            }
        }
        return true
    }

    // ============
    // widget
    // ============
    val rootWidget = RootWidget()
    fun addWidget(widget: Widget) {
        rootWidget.addChild(widget)
    }

    fun dumpWidgetTree() {
        rootWidget.dumpWidgetTree()
    }

    fun internalClearWidgets() {
        rootWidget.clearChildren()
    }

    // ============
    // render
    // ============
    open fun renderWidgetPre(context: NativeContext,
                             mouseX: Int,
                             mouseY: Int,
                             partialTicks: Float) {
        rStandardGlState()
        rClearDepth(context)
    }

    open fun render(context: NativeContext,
                    mouseX: Int,
                    mouseY: Int,
                    partialTicks: Float) {
        renderWidgetPre(context,
                        mouseX,
                        mouseY,
                        partialTicks)
        rootWidget.render(context,
                          mouseX,
                          mouseY,
                          partialTicks)
    }

    override fun render(drawContext: DrawContext,
                        mouseX: Int,
                        mouseY: Int,
                        delta: Float) {
        render(NativeContext(drawContext, RenderLayer::getGuiTextured),
               mouseX,
               mouseY,
               delta)
    }

    // ============
    // vanilla overrides
    // ============
    final override fun shouldPause(): Boolean = screenInfo.isPauseScreen
    final override fun close() {
        if (!isClosing) {
            closeScreen()
        }
        isClosing = false
    }

    // ============
    // event delegates
    // ============
    override fun resize(minecraftClient: MinecraftClient,
                        width: Int,
                        height: Int) {
        super.resize(minecraftClient,
                     width,
                     height)
        rootWidget.size = Size(width,
                               height)
    }

    override fun mouseClicked(d: Double,
                              e: Double,
                              i: Int): Boolean =
        rootWidget.mouseClicked(d.toInt(),
                                e.toInt(),
                                i)

    override fun mouseReleased(d: Double,
                               e: Double,
                               i: Int): Boolean =
        rootWidget.mouseReleased(d.toInt(),
                                 e.toInt(),
                                 i)

    override fun mouseDragged(d: Double,
                              e: Double,
                              i: Int,
                              f: Double,
                              g: Double): Boolean =
        rootWidget.mouseDragged(d,
                                e,
                                i,
                                f,
                                g) // fixme fix dx dy decimal rounding off

    override fun mouseScrolled(d: Double,
                               e: Double,
                               horisontal: Double,
                               vertical: Double): Boolean =
        rootWidget.mouseScrolled(d.toInt(),
                                 e.toInt(),
                                 horisontal,
                                 vertical)

    override fun keyPressed(keyCode: Int,
                            scanCode: Int,
                            modifiers: Int): Boolean =
        super.keyPressed(keyCode,
                         scanCode,
                         modifiers) || rootWidget.keyPressed(keyCode,
                                                             scanCode,
                                                             modifiers)

    override fun keyReleased(keyCode: Int,
                             scanCode: Int,
                             modifiers: Int): Boolean =
        rootWidget.keyReleased(keyCode,
                               scanCode,
                               modifiers)

    override fun charTyped(charIn: Char,
                           modifiers: Int): Boolean =
        rootWidget.charTyped(charIn,
                             modifiers)
}
