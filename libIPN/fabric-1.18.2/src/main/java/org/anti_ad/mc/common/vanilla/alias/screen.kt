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

package org.anti_ad.mc.common.vanilla.alias

import net.minecraft.client.gui.screen.ingame.AbstractCommandBlockScreen
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen
import net.minecraft.client.gui.screen.ingame.AnvilScreen
import net.minecraft.client.gui.screen.ingame.BeaconScreen
import net.minecraft.client.gui.screen.ingame.BlastFurnaceScreen
import net.minecraft.client.gui.screen.ingame.BookEditScreen
import net.minecraft.client.gui.screen.ingame.BookScreen
import net.minecraft.client.gui.screen.ingame.BrewingStandScreen
import net.minecraft.client.gui.screen.ingame.CartographyTableScreen
import net.minecraft.client.gui.screen.ingame.CommandBlockScreen
import net.minecraft.client.gui.screen.ingame.CraftingScreen

import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
import net.minecraft.client.gui.screen.ingame.EnchantingPhrases
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen
import net.minecraft.client.gui.screen.ingame.ForgingScreen
import net.minecraft.client.gui.screen.ingame.FurnaceScreen
import net.minecraft.client.gui.screen.ingame.Generic3x3ContainerScreen
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen
import net.minecraft.client.gui.screen.ingame.GrindstoneScreen
import net.minecraft.client.gui.screen.ingame.HopperScreen
import net.minecraft.client.gui.screen.ingame.HorseScreen
import net.minecraft.client.gui.screen.ingame.InventoryScreen
import net.minecraft.client.gui.screen.ingame.JigsawBlockScreen
import net.minecraft.client.gui.screen.ingame.LecternScreen
import net.minecraft.client.gui.screen.ingame.LoomScreen
import net.minecraft.client.gui.screen.ingame.MerchantScreen
import net.minecraft.client.gui.screen.ingame.MinecartCommandBlockScreen

import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen
import net.minecraft.client.gui.screen.ingame.SignEditScreen
import net.minecraft.client.gui.screen.ingame.SmithingScreen
import net.minecraft.client.gui.screen.ingame.SmokerScreen
import net.minecraft.client.gui.screen.ingame.StonecutterScreen
import net.minecraft.client.gui.screen.ingame.StructureBlockScreen




typealias AbstractCommandBlockScreen = AbstractCommandBlockScreen
typealias AbstractFurnaceScreen<T> = AbstractFurnaceScreen<T>
typealias AbstractInventoryScreen<T> = AbstractInventoryScreen<T>
typealias AnvilScreen = AnvilScreen
typealias BeaconScreen = BeaconScreen
typealias BlastFurnaceScreen = BlastFurnaceScreen
typealias BookEditScreen = BookEditScreen
typealias BookScreen = BookScreen
typealias BrewingStandScreen = BrewingStandScreen
typealias CartographyTableScreen = CartographyTableScreen
typealias CommandBlockScreen = CommandBlockScreen
typealias CraftingScreen = CraftingScreen
typealias CreativeInventoryScreen = CreativeInventoryScreen
typealias EnchantingPhrases = EnchantingPhrases
typealias EnchantmentScreen = EnchantmentScreen
typealias ForgingScreen<T> = ForgingScreen<T>
typealias FurnaceScreen = FurnaceScreen
typealias Generic3x3ContainerScreen = Generic3x3ContainerScreen
typealias GenericContainerScreen = GenericContainerScreen
typealias GrindstoneScreen = GrindstoneScreen
typealias HopperScreen = HopperScreen
typealias HorseScreen = HorseScreen
typealias InventoryScreen = InventoryScreen
typealias JigsawBlockScreen = JigsawBlockScreen
typealias LecternScreen = LecternScreen
typealias LoomScreen = LoomScreen
typealias MerchantScreen = MerchantScreen
typealias MinecartCommandBlockScreen = MinecartCommandBlockScreen
typealias ShulkerBoxScreen = ShulkerBoxScreen
typealias SignEditScreen = SignEditScreen
typealias SmithingScreen = SmithingScreen
typealias SmokerScreen = SmokerScreen
typealias StonecutterScreen = StonecutterScreen
typealias StructureBlockScreen = StructureBlockScreen

val vanillaScreens: Set<Class<*>> = setOf(AbstractCommandBlockScreen::class.java,
                                          AbstractFurnaceScreen::class.java,
                                          AbstractInventoryScreen::class.java,
                                          AnvilScreen::class.java,
                                          BeaconScreen::class.java,
                                          BlastFurnaceScreen::class.java,
                                          BookEditScreen::class.java,
                                          BookScreen::class.java,
                                          BrewingStandScreen::class.java,
                                          CartographyTableScreen::class.java,
                                          CommandBlockScreen::class.java,
                                          CraftingScreen::class.java,
                                          CreativeInventoryScreen::class.java,
                                          EnchantingPhrases::class.java,
                                          EnchantmentScreen::class.java,
                                          ForgingScreen::class.java,
                                          FurnaceScreen::class.java,
                                          Generic3x3ContainerScreen::class.java,
                                          GenericContainerScreen::class.java,
                                          GrindstoneScreen::class.java,
                                          HopperScreen::class.java,
                                          HorseScreen::class.java,
                                          InventoryScreen::class.java,
                                          JigsawBlockScreen::class.java,
                                          LecternScreen::class.java,
                                          LoomScreen::class.java,
                                          MerchantScreen::class.java,
                                          MinecartCommandBlockScreen::class.java,
                                          ShulkerBoxScreen::class.java,
                                          SignEditScreen::class.java,
                                          SmithingScreen::class.java,
                                          SmokerScreen::class.java,
                                          StonecutterScreen::class.java,
                                          StructureBlockScreen::class.java,)
