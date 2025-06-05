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

import net.minecraft.screen.AbstractFurnaceScreenHandler
import net.minecraft.screen.AbstractRecipeScreenHandler
import net.minecraft.screen.AnvilScreenHandler
import net.minecraft.screen.BeaconScreenHandler
import net.minecraft.screen.BlastFurnaceScreenHandler
import net.minecraft.screen.BrewingStandScreenHandler
import net.minecraft.screen.CartographyTableScreenHandler
import net.minecraft.screen.CrafterScreenHandler
import net.minecraft.screen.CraftingScreenHandler
import net.minecraft.screen.EnchantmentScreenHandler
import net.minecraft.screen.ForgingScreenHandler
import net.minecraft.screen.FurnaceScreenHandler
import net.minecraft.screen.Generic3x3ContainerScreenHandler
import net.minecraft.screen.GenericContainerScreenHandler
import net.minecraft.screen.GrindstoneScreenHandler
import net.minecraft.screen.HopperScreenHandler
import net.minecraft.screen.HorseScreenHandler
import net.minecraft.screen.LecternScreenHandler
import net.minecraft.screen.LoomScreenHandler
import net.minecraft.screen.MerchantScreenHandler
import net.minecraft.screen.PlayerScreenHandler
import net.minecraft.screen.ShulkerBoxScreenHandler
import net.minecraft.screen.SmithingScreenHandler
import net.minecraft.screen.SmokerScreenHandler
import net.minecraft.screen.StonecutterScreenHandler

val ForgingContainer.`(inputSlotIndices)`: IntRange
    get() = 0..<this.resultSlotIndex


val vanillaContainers = listOf<Class<*>>(
    AbstractFurnaceScreenHandler::class.java,
    AbstractRecipeScreenHandler::class.java,
    AnvilScreenHandler::class.java,
    BeaconScreenHandler::class.java,
    BlastFurnaceScreenHandler::class.java,
    BrewingStandScreenHandler::class.java,
    CartographyTableScreenHandler::class.java,
    CrafterScreenHandler::class.java,
    CraftingScreenHandler::class.java,
    EnchantmentScreenHandler::class.java,
    FurnaceScreenHandler::class.java,
    Generic3x3ContainerScreenHandler::class.java,
    GenericContainerScreenHandler::class.java,
    GrindstoneScreenHandler::class.java,
    HopperScreenHandler::class.java,
    HorseScreenHandler::class.java,
    LecternScreenHandler::class.java,
    LoomScreenHandler::class.java,
    MerchantScreenHandler::class.java,
    PlayerScreenHandler::class.java,
    ShulkerBoxScreenHandler::class.java,
    SmithingScreenHandler::class.java,
    SmokerScreenHandler::class.java,
    StonecutterScreenHandler::class.java,
    ForgingScreenHandler::class.java,)
