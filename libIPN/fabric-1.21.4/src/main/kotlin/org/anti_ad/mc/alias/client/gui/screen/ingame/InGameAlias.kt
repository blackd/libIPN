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

package org.anti_ad.mc.alias.client.gui.screen.ingame

import net.minecraft.client.gui.screen.ingame.AbstractCommandBlockScreen
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen
import net.minecraft.client.gui.screen.ingame.AnvilScreen
import net.minecraft.client.gui.screen.ingame.BeaconScreen
import net.minecraft.client.gui.screen.ingame.BlastFurnaceScreen
import net.minecraft.client.gui.screen.ingame.BookEditScreen
import net.minecraft.client.gui.screen.ingame.BookScreen
import net.minecraft.client.gui.screen.ingame.BrewingStandScreen
import net.minecraft.client.gui.screen.ingame.CartographyTableScreen
import net.minecraft.client.gui.screen.ingame.CommandBlockScreen
import net.minecraft.client.gui.screen.ingame.CrafterScreen
import net.minecraft.client.gui.screen.ingame.CraftingScreen
import net.minecraft.client.gui.screen.ingame.CreativeInventoryListener
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
import net.minecraft.client.gui.screen.ingame.CyclingSlotIcon
import net.minecraft.client.gui.screen.ingame.EnchantingPhrases
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen
import net.minecraft.client.gui.screen.ingame.ForgingScreen
import net.minecraft.client.gui.screen.ingame.FurnaceScreen
import net.minecraft.client.gui.screen.ingame.Generic3x3ContainerScreen
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen
import net.minecraft.client.gui.screen.ingame.GrindstoneScreen
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.client.gui.screen.ingame.HangingSignEditScreen
import net.minecraft.client.gui.screen.ingame.HopperScreen
import net.minecraft.client.gui.screen.ingame.HorseScreen
import net.minecraft.client.gui.screen.ingame.InventoryScreen
import net.minecraft.client.gui.screen.ingame.JigsawBlockScreen
import net.minecraft.client.gui.screen.ingame.LecternScreen
import net.minecraft.client.gui.screen.ingame.LoomScreen
import net.minecraft.client.gui.screen.ingame.MerchantScreen
import net.minecraft.client.gui.screen.ingame.MinecartCommandBlockScreen
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider
import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen
import net.minecraft.client.gui.screen.ingame.SignEditScreen
import net.minecraft.client.gui.screen.ingame.SmithingScreen
import net.minecraft.client.gui.screen.ingame.SmokerScreen
import net.minecraft.client.gui.screen.ingame.StonecutterScreen
import net.minecraft.client.gui.screen.ingame.StructureBlockScreen


typealias ContainerScreen<T> = HandledScreen<T>
typealias ContainerScrees = HandledScreens
typealias CreativeContainer = CreativeInventoryScreen.CreativeScreenHandler

typealias AbstractCommandBlockScreen = AbstractCommandBlockScreen
typealias AbstractFurnaceScreen<T> = AbstractFurnaceScreen<T>
typealias AbstractInventoryScreen<T> = RecipeBookScreen<T>
typealias AbstractSignEditScreen = AbstractSignEditScreen
typealias AnvilScreen = AnvilScreen
typealias BeaconScreen = BeaconScreen
typealias BlastFurnaceScreen = BlastFurnaceScreen
typealias BookEditScreen = BookEditScreen
typealias BookScreen = BookScreen
typealias BrewingStandScreen = BrewingStandScreen
typealias CartographyTableScreen = CartographyTableScreen
typealias CommandBlockScreen = CommandBlockScreen
typealias CrafterScreen = CrafterScreen
typealias CraftingScreen = CraftingScreen
typealias CreativeInventoryListener = CreativeInventoryListener
typealias CreativeInventoryScreen = CreativeInventoryScreen
typealias CyclingSlotIcon = CyclingSlotIcon
typealias EnchantingPhrases = EnchantingPhrases
typealias EnchantmentScreen = EnchantmentScreen
typealias ForgingScreen<T> = ForgingScreen<T>
typealias FurnaceScreen = FurnaceScreen
typealias Generic3x3ContainerScreen = Generic3x3ContainerScreen
typealias GenericContainerScreen = GenericContainerScreen
typealias GrindstoneScreen = GrindstoneScreen
typealias HandledScreens = HandledScreens
typealias HangingSignEditScreen = HangingSignEditScreen
typealias HopperScreen = HopperScreen
typealias HorseScreen = HorseScreen
typealias InventoryScreen = InventoryScreen
typealias JigsawBlockScreen = JigsawBlockScreen
typealias LecternScreen = LecternScreen
typealias LoomScreen = LoomScreen
typealias MerchantScreen = MerchantScreen
typealias MinecartCommandBlockScreen = MinecartCommandBlockScreen
typealias ContainerProvider<T> = ScreenHandlerProvider<T>
typealias ShulkerBoxScreen = ShulkerBoxScreen
typealias SignEditScreen = SignEditScreen
typealias SmithingScreen = SmithingScreen
typealias SmokerScreen = SmokerScreen
typealias StonecutterScreen = StonecutterScreen
typealias StructureBlockScreen = StructureBlockScreen


