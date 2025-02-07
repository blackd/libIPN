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

import org.anti_ad.mc.libipn.Log
import org.anti_ad.mc.common.extensions.usefulName
import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.vanilla.Vanilla
import org.anti_ad.mc.alias.client.MinecraftClient
import org.anti_ad.mc.alias.text.Text
import org.anti_ad.mc.common.vanilla.render.rClearDepth
import org.anti_ad.mc.common.vanilla.render.rStandardGlState

//import org.anti_ad.mc.common.vanilla.render.rMatrixStack

open class BaseOverlay : BaseScreen {
    constructor(text: Text) : super(text)
    constructor() : super()

    init {
        parent = Vanilla.screen()
    }

    open fun renderParentPost(context: NativeContext,
                              mouseX: Int,
                              mouseY: Int,
                              partialTicks: Float) {
    }

    override fun render(context: NativeContext,
                        mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        try {
            parent?.render(context.native,
                           mouseX,
                           mouseY,
                           partialTicks)


        } catch (e: Throwable) {
            Log.error("rendering parent exception: ${e.javaClass.usefulName}")
        }
        rStandardGlState()
        rClearDepth(context)
        renderParentPost(context,
                         mouseX,
                         mouseY,
                         partialTicks)
        super.render(context,
                     mouseX,
                     mouseY,
                     partialTicks)
    }

    override fun resize(minecraftClient: MinecraftClient,
                        width: Int,
                        height: Int) {
        parent?.resize(minecraftClient,
                       width,
                       height)
        super.resize(minecraftClient,
                     width,
                     height)
    }

    open fun onTick() {

    }

    override fun tick() {
        onTick()
        super.tick()
    }

}
