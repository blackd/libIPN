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

@file:Suppress("HasPlatformType", "ObjectPropertyName", "unused", "FunctionName")

package org.anti_ad.mc.alias.client.gui.screen.ingame

//Merchant
val MerchantScreen.`(recipes)`
    get() = this.screenHandler.recipes

val MerchantScreen.`(indexStartOffset)`
    get() = indexStartOffset

var MerchantScreen.`(selectedIndex)`: Int
    get() = selectedIndex
    set(value) {
        selectedIndex = value
    }

fun MerchantScreen.`(syncRecipeIndex)`() = this.syncRecipeIndex()


val MerchantScreen.`(offers)`
    get() = offers


//Anvil
val AnvilScreen.`(nameField)`
    get() = this.nameField

var AnvilScreen.`(nameFieldText)`
    get() = this.nameField.text
    set(value) {
        this.nameField.text = value
    }

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
                                          StructureBlockScreen::class.java,
                                          CrafterScreen::class.java,)