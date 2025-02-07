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

import net.minecraft.client.player.LocalPlayer
import net.minecraft.world.entity.player.Player
import org.anti_ad.mc.alias.client.network.ClientPlayerEntity
import net.minecraft.world.level.storage.LevelResource
import org.anti_ad.mc.alias.client.MinecraftClient
import org.anti_ad.mc.common.extensions.orDefault
import org.anti_ad.mc.alias.client.gui.screen.Screen
import org.anti_ad.mc.alias.client.Window
import org.anti_ad.mc.alias.entity.player.PlayerInventory
import org.anti_ad.mc.alias.server.integrated.IntegratedServer
import java.nio.file.Path

// ============
// vanillamapping code depends on mappings (package org.anti_ad.mc.common.vanilla)
// ============

object Vanilla {

    // ============
    // minecraft objects
    // ============

    fun mc() = MinecraftClient.getInstance() ?: error("MinecraftClient is not initialized!")
    fun window(): Window = mc().window ?: error("mc.window is not initialized!")
    fun screen(): Screen? = mc().screen

    fun textRenderer() = mc().font ?: error("mc.textRenderer is not initialized!")
    fun textureManager() = mc().textureManager ?: error("mc.textureManager is not initialized!")
    fun soundManager() = mc().soundManager
    fun languageManager() = mc().languageManager
    fun resourceManager() = mc().resourceManager

    fun inGameHud() = mc().gui ?: error("mc.inGameHud is not initialized!")
    fun chatHud() = inGameHud().chat

    fun mouse() = mc().mouseHandler ?: error("mc.mouse is not initialized!")

    fun server(): IntegratedServer? = mc().singleplayerServer

    fun isSinglePlayer() = mc().hasSingleplayerServer()

    // ============
    // java objects
    // ============

    fun runDirectoryFile() = mc().gameDirectory ?: error("mc.runDirectory is not initialized!")

    val savePathRoot: Path?
        get() {
            return server()?.getWorldPath(LevelResource.ROOT)
        }

    // ============
    // in-game objects
    // ============

    fun worldNullable() = mc().level ?: null
    fun playerNullable(): LocalPlayer? = mc().player ?: null

    fun world() = worldNullable() ?: error("mc.world is not initialized! Probably not in game")
    fun player() = playerNullable() ?: error("mc.player is not initialized! Probably not in game")
    fun playerInventory() = player().inventory ?: throw AssertionError("unreachable")
    fun playerContainer() = player().inventoryMenu ?: throw AssertionError("unreachable") // container / openContainer
    fun container() = player().containerMenu ?: playerContainer()

    fun queueForMainThread(r: Runnable) = mc().schedule(r)

    fun interactionManager() =
        mc().gameMode ?: error("mc.interactionManager is not initialized! Probably not in game")

    //fun recipeBook() = player().recipeBook

    fun gameMode() = mc().gameMode?.playerMode

    @Suppress("FunctionName")
    fun LocalPlayer.`(sendCommandMessage)`(msg: String) = this.connection.sendCommand(msg.replaceFirst("/", ""))

    val px
        get() = playerNullable()?.x.orDefault { 0.0 }
    val py
        get() = playerNullable()?.y.orDefault { 0.0 }
    val pz
        get() = playerNullable()?.z.orDefault { 0.0 }

    fun setClipboard(data: String) = mc().keyboardHandler.setClipboard(data)

}
