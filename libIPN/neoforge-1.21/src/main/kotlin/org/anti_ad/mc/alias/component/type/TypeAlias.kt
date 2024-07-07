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

package org.anti_ad.mc.alias.component.type

import net.minecraft.world.entity.EquipmentSlotGroup
import net.minecraft.world.item.component.ItemAttributeModifiers
import net.minecraft.world.level.block.entity.BannerPatterns
import net.minecraft.world.item.component.BlockItemStateProperties
import net.minecraft.world.item.component.BookContent
import net.minecraft.world.item.component.BundleContents
import net.minecraft.world.item.component.ChargedProjectiles
import net.minecraft.world.item.component.ItemContainerContents
import net.minecraft.world.item.component.SeededContainerLoot
import net.minecraft.world.item.component.CustomModelData
import net.minecraft.world.item.component.DebugStickState
import net.minecraft.world.item.component.DyedItemColor
import net.minecraft.world.item.component.FireworkExplosion
import net.minecraft.world.item.component.Fireworks
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.food.Foods
import net.minecraft.world.item.enchantment.ItemEnchantments
import net.minecraft.world.item.JukeboxPlayable
import net.minecraft.world.item.component.LodestoneTracker
import net.minecraft.world.item.component.ItemLore
import net.minecraft.world.item.component.MapItemColor
import net.minecraft.world.item.component.MapDecorations
import net.minecraft.world.level.saveddata.maps.MapId
import net.minecraft.world.item.component.MapPostProcessing
import net.minecraft.world.item.component.CustomData
import net.minecraft.world.item.alchemy.PotionContents
import net.minecraft.world.item.component.ResolvableProfile
import net.minecraft.world.item.component.SuspiciousStewEffects
import net.minecraft.world.item.component.Tool
import net.minecraft.world.item.component.Unbreakable
import net.minecraft.world.item.component.WritableBookContent
import net.minecraft.world.item.component.WrittenBookContent


typealias AttributeModifierSlot = EquipmentSlotGroup
typealias AttributeModifiersComponent = ItemAttributeModifiers
typealias BannerPatternsComponent = BannerPatterns
typealias BlockStateComponent = BlockItemStateProperties
typealias BookContent<T, C> = BookContent<T, C>
typealias BundleContentsComponent = BundleContents
typealias ChargedProjectilesComponent = ChargedProjectiles
typealias ContainerComponent = ItemContainerContents
typealias ContainerLootComponent = SeededContainerLoot
typealias CustomModelDataComponent = CustomModelData
typealias DebugStickStateComponent = DebugStickState
typealias DyedColorComponent = DyedItemColor
typealias FireworkExplosionComponent = FireworkExplosion
typealias FireworksComponent = Fireworks
typealias FoodComponent = FoodProperties
typealias FoodComponents = Foods
typealias ItemEnchantmentsComponent = ItemEnchantments
typealias JukeboxPlayableComponent = JukeboxPlayable
typealias LodestoneTrackerComponent = LodestoneTracker
typealias LoreComponent = ItemLore
typealias MapColorComponent = MapItemColor
typealias MapDecorationsComponent = MapDecorations
typealias MapIdComponent = MapId
typealias MapPostProcessingComponent = MapPostProcessing
typealias NbtComponent = CustomData
typealias PotionContentsComponent = PotionContents
typealias ProfileComponent = ResolvableProfile
typealias SuspiciousStewEffectsComponent = SuspiciousStewEffects
typealias ToolComponent = Tool
typealias UnbreakableComponent = Unbreakable
typealias WritableBookContentComponent = WritableBookContent
typealias WrittenBookContentComponent = WrittenBookContent
