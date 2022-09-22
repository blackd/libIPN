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

import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.CraftingInventory
import net.minecraft.inventory.CraftingResultInventory
import net.minecraft.inventory.Inventory


import net.minecraft.container.Container
import net.minecraft.container.AnvilContainer
import net.minecraft.container.AbstractFurnaceContainer
import net.minecraft.container.Slot
import net.minecraft.container.TradeOutputSlot
import net.minecraft.container.CraftingResultSlot
import net.minecraft.container.SlotActionType
import net.minecraft.container.BeaconContainer
import net.minecraft.container.BlastFurnaceContainer
import net.minecraft.container.BrewingStandContainer
import net.minecraft.container.CartographyTableContainer
import net.minecraft.container.CraftingTableContainer
import net.minecraft.container.EnchantingTableContainer
import net.minecraft.container.FurnaceContainer
import net.minecraft.container.Generic3x3Container
import net.minecraft.container.GenericContainer
import net.minecraft.container.GrindstoneContainer
import net.minecraft.container.HopperContainer
import net.minecraft.container.HorseContainer
import net.minecraft.container.LecternContainer
import net.minecraft.container.LoomContainer
import net.minecraft.container.MerchantContainer
import net.minecraft.container.PlayerContainer
import net.minecraft.container.ShulkerBoxContainer
import net.minecraft.container.SmokerContainer
import net.minecraft.container.StonecutterContainer


//import net.minecraft.village.TraderInventory

typealias Container = Container
typealias CreativeContainer = CreativeInventoryScreen.CreativeContainer
typealias AbstractFurnaceContainer = AbstractFurnaceContainer
typealias AnvilContainer = AnvilContainer
typealias BeaconContainer = BeaconContainer
typealias BlastFurnaceContainer = BlastFurnaceContainer
typealias BrewingStandContainer = BrewingStandContainer
typealias CartographyTableContainer = CartographyTableContainer
typealias CraftingTableContainer = CraftingTableContainer
typealias EnchantingTableContainer = EnchantingTableContainer
typealias Generic3x3Container = Generic3x3Container
typealias GenericContainer = GenericContainer
typealias GrindstoneContainer = GrindstoneContainer
typealias HopperContainer = HopperContainer
typealias HorseContainer = HorseContainer
typealias LecternContainer = LecternContainer
typealias LoomContainer = LoomContainer
typealias MerchantContainer = MerchantContainer
typealias PlayerContainer = PlayerContainer
typealias ShulkerBoxContainer = ShulkerBoxContainer
typealias SmokerContainer = SmokerContainer
typealias StonecutterContainer = StonecutterContainer

typealias FurnaceContainer = FurnaceContainer

typealias Inventory = Inventory
typealias PlayerInventory = PlayerInventory
typealias CraftingInventory = CraftingInventory
typealias CraftingResultInventory = CraftingResultInventory
//typealias TraderInventory = TraderInventory

typealias Slot = Slot
typealias TradeOutputSlot = TradeOutputSlot
typealias CraftingResultSlot = CraftingResultSlot

typealias SlotActionType = SlotActionType

val vanillaContainers = listOf<Class<*>>(PlayerContainer::class.java,
                                         CreativeContainer::class.java,
                                         EnchantingTableContainer::class.java,
                                         AnvilContainer::class.java,
                                         BeaconContainer::class.java,
                                         CartographyTableContainer::class.java,
                                         GrindstoneContainer::class.java,
                                         LecternContainer::class.java,
                                         LoomContainer::class.java,
                                         StonecutterContainer::class.java,
                                         MerchantContainer::class.java,
                                         CraftingTableContainer::class.java,
                                         HopperContainer::class.java,
                                         BrewingStandContainer::class.java,
                                         AbstractFurnaceContainer::class.java,
                                         FurnaceContainer::class.java,
                                         GenericContainer::class.java,
                                         ShulkerBoxContainer::class.java,
                                         HorseContainer::class.java,
                                         Generic3x3Container::class.java)
