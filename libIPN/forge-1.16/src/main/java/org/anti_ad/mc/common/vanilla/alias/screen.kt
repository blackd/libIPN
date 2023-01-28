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



import net.minecraft.client.gui.screen.AbstractCommandBlockScreen
import net.minecraft.client.gui.screen.CommandBlockScreen
import net.minecraft.client.gui.screen.EditBookScreen
import net.minecraft.client.gui.screen.EditMinecartCommandBlockScreen
import net.minecraft.client.gui.screen.EditSignScreen
import net.minecraft.client.gui.screen.EditStructureScreen
import net.minecraft.client.gui.screen.EnchantmentScreen
import net.minecraft.client.gui.screen.GrindstoneScreen
import net.minecraft.client.gui.screen.HopperScreen
import net.minecraft.client.gui.screen.JigsawScreen
import net.minecraft.client.gui.screen.LecternScreen
import net.minecraft.client.gui.screen.LoomScreen
import net.minecraft.client.gui.screen.ReadBookScreen
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen
import net.minecraft.client.gui.screen.inventory.AbstractRepairScreen
import net.minecraft.client.gui.screen.inventory.AnvilScreen
import net.minecraft.client.gui.screen.inventory.BeaconScreen
import net.minecraft.client.gui.screen.inventory.BlastFurnaceScreen
import net.minecraft.client.gui.screen.inventory.BrewingStandScreen
import net.minecraft.client.gui.screen.inventory.CartographyTableScreen
import net.minecraft.client.gui.screen.inventory.ChestScreen
import net.minecraft.client.gui.screen.inventory.ContainerScreen
import net.minecraft.client.gui.screen.inventory.CraftingScreen
import net.minecraft.client.gui.screen.inventory.CreativeScreen
import net.minecraft.client.gui.screen.inventory.DispenserScreen
import net.minecraft.client.gui.screen.inventory.FurnaceScreen
import net.minecraft.client.gui.screen.inventory.HorseInventoryScreen
import net.minecraft.client.gui.screen.inventory.InventoryScreen
import net.minecraft.client.gui.screen.inventory.MerchantScreen
import net.minecraft.client.gui.screen.inventory.ShulkerBoxScreen
import net.minecraft.client.gui.screen.inventory.SmithingTableScreen
import net.minecraft.client.gui.screen.inventory.SmokerScreen
import net.minecraft.client.gui.screen.inventory.StonecutterScreen


typealias AbstractCommandBlockScreen = AbstractCommandBlockScreen
typealias AbstractFurnaceScreen<T> = AbstractFurnaceScreen<T>
typealias AbstractInventoryScreen<T> = ContainerScreen<T>
typealias AnvilScreen = AnvilScreen
typealias BeaconScreen = BeaconScreen
typealias BlastFurnaceScreen = BlastFurnaceScreen
typealias BookEditScreen = EditBookScreen
typealias BookScreen = ReadBookScreen
typealias BrewingStandScreen = BrewingStandScreen
typealias CartographyTableScreen = CartographyTableScreen
typealias CommandBlockScreen = CommandBlockScreen
typealias CraftingScreen = CraftingScreen
typealias CreativeInventoryScreen = CreativeScreen
//typealias EnchantingPhrases = EnchantingPhrases
typealias EnchantmentScreen = EnchantmentScreen
typealias ForgingScreen<T> = AbstractRepairScreen<T>
typealias FurnaceScreen = FurnaceScreen
typealias Generic3x3ContainerScreen = DispenserScreen
typealias GenericContainerScreen = ChestScreen
typealias GrindstoneScreen = GrindstoneScreen
typealias HopperScreen = HopperScreen
typealias HorseScreen = HorseInventoryScreen
typealias InventoryScreen = InventoryScreen
typealias JigsawBlockScreen = JigsawScreen
typealias LecternScreen = LecternScreen
typealias LoomScreen = LoomScreen
typealias MerchantScreen = MerchantScreen
typealias MinecartCommandBlockScreen = EditMinecartCommandBlockScreen
typealias ShulkerBoxScreen = ShulkerBoxScreen
typealias SignEditScreen = EditSignScreen
typealias SmithingScreen = SmithingTableScreen
typealias SmokerScreen = SmokerScreen
typealias StonecutterScreen = StonecutterScreen
typealias StructureBlockScreen = EditStructureScreen

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
                                          ChestScreen::class.java,
                                          CommandBlockScreen::class.java,
                                          ContainerScreen::class.java,
                                          CraftingScreen::class.java,
                                          CreativeScreen::class.java,
                                          DispenserScreen::class.java,
                                          FurnaceScreen::class.java,
                                          GrindstoneScreen::class.java,
                                          HorseInventoryScreen::class.java,
                                          HopperScreen::class.java,
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
