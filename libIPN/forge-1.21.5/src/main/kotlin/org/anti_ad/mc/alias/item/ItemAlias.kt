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

import net.minecraft.world.item.AirItem
/*
import net.minecraft.item.AliasedBlockItem
*/
import net.minecraft.world.item.equipment.ArmorMaterial
import net.minecraft.world.item.equipment.ArmorMaterials
import net.minecraft.world.item.ArmorStandItem
import net.minecraft.world.item.ArrowItem
/*
import net.minecraft.item.AutomaticItemPlacementContext
*/
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.BannerItem
import net.minecraft.world.item.BedItem
import net.minecraft.world.item.BlockItem
/*
import net.minecraft.item.BlockPredicatesChecker
*/
import net.minecraft.world.item.BoatItem
import net.minecraft.world.item.BoneMealItem
import net.minecraft.world.item.BowItem
import net.minecraft.world.item.BrushItem
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.BundleItem
import net.minecraft.world.item.CompassItem
import net.minecraft.world.item.CrossbowItem
import net.minecraft.world.item.DebugStickItem
import net.minecraft.world.item.HangingEntityItem
import net.minecraft.world.item.DiscFragmentItem
import net.minecraft.world.item.DyeItem
import net.minecraft.world.item.EggItem
import net.minecraft.world.item.EmptyMapItem
import net.minecraft.world.item.EndCrystalItem
import net.minecraft.world.item.EnderEyeItem
import net.minecraft.world.item.EnderpearlItem
import net.minecraft.world.item.MobBucketItem
import net.minecraft.world.item.ExperienceBottleItem
import net.minecraft.world.item.MapItem
import net.minecraft.world.item.FireChargeItem
import net.minecraft.world.item.FireworkRocketItem
import net.minecraft.world.item.FishingRodItem
import net.minecraft.world.item.FlintAndSteelItem
/*
import net.minecraft.world.item.FluidModificationItem
*/
import net.minecraft.world.item.BottleItem
import net.minecraft.world.item.GlowInkSacItem
import net.minecraft.world.item.InstrumentItem
import net.minecraft.world.item.HangingSignItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.HoneycombItem
import net.minecraft.world.item.InkSacItem
import net.minecraft.world.item.Instrument
import net.minecraft.world.item.Instruments
import net.minecraft.world.item.Item
import net.minecraft.world.level.ItemLike
import net.minecraft.world.item.ItemFrameItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
/*
import net.minecraft.item.ItemKeys
*/
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.ItemStackLinkedSet
/*
import net.minecraft.item.ItemUsage
*/
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.item.Items
import net.minecraft.world.item.KnowledgeBookItem
import net.minecraft.world.item.LeadItem
import net.minecraft.world.item.LingeringPotionItem
import net.minecraft.world.item.MaceItem
import net.minecraft.world.item.MinecartItem
/*
import net.minecraft.item.MiningToolItem
*/
import net.minecraft.world.item.NameTagItem
/*
import net.minecraft.item.NetworkSyncedItem
*/
import net.minecraft.world.item.FoodOnAStickItem
/*
import net.minecraft.item. OperatorOnlyBlockItem
*/
import net.minecraft.world.item.PlaceOnWaterBlockItem
import net.minecraft.world.item.PlayerHeadItem
import net.minecraft.world.item.PotionItem
import net.minecraft.world.item.SolidBucketItem
import net.minecraft.world.item.ProjectileItem
import net.minecraft.world.item.ProjectileWeaponItem
import net.minecraft.world.item.ScaffoldingBlockItem
import net.minecraft.world.item.ShearsItem
import net.minecraft.world.item.ShieldItem
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.SignApplicator
import net.minecraft.world.item.SignItem
import net.minecraft.world.item.SmithingTemplateItem
import net.minecraft.world.item.SnowballItem
import net.minecraft.world.item.SpawnEggItem
import net.minecraft.world.item.SpectralArrowItem
import net.minecraft.world.item.SplashPotionItem
import net.minecraft.world.item.SpyglassItem
import net.minecraft.world.item.DoubleHighBlockItem
import net.minecraft.world.item.ThrowablePotionItem
import net.minecraft.world.item.TippedArrowItem

/*
import net.minecraft.item.ToolMaterials
*/
import net.minecraft.world.item.TridentItem
/*
import net.minecraft.world.item.VerticallyAttachableBlockItem
*/
import net.minecraft.world.item.WindChargeItem
import net.minecraft.world.item.WritableBookItem
import net.minecraft.world.item.WrittenBookItem


typealias AirBlockItem = AirItem
/*
typealias AliasedBlockItem = AliasedBlockItem
*/
typealias ArmorMaterial = ArmorMaterial
typealias ArmorMaterials = ArmorMaterials
typealias ArmorStandItem = ArmorStandItem
typealias ArrowItem = ArrowItem
/*
typealias AutomaticItemPlacementContext = AutomaticItemPlacementContext
*/
typealias AxeItem = AxeItem
typealias BannerItem = BannerItem
typealias BedItem = BedItem
typealias BlockItem = BlockItem
/*
typealias BlockPredicatesChecker = BlockPredicatesChecker
*/
typealias BoatItem = BoatItem
typealias BoneMealItem = BoneMealItem
typealias BowItem = BowItem
typealias BrushItem = BrushItem
typealias BucketItem = BucketItem
typealias BundleItem = BundleItem
typealias CompassItem = CompassItem
typealias CrossbowItem = CrossbowItem
typealias DebugStickItem = DebugStickItem
typealias DecorationItem = HangingEntityItem
typealias DiscFragmentItem = DiscFragmentItem
typealias DyeItem = DyeItem
typealias EggItem = EggItem
typealias EmptyMapItem = EmptyMapItem
typealias EndCrystalItem = EndCrystalItem
typealias EnderEyeItem = EnderEyeItem
typealias EnderPearlItem = EnderpearlItem
typealias EntityBucketItem = MobBucketItem
typealias ExperienceBottleItem = ExperienceBottleItem
typealias FilledMapItem = MapItem
typealias FireChargeItem = FireChargeItem
typealias FireworkRocketItem = FireworkRocketItem
typealias FishingRodItem = FishingRodItem
typealias FlintAndSteelItem = FlintAndSteelItem
/*
typealias FluidModificationItem = FluidModificationItem
*/
typealias GlassBottleItem = BottleItem
typealias GlowInkSacItem = GlowInkSacItem
typealias GoatHornItem = InstrumentItem
typealias HangingSignItem = HangingSignItem
typealias HoeItem = HoeItem
typealias HoneycombItem = HoneycombItem
typealias InkSacItem = InkSacItem
typealias Instrument = Instrument
typealias Instruments = Instruments
typealias Item = Item
typealias ItemConvertible = ItemLike
typealias ItemFrameItem = ItemFrameItem
typealias ItemGroup = CreativeModeTab
typealias ItemGroupType = CreativeModeTab.Type
typealias ItemGroups = CreativeModeTabs
/*
typealias ItemKeys = ItemKeys
*/
typealias ItemPlacementContext = BlockPlaceContext
typealias ItemStack = ItemStack
typealias ItemStackSet = ItemStackLinkedSet
/*
typealias ItemUsage = ItemUsage
*/
typealias ItemUsageContext = UseOnContext
typealias Items = Items
typealias KnowledgeBookItem = KnowledgeBookItem
typealias LeadItem = LeadItem
typealias LingeringPotionItem = LingeringPotionItem
typealias MaceItem = MaceItem
typealias MinecartItem = MinecartItem
/*
typealias MiningToolItem = MiningToolItem
*/
typealias NameTagItem = NameTagItem
/*
typealias NetworkSyncedItem = NetworkSyncedItem
*/
typealias OnAStickItem<T> = FoodOnAStickItem<T>
/*
typealias OperatorOnlyBlockItem = OperatorOnlyBlockItem
*/
typealias PlaceableOnWaterItem = PlaceOnWaterBlockItem
typealias PlayerHeadItem = PlayerHeadItem
typealias PotionItem = PotionItem
typealias PowderSnowBucketItem = SolidBucketItem
typealias ProjectileItem = ProjectileItem
typealias RangedWeaponItem = ProjectileWeaponItem
typealias ScaffoldingItem = ScaffoldingBlockItem
typealias ShearsItem = ShearsItem
typealias ShieldItem = ShieldItem
typealias ShovelItem = ShovelItem
typealias SignChangingItem = SignApplicator
typealias SignItem = SignItem
typealias SmithingTemplateItem = SmithingTemplateItem
typealias SnowballItem = SnowballItem
typealias SpawnEggItem = SpawnEggItem
typealias SpectralArrowItem = SpectralArrowItem
typealias SplashPotionItem = SplashPotionItem
typealias SpyglassItem = SpyglassItem
typealias TallBlockItem = DoubleHighBlockItem
typealias ThrowablePotionItem = ThrowablePotionItem
typealias TippedArrowItem = TippedArrowItem


/*
typealias ToolMaterial = Tier
typealias ToolMaterials = Tiers
*/
typealias TridentItem = TridentItem
/*
typealias VerticallyAttachableBlockItem = VerticallyAttachableBlockItem
*/
typealias WindChargeItem = WindChargeItem
typealias WritableBookItem = WritableBookItem
typealias WrittenBookItem = WrittenBookItem
typealias TooltipContext = Item.TooltipContext
