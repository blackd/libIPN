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

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen
import net.minecraft.world.Container
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.AbstractFurnaceMenu
import net.minecraft.world.inventory.AnvilMenu
import net.minecraft.world.inventory.BeaconMenu
import net.minecraft.world.inventory.BlastFurnaceMenu
import net.minecraft.world.inventory.BrewingStandMenu
import net.minecraft.world.inventory.CartographyTableMenu
import net.minecraft.world.inventory.ChestMenu
import net.minecraft.world.inventory.ClickType
import net.minecraft.world.inventory.CraftingContainer
import net.minecraft.world.inventory.CraftingMenu
import net.minecraft.world.inventory.DispenserMenu
import net.minecraft.world.inventory.EnchantmentMenu
import net.minecraft.world.inventory.FurnaceMenu
import net.minecraft.world.inventory.GrindstoneMenu
import net.minecraft.world.inventory.HopperMenu
import net.minecraft.world.inventory.HorseInventoryMenu
import net.minecraft.world.inventory.InventoryMenu
import net.minecraft.world.inventory.ItemCombinerMenu
import net.minecraft.world.inventory.LecternMenu
import net.minecraft.world.inventory.LoomMenu
import net.minecraft.world.inventory.MerchantMenu
import net.minecraft.world.inventory.MerchantResultSlot
import net.minecraft.world.inventory.ResultContainer
import net.minecraft.world.inventory.ResultSlot
import net.minecraft.world.inventory.ShulkerBoxMenu
import net.minecraft.world.inventory.SmokerMenu
import net.minecraft.world.inventory.Slot
import net.minecraft.world.inventory.StonecutterMenu
import net.minecraft.world.inventory.SmithingMenu

import net.minecraft.world.inventory.MerchantContainer as VanillaMerchantInventory


typealias Container = AbstractContainerMenu
typealias CreativeContainer = CreativeModeInventoryScreen.ItemPickerMenu
typealias AbstractFurnaceContainer = AbstractFurnaceMenu
typealias AnvilContainer = AnvilMenu
typealias BeaconContainer = BeaconMenu
typealias BlastFurnaceContainer = BlastFurnaceMenu
typealias BrewingStandContainer = BrewingStandMenu
typealias CartographyTableContainer = CartographyTableMenu
typealias CraftingTableContainer = CraftingMenu
typealias EnchantingTableContainer = EnchantmentMenu
typealias Generic3x3Container = DispenserMenu
typealias GenericContainer = ChestMenu
typealias GrindstoneContainer = GrindstoneMenu
typealias HopperContainer = HopperMenu
typealias HorseContainer = HorseInventoryMenu
typealias ForgingContainer = ItemCombinerMenu
typealias LecternContainer = LecternMenu
typealias LoomContainer = LoomMenu
typealias MerchantContainer = MerchantMenu
typealias PlayerContainer = InventoryMenu
typealias ShulkerBoxContainer = ShulkerBoxMenu
typealias SmokerContainer = SmokerMenu
typealias SmithingTableContainer = SmithingMenu
typealias StonecutterContainer = StonecutterMenu
typealias FurnaceContainer = FurnaceMenu

typealias Inventory = Container // Inventory is BasicInventory!!!!!!!
typealias PlayerInventory = Inventory
typealias CraftingInventory = CraftingContainer
typealias CraftingResultInventory = ResultContainer
typealias TraderInventory = VanillaMerchantInventory

typealias Slot = Slot
typealias TradeOutputSlot = MerchantResultSlot
typealias CraftingResultSlot = ResultSlot

typealias SlotActionType = ClickType

val vanillaContainers = listOf<Class<*>>(PlayerContainer::class.java,
                                         CreativeContainer::class.java,
                                         EnchantingTableContainer::class.java,
                                         AnvilContainer::class.java,
                                         BeaconContainer::class.java,
                                         CartographyTableContainer::class.java,
                                         FurnaceContainer::class.java,
                                         GrindstoneContainer::class.java,
                                         LecternContainer::class.java,
                                         LoomContainer::class.java,
                                         StonecutterContainer::class.java,
                                         MerchantContainer::class.java,
                                         CraftingTableContainer::class.java,
                                         HopperContainer::class.java,
                                         BrewingStandContainer::class.java,
                                         AbstractFurnaceContainer::class.java,
                                         GenericContainer::class.java,
                                         ShulkerBoxContainer::class.java,
                                         HorseContainer::class.java,
                                         Generic3x3Container::class.java,
                                         AbstractFurnaceContainer::class.java)
