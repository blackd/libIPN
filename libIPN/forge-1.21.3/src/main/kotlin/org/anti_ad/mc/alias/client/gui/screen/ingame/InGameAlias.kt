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

import net.minecraft.client.gui.screens.inventory.AbstractCommandBlockEditScreen
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen
import net.minecraft.client.gui.screens.inventory.EffectsInInventory
import net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen
import net.minecraft.client.gui.screens.inventory.AnvilScreen
import net.minecraft.client.gui.screens.inventory.BeaconScreen
import net.minecraft.client.gui.screens.inventory.BlastFurnaceScreen
import net.minecraft.client.gui.screens.inventory.BookEditScreen
import net.minecraft.client.gui.screens.inventory.BookViewScreen
import net.minecraft.client.gui.screens.inventory.BrewingStandScreen
import net.minecraft.client.gui.screens.inventory.CartographyTableScreen
import net.minecraft.client.gui.screens.inventory.CommandBlockEditScreen
import net.minecraft.client.gui.screens.inventory.CrafterScreen
import net.minecraft.client.gui.screens.inventory.CraftingScreen
import net.minecraft.client.gui.screens.inventory.CreativeInventoryListener
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen
import net.minecraft.client.gui.screens.inventory.CyclingSlotBackground
import net.minecraft.client.gui.screens.inventory.EnchantmentNames
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen
import net.minecraft.client.gui.screens.inventory.FurnaceScreen
import net.minecraft.client.gui.screens.inventory.DispenserScreen
import net.minecraft.client.gui.screens.inventory.ContainerScreen
import net.minecraft.client.gui.screens.inventory.GrindstoneScreen
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
/*
import net.minecraft.client.gui.screens.inventory.HandledScreens
*/
import net.minecraft.client.gui.screens.inventory.HangingSignEditScreen
import net.minecraft.client.gui.screens.inventory.HopperScreen
import net.minecraft.client.gui.screens.inventory.HorseInventoryScreen
import net.minecraft.client.gui.screens.inventory.InventoryScreen
import net.minecraft.client.gui.screens.inventory.JigsawBlockEditScreen
import net.minecraft.client.gui.screens.inventory.LecternScreen
import net.minecraft.client.gui.screens.inventory.LoomScreen
import net.minecraft.client.gui.screens.inventory.MerchantScreen
import net.minecraft.client.gui.screens.inventory.MinecartCommandBlockEditScreen
import net.minecraft.client.gui.screens.inventory.MenuAccess
import net.minecraft.client.gui.screens.inventory.ShulkerBoxScreen
import net.minecraft.client.gui.screens.inventory.SignEditScreen
import net.minecraft.client.gui.screens.inventory.SmithingScreen
import net.minecraft.client.gui.screens.inventory.SmokerScreen
import net.minecraft.client.gui.screens.inventory.StonecutterScreen
import net.minecraft.client.gui.screens.inventory.StructureBlockEditScreen


typealias ContainerScreen<T> = AbstractContainerScreen<T>
//typealias ContainerScrees = HandledScreens
typealias CreativeContainer = CreativeModeInventoryScreen.ItemPickerMenu

typealias AbstractCommandBlockScreen = AbstractCommandBlockEditScreen
typealias AbstractFurnaceScreen<T> = AbstractFurnaceScreen<T>
typealias AbstractInventoryScreen = EffectsInInventory
typealias AbstractSignEditScreen = AbstractSignEditScreen
typealias AnvilScreen = AnvilScreen
typealias BeaconScreen = BeaconScreen
typealias BlastFurnaceScreen = BlastFurnaceScreen
typealias BookEditScreen = BookEditScreen
typealias BookScreen = BookViewScreen
typealias BrewingStandScreen = BrewingStandScreen
typealias CartographyTableScreen = CartographyTableScreen
typealias CommandBlockScreen = CommandBlockEditScreen
typealias CrafterScreen = CrafterScreen
typealias CraftingScreen = CraftingScreen
typealias CreativeInventoryListener = CreativeInventoryListener
typealias CreativeInventoryScreen = CreativeModeInventoryScreen
typealias CyclingSlotIcon = CyclingSlotBackground
typealias EnchantingPhrases = EnchantmentNames
typealias EnchantmentScreen = EnchantmentScreen
typealias ForgingScreen<T> = ItemCombinerScreen<T>
typealias FurnaceScreen = FurnaceScreen
typealias Generic3x3ContainerScreen = DispenserScreen
typealias GenericContainerScreen = ContainerScreen
typealias GrindstoneScreen = GrindstoneScreen
typealias HangingSignEditScreen = HangingSignEditScreen
typealias HopperScreen = HopperScreen
typealias HorseScreen = HorseInventoryScreen
typealias InventoryScreen = InventoryScreen
typealias JigsawBlockScreen = JigsawBlockEditScreen
typealias LecternScreen = LecternScreen
typealias LoomScreen = LoomScreen
typealias MerchantScreen = MerchantScreen
typealias MinecartCommandBlockScreen = MinecartCommandBlockEditScreen
typealias ContainerProvider<T> = MenuAccess<T>
typealias ShulkerBoxScreen = ShulkerBoxScreen
typealias SignEditScreen = SignEditScreen
typealias SmithingScreen = SmithingScreen
typealias SmokerScreen = SmokerScreen
typealias StonecutterScreen = StonecutterScreen
typealias StructureBlockScreen = StructureBlockEditScreen


