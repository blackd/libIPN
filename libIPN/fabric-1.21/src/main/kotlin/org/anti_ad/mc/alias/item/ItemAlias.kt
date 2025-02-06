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

package org.anti_ad.mc.alias.item

import net.minecraft.item.AirBlockItem
import net.minecraft.item.AliasedBlockItem
import net.minecraft.item.AnimalArmorItem
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ArmorMaterials
import net.minecraft.item.ArmorStandItem
import net.minecraft.item.ArrowItem
import net.minecraft.item.AutomaticItemPlacementContext
import net.minecraft.item.AxeItem
import net.minecraft.item.BannerItem
import net.minecraft.item.BannerPatternItem
import net.minecraft.item.BedItem
import net.minecraft.item.BlockItem
import net.minecraft.item.BlockPredicatesChecker
import net.minecraft.item.BoatItem
import net.minecraft.item.BoneMealItem
import net.minecraft.item.BookItem
import net.minecraft.item.BowItem
import net.minecraft.item.BrushItem
import net.minecraft.item.BucketItem
import net.minecraft.item.BundleItem
import net.minecraft.item.ChorusFruitItem
import net.minecraft.item.CompassItem
import net.minecraft.item.CrossbowItem
import net.minecraft.item.DebugStickItem
import net.minecraft.item.DecorationItem
import net.minecraft.item.DiscFragmentItem
import net.minecraft.item.DyeItem
import net.minecraft.item.EggItem
import net.minecraft.item.ElytraItem
import net.minecraft.item.EmptyMapItem
import net.minecraft.item.EnchantedBookItem
import net.minecraft.item.EndCrystalItem
import net.minecraft.item.EnderEyeItem
import net.minecraft.item.EnderPearlItem
import net.minecraft.item.EntityBucketItem
import net.minecraft.item.Equipment
import net.minecraft.item.ExperienceBottleItem
import net.minecraft.item.FilledMapItem
import net.minecraft.item.FireChargeItem
import net.minecraft.item.FireworkRocketItem
import net.minecraft.item.FireworkStarItem
import net.minecraft.item.FishingRodItem
import net.minecraft.item.FlintAndSteelItem
import net.minecraft.item.FluidModificationItem
import net.minecraft.item.GlassBottleItem
import net.minecraft.item.GlowInkSacItem
import net.minecraft.item.GoatHornItem
import net.minecraft.item.HangingSignItem
import net.minecraft.item.HoeItem
import net.minecraft.item.HoneyBottleItem
import net.minecraft.item.HoneycombItem
import net.minecraft.item.InkSacItem
import net.minecraft.item.Instrument
import net.minecraft.item.Instruments
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemFrameItem
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemKeys
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemStackSet
import net.minecraft.item.ItemUsage
import net.minecraft.item.ItemUsageContext
import net.minecraft.item.Items
import net.minecraft.item.KnowledgeBookItem
import net.minecraft.item.LeadItem
import net.minecraft.item.LingeringPotionItem
import net.minecraft.item.MaceItem
import net.minecraft.item.MilkBucketItem
import net.minecraft.item.MinecartItem
import net.minecraft.item.MiningToolItem
import net.minecraft.item.NameTagItem
import net.minecraft.item.NetworkSyncedItem
import net.minecraft.item.OminousBottleItem
import net.minecraft.item.OnAStickItem
import net.minecraft.item.OperatorOnlyBlockItem
import net.minecraft.item.PickaxeItem
import net.minecraft.item.PlaceableOnWaterItem
import net.minecraft.item.PlayerHeadItem
import net.minecraft.item.PotionItem
import net.minecraft.item.PowderSnowBucketItem
import net.minecraft.item.ProjectileItem
import net.minecraft.item.RangedWeaponItem
import net.minecraft.item.SaddleItem
import net.minecraft.item.ScaffoldingItem
import net.minecraft.item.ShearsItem
import net.minecraft.item.ShieldItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SignChangingItem
import net.minecraft.item.SignItem
import net.minecraft.item.SmithingTemplateItem
import net.minecraft.item.SnowballItem
import net.minecraft.item.SpawnEggItem
import net.minecraft.item.SpectralArrowItem
import net.minecraft.item.SplashPotionItem
import net.minecraft.item.SpyglassItem
import net.minecraft.item.SuspiciousStewItem
import net.minecraft.item.SwordItem
import net.minecraft.item.TallBlockItem
import net.minecraft.item.ThrowablePotionItem
import net.minecraft.item.TippedArrowItem
import net.minecraft.item.ToolItem
import net.minecraft.item.ToolMaterial
import net.minecraft.item.ToolMaterials
import net.minecraft.item.TridentItem
import net.minecraft.item.VerticallyAttachableBlockItem
import net.minecraft.item.WindChargeItem
import net.minecraft.item.WritableBookItem
import net.minecraft.item.WrittenBookItem
import net.minecraft.item.tooltip.TooltipData

typealias AirBlockItem = AirBlockItem
typealias AliasedBlockItem = AliasedBlockItem
typealias AnimalArmorItem = AnimalArmorItem
typealias ArmorItem = ArmorItem
typealias ArmorMaterial = ArmorMaterial
typealias ArmorMaterials = ArmorMaterials
typealias ArmorStandItem = ArmorStandItem
typealias ArrowItem = ArrowItem
typealias AutomaticItemPlacementContext = AutomaticItemPlacementContext
typealias AxeItem = AxeItem
typealias BannerItem = BannerItem
typealias BannerPatternItem = BannerPatternItem
typealias BedItem = BedItem
typealias BlockItem = BlockItem
typealias BlockPredicatesChecker = BlockPredicatesChecker
typealias BoatItem = BoatItem
typealias BoneMealItem = BoneMealItem
typealias BookItem = BookItem
typealias BowItem = BowItem
typealias BrushItem = BrushItem
typealias BucketItem = BucketItem
typealias BundleItem = BundleItem
typealias ChorusFruitItem = ChorusFruitItem
typealias CompassItem = CompassItem
typealias CrossbowItem = CrossbowItem
typealias DebugStickItem = DebugStickItem
typealias DecorationItem = DecorationItem
typealias DiscFragmentItem = DiscFragmentItem
typealias DyeItem = DyeItem
typealias EggItem = EggItem
typealias ElytraItem = ElytraItem
typealias EmptyMapItem = EmptyMapItem
typealias EnchantedBookItem = EnchantedBookItem
typealias EndCrystalItem = EndCrystalItem
typealias EnderEyeItem = EnderEyeItem
typealias EnderPearlItem = EnderPearlItem
typealias EntityBucketItem = EntityBucketItem
typealias Equipment = Equipment
typealias ExperienceBottleItem = ExperienceBottleItem
typealias FilledMapItem = FilledMapItem
typealias FireChargeItem = FireChargeItem
typealias FireworkRocketItem = FireworkRocketItem
typealias FireworkStarItem = FireworkStarItem
typealias FishingRodItem = FishingRodItem
typealias FlintAndSteelItem = FlintAndSteelItem
typealias FluidModificationItem = FluidModificationItem
typealias GlassBottleItem = GlassBottleItem
typealias GlowInkSacItem = GlowInkSacItem
typealias GoatHornItem = GoatHornItem
typealias HangingSignItem = HangingSignItem
typealias HoeItem = HoeItem
typealias HoneyBottleItem = HoneyBottleItem
typealias HoneycombItem = HoneycombItem
typealias InkSacItem = InkSacItem
typealias Instrument = Instrument
typealias Instruments = Instruments
typealias Item = Item
typealias ItemConvertible = ItemConvertible
typealias ItemFrameItem = ItemFrameItem
typealias ItemGroup = ItemGroup
typealias ItemGroupType = ItemGroup.Type
typealias ItemGroups = ItemGroups
typealias ItemKeys = ItemKeys
typealias ItemPlacementContext = ItemPlacementContext
typealias ItemStack = ItemStack
typealias ItemStackSet = ItemStackSet
typealias ItemUsage = ItemUsage
typealias ItemUsageContext = ItemUsageContext
typealias Items = Items
typealias KnowledgeBookItem = KnowledgeBookItem
typealias LeadItem = LeadItem
typealias LingeringPotionItem = LingeringPotionItem
typealias MaceItem = MaceItem
typealias MilkBucketItem = MilkBucketItem
typealias MinecartItem = MinecartItem
typealias NameTagItem = NameTagItem
typealias NetworkSyncedItem = NetworkSyncedItem
typealias OminousBottleItem = OminousBottleItem
typealias OnAStickItem<T> = OnAStickItem<T>
typealias OperatorOnlyBlockItem = OperatorOnlyBlockItem
typealias PickaxeItem = PickaxeItem
typealias PlaceableOnWaterItem = PlaceableOnWaterItem
typealias PlayerHeadItem = PlayerHeadItem
typealias PotionItem = PotionItem
typealias PowderSnowBucketItem = PowderSnowBucketItem
typealias ProjectileItem = ProjectileItem
typealias RangedWeaponItem = RangedWeaponItem
typealias SaddleItem = SaddleItem
typealias ScaffoldingItem = ScaffoldingItem
typealias ShearsItem = ShearsItem
typealias ShieldItem = ShieldItem
typealias ShovelItem = ShovelItem
typealias SignChangingItem = SignChangingItem
typealias SignItem = SignItem
typealias SmithingTemplateItem = SmithingTemplateItem
typealias SnowballItem = SnowballItem
typealias SpawnEggItem = SpawnEggItem
typealias SpectralArrowItem = SpectralArrowItem
typealias SplashPotionItem = SplashPotionItem
typealias SpyglassItem = SpyglassItem
typealias SuspiciousStewItem = SuspiciousStewItem
typealias SwordItem = SwordItem
typealias TallBlockItem = TallBlockItem
typealias ThrowablePotionItem = ThrowablePotionItem
typealias TippedArrowItem = TippedArrowItem
typealias ToolItem = ToolItem
typealias MiningToolItem = ToolItem
typealias ToolMaterial = ToolMaterial
typealias ToolMaterials = ToolMaterials
typealias TridentItem = TridentItem
typealias VerticallyAttachableBlockItem = VerticallyAttachableBlockItem
typealias WindChargeItem = WindChargeItem
typealias WritableBookItem = WritableBookItem
typealias WrittenBookItem = WrittenBookItem
typealias TooltipData = TooltipData
typealias TooltipContext = Item.TooltipContext
