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

package org.anti_ad.mc.alias.screen

import net.minecraft.world.inventory.AbstractFurnaceMenu
import net.minecraft.world.inventory.RecipeBookMenu
import net.minecraft.world.inventory.AnvilMenu
/*
import net.minecraft.world.inventory. ArrayPropertyDelegate
*/
import net.minecraft.world.inventory.BeaconMenu
import net.minecraft.world.inventory.BlastFurnaceMenu
import net.minecraft.world.inventory.BrewingStandMenu
import net.minecraft.world.inventory.CartographyTableMenu
import net.minecraft.world.inventory.CrafterMenu
import net.minecraft.world.inventory.CraftingMenu
import net.minecraft.world.inventory.EnchantmentMenu
import net.minecraft.world.inventory.ItemCombinerMenu
import net.minecraft.world.inventory.FurnaceMenu
import net.minecraft.world.inventory.DispenserMenu
import net.minecraft.world.inventory.ChestMenu
import net.minecraft.world.inventory.GrindstoneMenu
import net.minecraft.world.inventory.HopperMenu
import net.minecraft.world.inventory.HorseInventoryMenu
import net.minecraft.world.inventory.LecternMenu
import net.minecraft.world.inventory.LoomMenu
import net.minecraft.world.inventory.MerchantMenu
/*
import net.minecraft.world.inventory.NamedMenuFactory
*/
import net.minecraft.world.inventory.InventoryMenu
import net.minecraft.world.inventory.ContainerData
import net.minecraft.world.inventory.SimpleContainerData
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.ContainerLevelAccess
import net.minecraft.world.inventory.MenuConstructor
import net.minecraft.world.inventory.ContainerListener
import net.minecraft.world.inventory.ContainerSynchronizer
import net.minecraft.world.inventory.MenuType
/*
import net.minecraft.screen.ScreenTexts
*/
import net.minecraft.world.inventory.ShulkerBoxMenu
/*
import net.minecraft.screen.SimpleNamedScreenHandlerFactory
*/
import net.minecraft.world.inventory.SmithingMenu
import net.minecraft.world.inventory.SmokerMenu
import net.minecraft.world.inventory.StonecutterMenu



/*
typealias ArrayPropertyDelegate = ArrayPropertyDelegate
*/
typealias Property = ContainerData
typealias PropertyDelegate = SimpleContainerData

typealias ContainerSyncHandler = ContainerSynchronizer
typealias ContainerListener = ContainerListener
typealias ContainerContext = ContainerLevelAccess
/*
typealias ScreenTexts = ScreenTexts
*/
typealias ContainerFactory = MenuConstructor
/*
typealias NamedContainerFactory = NamedScreenHandlerFactory
typealias SimpleNamedContainerFactory = SimpleNamedScreenHandlerFactory
*/

typealias Container = AbstractContainerMenu
typealias AbstractFurnaceContainer = AbstractFurnaceMenu
typealias AbstractRecipeContainer = RecipeBookMenu
typealias AnvilContainer = AnvilMenu
typealias BeaconContainer = BeaconMenu
typealias BlastFurnaceContainer = BlastFurnaceMenu
typealias BrewingStandContainer = BrewingStandMenu
typealias CartographyTableContainer = CartographyTableMenu
typealias CrafterContainer = CrafterMenu
typealias CraftingTableContainer = CraftingMenu
typealias EnchantingTableContainer = EnchantmentMenu
typealias FurnaceContainer = FurnaceMenu
typealias Generic3x3Container = DispenserMenu
typealias GenericContainer = ChestMenu
typealias GrindstoneContainer = GrindstoneMenu
typealias HopperContainer = HopperMenu
typealias HorseContainer = HorseInventoryMenu
typealias LecternContainer = LecternMenu
typealias LoomContainer = LoomMenu
typealias MerchantContainer = MerchantMenu
typealias PlayerContainer = InventoryMenu
typealias ShulkerBoxContainer = ShulkerBoxMenu
typealias StonecutterContainer = StonecutterMenu
typealias SmithingTableContainer = SmithingMenu
typealias SmokerContainer = SmokerMenu
typealias ForgingContainer = ItemCombinerMenu

typealias ContainerType<T> = MenuType<T>


