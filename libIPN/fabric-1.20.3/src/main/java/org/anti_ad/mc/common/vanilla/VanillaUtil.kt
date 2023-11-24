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

package org.anti_ad.mc.common.vanilla

import org.anti_ad.mc.common.extensions.createDirectories
import org.anti_ad.mc.common.extensions.div
import org.anti_ad.mc.common.extensions.pathFrom
import org.anti_ad.mc.common.extensions.tryCatch
import org.anti_ad.mc.common.input.KeybindSettings
import org.anti_ad.mc.common.vanilla.alias.Identifier
import org.anti_ad.mc.common.vanilla.alias.Screen
import org.anti_ad.mc.common.vanilla.alias.Text
import org.anti_ad.mc.common.vanilla.alias.Util
import org.anti_ad.mc.common.vanilla.render.rScreenHeight
import org.anti_ad.mc.common.vanilla.render.rScreenWidth
import java.io.File
import java.net.URL
import java.nio.file.Path
import kotlin.concurrent.thread

object VanillaUtil {
    fun isOnClientThread(): Boolean = // Thread.currentThread() == this.getThread()
        Vanilla.mc().isOnThread // isOnThread()

    // ============
    // info
    // ============
    fun inGame() = Vanilla.worldNullable() != null && Vanilla.playerNullable() != null

    fun languageCode(): String = Vanilla.languageManager().language

    fun shiftDown() = Screen.hasShiftDown()
    fun ctrlDown() = Screen.hasControlDown()
    fun altDown() = Screen.hasAltDown()

    // Mouse.onCursorPos() / GameRenderer.render()
    fun mouseX(): Int = mouseXDouble().toInt()
    fun mouseY(): Int = mouseYDouble().toInt()
    fun mouseXRaw(): Double = Vanilla.mouse().x
    fun mouseYRaw(): Double = Vanilla.mouse().y
    fun mouseXDouble(): Double = mouseScaleX(mouseXRaw())
    fun mouseYDouble(): Double = mouseScaleY(mouseYRaw())
    fun mouseScaleX(amount: Double): Double = amount * rScreenWidth / Vanilla.window().width
    fun mouseScaleY(amount: Double): Double = amount * rScreenHeight / Vanilla.window().height

    // this.client.getLastFrameDuration()
    fun lastFrameDuration(): Float = Vanilla.mc().lastFrameDuration

//  var lastMouseX: Int = -1
//    private set
//  var lastMouseY: Int = -1
//    private set
//  var mouseX: Int = -1
//    private set
//  var mouseY: Int = -1
//    private set
//
//  fun updateMouse() {
//    lastMouseX = mouseX
//    lastMouseY = mouseY
//    mouseX = mouseX()
//    mouseY = mouseY()
//  }

    // ============
    // do actions
    // ============


    private fun runDirectory(): Path = Vanilla.runDirectoryFile().toPath().normalize()
    fun configDirectory(): Path = runDirectory() / "config"
    fun configDirectory(modName: String): Path = (configDirectory() / modName).apply { createDirectories() }

    fun getResourceAsString(identifier: String): String? = tryCatch {
        Vanilla.resourceManager().getResource(Identifier(identifier)).get().inputStream?.reader()?.readText()
    }

    fun loggingString(path: Path): String = // return ".minecraft/config/file.txt" etc
        (if (path.isAbsolute) path pathFrom (runDirectory() / "..") else path).toString()


    fun open(file: File) {
        // ResourcePackOptionsScreen.init()
        //todo check with every version if this is safe to do!!!!!
        thread { ->
            Util.getOperatingSystem().open(file)
        }
    }

    fun open(url: URL) {
        // ResourcePackOptionsScreen.init()
        thread { ->
            Util.getOperatingSystem().open(url)
        }
    }


    fun isValidScreen(ctx: KeybindSettings.Context) = ctx.isValid(Vanilla.screen())

    fun chat(message: Any) = Vanilla.chatHud().addMessage(if (message is Text) message else Text.literal(message.toString()))
}

private fun KeybindSettings.Context.isValid(s: Screen?) = when (this) {
    KeybindSettings.Context.INGAME -> s == null
    KeybindSettings.Context.GUI -> s != null
    KeybindSettings.Context.ANY -> true
}

fun showSubTitle(text: Text?) {
    Vanilla.inGameHud().setDefaultTitleFade()
    Vanilla.inGameHud().setSubtitle(text)
    Vanilla.inGameHud().setTitle(Text.of(" "))
}
