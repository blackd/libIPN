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

val vanillaContainers = listOf<Class<*>>(
    AbstractFurnaceContainer::class.java,
    AbstractRecipeContainer::class.java,
    AnvilContainer::class.java,
    BeaconContainer::class.java,
    BlastFurnaceContainer::class.java,
    BrewingStandContainer::class.java,
    CartographyTableContainer::class.java,
    CrafterContainer::class.java,
    CraftingTableContainer::class.java,
    EnchantingTableContainer::class.java,
    FurnaceContainer::class.java,
    Generic3x3Container::class.java,
    GenericContainer::class.java,
    GrindstoneContainer::class.java,
    HopperContainer::class.java,
    HorseContainer::class.java,
    LecternContainer::class.java,
    LoomContainer::class.java,
    MerchantContainer::class.java,
    PlayerContainer::class.java,
    ShulkerBoxContainer::class.java,
    SmithingTableContainer::class.java,
    SmokerContainer::class.java,
    StonecutterContainer::class.java,
    ForgingContainer::class.java,)

val ForgingContainer.`(inputSlotIndices)`
    get() = this.inputSlotIndexes
