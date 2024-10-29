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

package org.anti_ad.mc.alias.block

import net.minecraft.world.level.block.AbstractBannerBlock
/*
import net.minecraft.block.AbstractBlock
*/
import net.minecraft.world.level.block.AbstractCandleBlock
import net.minecraft.world.level.block.AbstractCauldronBlock
import net.minecraft.world.level.block.AbstractChestBlock
import net.minecraft.world.level.block.BaseFireBlock
import net.minecraft.world.level.block.AbstractFurnaceBlock
/*
import net.minecraft.world.level.block.AbstractPlantBlock
import net.minecraft.world.level.block.AbstractPlantPartBlock
import net.minecraft.world.level.block.AbstractPlantStemBlock
import net.minecraft.world.level.block.AbstractPressurePlateBlock
import net.minecraft.world.level.block.AbstractRailBlock
import net.minecraft.world.level.block.AbstractRedstoneGateBlock
import net.minecraft.world.level.block.AbstractSignBlock
*/
import net.minecraft.world.level.block.AbstractSkullBlock
/*
import net.minecraft.world.level.block.AbstractTorchBlock
*/
import net.minecraft.world.level.block.AirBlock
import net.minecraft.world.level.block.AmethystBlock
import net.minecraft.world.level.block.AmethystClusterBlock
import net.minecraft.world.level.block.AnvilBlock
import net.minecraft.world.level.block.AttachedStemBlock
import net.minecraft.world.level.block.AzaleaBlock
/*
import net.minecraft.world.level.block.BambooBlock
import net.minecraft.world.level.block.BambooShootBlock
*/
import net.minecraft.world.level.block.BannerBlock
import net.minecraft.world.level.block.BarrelBlock
import net.minecraft.world.level.block.BarrierBlock
import net.minecraft.world.level.block.BeaconBlock
import net.minecraft.world.level.block.BedBlock
import net.minecraft.world.level.block.BeehiveBlock
/*
import net.minecraft.world.level.block.BeetrootsBlock
*/
import net.minecraft.world.level.block.BellBlock
import net.minecraft.world.level.block.BigDripleafBlock
import net.minecraft.world.level.block.BigDripleafStemBlock
import net.minecraft.world.level.block.BlastFurnaceBlock
import net.minecraft.world.level.block.Block
/*
import net.minecraft.world.level.block.BlockEntityProvider
import net.minecraft.world.level.block.BlockKeys
import net.minecraft.world.level.block.BlockRenderType
import net.minecraft.world.level.block.BlockSetType
import net.minecraft.world.level.block.BlockState
*/
import net.minecraft.world.level.block.BlockTypes
/*
import net.minecraft.world.level.block.BlockWithEntity
*/
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.BrewingStandBlock
import net.minecraft.world.level.block.BrushableBlock
import net.minecraft.world.level.block.BubbleColumnBlock
import net.minecraft.world.level.block.BuddingAmethystBlock
/*
import net.minecraft.world.level.block.BulbBlock
*/
import net.minecraft.world.level.block.ButtonBlock
import net.minecraft.world.level.block.CactusBlock
import net.minecraft.world.level.block.CakeBlock
import net.minecraft.world.level.block.CalibratedSculkSensorBlock
import net.minecraft.world.level.block.CampfireBlock
import net.minecraft.world.level.block.CandleBlock
import net.minecraft.world.level.block.CandleCakeBlock
import net.minecraft.world.level.block.CarpetBlock
/*
import net.minecraft.world.level.block.CarrotsBlock
*/
import net.minecraft.world.level.block.CartographyTableBlock
import net.minecraft.world.level.block.CarvedPumpkinBlock
import net.minecraft.world.level.block.CauldronBlock
import net.minecraft.world.level.block.CaveVines
/*
import net.minecraft.world.level.block.CaveVinesBodyBlock
import net.minecraft.world.level.block.CaveVinesHeadBlock
*/
import net.minecraft.world.level.block.ChainBlock
import net.minecraft.world.level.block.CherryLeavesBlock
import net.minecraft.world.level.block.ChestBlock
/*
import net.minecraft.world.level.block.ChiseledBookshelfBlock
*/
import net.minecraft.world.level.block.ChorusFlowerBlock
import net.minecraft.world.level.block.ChorusPlantBlock
/*
import net.minecraft.world.level.block.CobwebBlock
*/
import net.minecraft.world.level.block.CocoaBlock
import net.minecraft.world.level.block.ColoredFallingBlock
import net.minecraft.world.level.block.CommandBlock
import net.minecraft.world.level.block.ComparatorBlock
import net.minecraft.world.level.block.ComposterBlock
import net.minecraft.world.level.block.ConcretePowderBlock
import net.minecraft.world.level.block.ConduitBlock
/*
import net.minecraft.world.level.block.ConnectingBlock
*/
import net.minecraft.world.level.block.CoralBlock
/*
import net.minecraft.world.level.block.CoralBlockBlock
*/
import net.minecraft.world.level.block.CoralFanBlock
/*
import net.minecraft.world.level.block.CoralParentBlock
*/
import net.minecraft.world.level.block.CoralWallFanBlock
import net.minecraft.world.level.block.CrafterBlock
import net.minecraft.world.level.block.CraftingTableBlock
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.CryingObsidianBlock
import net.minecraft.world.level.block.DaylightDetectorBlock
import net.minecraft.world.level.block.DeadBushBlock
/*
import net.minecraft.world.level.block.DeadCoralBlock
import net.minecraft.world.level.block.DeadCoralFanBlock
import net.minecraft.world.level.block.DeadCoralWallFanBlock
*/
import net.minecraft.world.level.block.DecoratedPotBlock
/*
import net.minecraft.world.level.block.DecoratedPotPattern
import net.minecraft.world.level.block.DecoratedPotPatterns
import net.minecraft.world.level.block.Degradable
*/
import net.minecraft.world.level.block.DetectorRailBlock
import net.minecraft.world.level.block.DirtPathBlock
import net.minecraft.world.level.block.DispenserBlock
import net.minecraft.world.level.block.DoorBlock
/*
import net.minecraft.world.level.block.DoubleBlockProperties
*/
import net.minecraft.world.level.block.DragonEggBlock
import net.minecraft.world.level.block.DropperBlock
/*
import net.minecraft.world.level.block.DyedCarpetBlock
*/
import net.minecraft.world.level.block.EnchantingTableBlock
import net.minecraft.world.level.block.EndGatewayBlock
import net.minecraft.world.level.block.EndPortalBlock
import net.minecraft.world.level.block.EndPortalFrameBlock
import net.minecraft.world.level.block.EndRodBlock
import net.minecraft.world.level.block.EnderChestBlock
/*
import net.minecraft.world.level.block.EntityShapeContext
import net.minecraft.world.level.block.ExperienceDroppingBlock
import net.minecraft.world.level.block.FacingBlock
*/
import net.minecraft.world.level.block.FallingBlock
/*
import net.minecraft.world.level.block.FarmlandBlock
*/
import net.minecraft.world.level.block.FenceBlock
import net.minecraft.world.level.block.FenceGateBlock
/*
import net.minecraft.world.level.block.Fertilizable
*/
import net.minecraft.world.level.block.FireBlock
import net.minecraft.world.level.block.FletchingTableBlock
import net.minecraft.world.level.block.FlowerBlock
import net.minecraft.world.level.block.FlowerPotBlock
/*
import net.minecraft.world.level.block.FlowerbedBlock
import net.minecraft.world.level.block.FluidBlock
import net.minecraft.world.level.block.FluidDrainable
import net.minecraft.world.level.block.FluidFillable
*/
import net.minecraft.world.level.block.FrogspawnBlock
import net.minecraft.world.level.block.FrostedIceBlock
import net.minecraft.world.level.block.FungusBlock
import net.minecraft.world.level.block.FurnaceBlock
import net.minecraft.world.level.block.GlazedTerracottaBlock
import net.minecraft.world.level.block.GlowLichenBlock
import net.minecraft.world.level.block.GrassBlock
/*
import net.minecraft.world.level.block.GrateBlock
*/
import net.minecraft.world.level.block.GrindstoneBlock
import net.minecraft.world.level.block.HangingRootsBlock
/*
import net.minecraft.world.level.block.HangingSignBlock
*/
import net.minecraft.world.level.block.HayBlock
import net.minecraft.world.level.block.HeavyCoreBlock
import net.minecraft.world.level.block.HoneyBlock
import net.minecraft.world.level.block.HopperBlock
/*
import net.minecraft.world.level.block.HorizontalConnectingBlock
import net.minecraft.world.level.block.HorizontalFacingBlock
*/
import net.minecraft.world.level.block.IceBlock
import net.minecraft.world.level.block.InfestedBlock
/*
import net.minecraft.world.level.block.InventoryProvider
*/
import net.minecraft.world.level.block.JigsawBlock
import net.minecraft.world.level.block.JukeboxBlock
import net.minecraft.world.level.block.KelpBlock
import net.minecraft.world.level.block.KelpPlantBlock
import net.minecraft.world.level.block.LadderBlock
/*
import net.minecraft.world.level.block.LandingBlock
*/
import net.minecraft.world.level.block.LanternBlock
import net.minecraft.world.level.block.LavaCauldronBlock
import net.minecraft.world.level.block.LeavesBlock
import net.minecraft.world.level.block.LecternBlock
/*
import net.minecraft.world.level.block.LeveledCauldronBlock
*/
import net.minecraft.world.level.block.LeverBlock
/*
import net.minecraft.world.level.block.LichenGrower
*/
import net.minecraft.world.level.block.LightBlock
import net.minecraft.world.level.block.LightningRodBlock
/*
import net.minecraft.world.level.block.LilyPadBlock
*/
import net.minecraft.world.level.block.LoomBlock
import net.minecraft.world.level.block.MagmaBlock
import net.minecraft.world.level.block.MangroveLeavesBlock
import net.minecraft.world.level.block.MangroveRootsBlock
/*
import net.minecraft.world.level.block.MapColor
import net.minecraft.world.level.block.MossBlock
*/
import net.minecraft.world.level.block.MudBlock
/*
import net.minecraft.world.level.block.MultifaceGrowthBlock
*/
import net.minecraft.world.level.block.MushroomBlock
/*
import net.minecraft.world.level.block.MushroomPlantBlock
*/
import net.minecraft.world.level.block.MyceliumBlock
import net.minecraft.world.level.block.NetherPortalBlock
import net.minecraft.world.level.block.NetherWartBlock
import net.minecraft.world.level.block.NetherrackBlock
import net.minecraft.world.level.block.NoteBlock
import net.minecraft.world.level.block.NyliumBlock
import net.minecraft.world.level.block.ObserverBlock
/*
import net.minecraft.world.level.block.OperatorBlock
import net.minecraft.world.level.block.Oxidizable
import net.minecraft.world.level.block.OxidizableBlock
import net.minecraft.world.level.block.OxidizableBulbBlock
import net.minecraft.world.level.block.OxidizableDoorBlock
import net.minecraft.world.level.block.OxidizableGrateBlock
import net.minecraft.world.level.block.OxidizableSlabBlock
import net.minecraft.world.level.block.OxidizableStairsBlock
import net.minecraft.world.level.block.OxidizableTrapdoorBlock
import net.minecraft.world.level.block.PaneBlock
import net.minecraft.world.level.block.PillarBlock
import net.minecraft.world.level.block.PistonBlock
import net.minecraft.world.level.block.PistonExtensionBlock
import net.minecraft.world.level.block.PistonHeadBlock
*/
import net.minecraft.world.level.block.PitcherCropBlock
/*
import net.minecraft.world.level.block.PlantBlock
import net.minecraft.world.level.block.PlayerSkullBlock
*/
import net.minecraft.world.level.block.PointedDripstoneBlock
import net.minecraft.world.level.block.Portal
/*
import net.minecraft.world.level.block.PotatoesBlock
*/
import net.minecraft.world.level.block.PowderSnowBlock
import net.minecraft.world.level.block.PoweredRailBlock
import net.minecraft.world.level.block.PressurePlateBlock
/*
import net.minecraft.world.level.block.PropaguleBlock
*/
import net.minecraft.world.level.block.PumpkinBlock
import net.minecraft.world.level.block.RailBlock
/*
import net.minecraft.world.level.block.RailPlacementHelper
import net.minecraft.world.level.block.RedstoneBlock
*/
import net.minecraft.world.level.block.RedstoneLampBlock
/*
import net.minecraft.world.level.block.RedstoneOreBlock
*/
import net.minecraft.world.level.block.RedstoneTorchBlock
/*
import net.minecraft.world.level.block.RedstoneWireBlock
*/
import net.minecraft.world.level.block.RepeaterBlock
import net.minecraft.world.level.block.RespawnAnchorBlock
import net.minecraft.world.level.block.RodBlock
import net.minecraft.world.level.block.RootedDirtBlock
import net.minecraft.world.level.block.RootsBlock
/*
import net.minecraft.world.level.block.RotatedInfestedBlock
*/
import net.minecraft.world.level.block.SaplingBlock
/*
import net.minecraft.world.level.block.SaplingGenerator
*/
import net.minecraft.world.level.block.ScaffoldingBlock
import net.minecraft.world.level.block.SculkBlock
import net.minecraft.world.level.block.SculkCatalystBlock
import net.minecraft.world.level.block.SculkSensorBlock
import net.minecraft.world.level.block.SculkShriekerBlock
/*
import net.minecraft.world.level.block.SculkSpreadable
*/
import net.minecraft.world.level.block.SculkVeinBlock
import net.minecraft.world.level.block.SeaPickleBlock
import net.minecraft.world.level.block.SeagrassBlock
/*
import net.minecraft.world.level.block.ShapeContext
import net.minecraft.world.level.block.ShortPlantBlock
*/
import net.minecraft.world.level.block.ShulkerBoxBlock
/*
import net.minecraft.world.level.block.SideShapeType
*/
import net.minecraft.world.level.block.SignBlock
import net.minecraft.world.level.block.SkullBlock
import net.minecraft.world.level.block.SlabBlock
import net.minecraft.world.level.block.SlimeBlock
import net.minecraft.world.level.block.SmallDripleafBlock
import net.minecraft.world.level.block.SmithingTableBlock
import net.minecraft.world.level.block.SmokerBlock
import net.minecraft.world.level.block.SnifferEggBlock
/*
import net.minecraft.world.level.block.SnowBlock
import net.minecraft.world.level.block.SnowyBlock
*/
import net.minecraft.world.level.block.SoulFireBlock
import net.minecraft.world.level.block.SoulSandBlock
import net.minecraft.world.level.block.SpawnerBlock
import net.minecraft.world.level.block.SpongeBlock
import net.minecraft.world.level.block.SporeBlossomBlock
/*
import net.minecraft.world.level.block.SpreadableBlock
import net.minecraft.world.level.block.SproutsBlock
import net.minecraft.world.level.block.Stainable
*/
import net.minecraft.world.level.block.StainedGlassBlock
import net.minecraft.world.level.block.StainedGlassPaneBlock
/*
import net.minecraft.world.level.block.StairsBlock
*/
import net.minecraft.world.level.block.StemBlock
import net.minecraft.world.level.block.StonecutterBlock
import net.minecraft.world.level.block.StructureBlock
import net.minecraft.world.level.block.StructureVoidBlock
import net.minecraft.world.level.block.SugarCaneBlock
/*
import net.minecraft.world.level.block.SuspiciousStewIngredient
*/
import net.minecraft.world.level.block.SweetBerryBushBlock
import net.minecraft.world.level.block.TallFlowerBlock
/*
import net.minecraft.world.level.block.TallPlantBlock
*/
import net.minecraft.world.level.block.TallSeagrassBlock
import net.minecraft.world.level.block.TargetBlock
import net.minecraft.world.level.block.TintedGlassBlock
import net.minecraft.world.level.block.TntBlock
import net.minecraft.world.level.block.TorchBlock
/*
import net.minecraft.world.level.block.TorchflowerBlock
import net.minecraft.world.level.block.TranslucentBlock
*/
import net.minecraft.world.level.block.TransparentBlock
/*
import net.minecraft.world.level.block.TrapdoorBlock
*/
import net.minecraft.world.level.block.TrappedChestBlock
import net.minecraft.world.level.block.TrialSpawnerBlock
/*
import net.minecraft.world.level.block.TripwireBlock
import net.minecraft.world.level.block.TripwireHookBlock
*/
import net.minecraft.world.level.block.TurtleEggBlock
import net.minecraft.world.level.block.TwistingVinesBlock
import net.minecraft.world.level.block.TwistingVinesPlantBlock
import net.minecraft.world.level.block.VaultBlock
import net.minecraft.world.level.block.VineBlock
/*
import net.minecraft.world.level.block.VineLogic
*/
import net.minecraft.world.level.block.WallBannerBlock
import net.minecraft.world.level.block.WallBlock
import net.minecraft.world.level.block.WallHangingSignBlock
/*
import net.minecraft.world.level.block.WallMountedBlock
import net.minecraft.world.level.block.WallPiglinHeadBlock
import net.minecraft.world.level.block.WallPlayerSkullBlock
import net.minecraft.world.level.block.WallRedstoneTorchBlock
*/
import net.minecraft.world.level.block.WallSignBlock
import net.minecraft.world.level.block.WallSkullBlock
import net.minecraft.world.level.block.WallTorchBlock
/*
import net.minecraft.world.level.block.WallWitherSkullBlock
import net.minecraft.world.level.block.Waterloggable
import net.minecraft.world.level.block.WearableCarvedPumpkinBlock
*/
import net.minecraft.world.level.block.WeepingVinesBlock
import net.minecraft.world.level.block.WeepingVinesPlantBlock
import net.minecraft.world.level.block.WeightedPressurePlateBlock
import net.minecraft.world.level.block.WetSpongeBlock
import net.minecraft.world.level.block.WitherRoseBlock
import net.minecraft.world.level.block.WitherSkullBlock
/*
import net.minecraft.world.level.block.WoodType
*/


typealias AbstractBannerBlock = AbstractBannerBlock
/*
typealias AbstractBlock = AbstractBlock
*/
typealias AbstractCandleBlock = AbstractCandleBlock
typealias AbstractCauldronBlock = AbstractCauldronBlock
typealias AbstractChestBlock<E> = AbstractChestBlock<E>
typealias AbstractFireBlock = BaseFireBlock
typealias AbstractFurnaceBlock = AbstractFurnaceBlock
/*
typealias AbstractPlantBlock = AbstractPlantBlock
typealias AbstractPlantPartBlock = AbstractPlantPartBlock
typealias AbstractPlantStemBlock = AbstractPlantStemBlock
typealias AbstractPressurePlateBlock = AbstractPressurePlateBlock
typealias AbstractRailBlock = AbstractRailBlock
typealias AbstractRedstoneGateBlock = AbstractRedstoneGateBlock
typealias AbstractSignBlock = AbstractSignBlock
*/
typealias AbstractSkullBlock = AbstractSkullBlock
/*
typealias AbstractTorchBlock = AbstractTorchBlock
*/
typealias AirBlock = AirBlock
typealias AmethystBlock = AmethystBlock
typealias AmethystClusterBlock = AmethystClusterBlock
typealias AnvilBlock = AnvilBlock
typealias AttachedStemBlock = AttachedStemBlock
typealias AzaleaBlock = AzaleaBlock
/*
typealias BambooBlock = BambooBlock
typealias BambooShootBlock = BambooShootBlock
*/
typealias BannerBlock = BannerBlock
typealias BarrelBlock = BarrelBlock
typealias BarrierBlock = BarrierBlock
typealias BeaconBlock = BeaconBlock
typealias BedBlock = BedBlock
typealias BeehiveBlock = BeehiveBlock
/*
typealias BeetrootsBlock = BeetrootsBlock
*/
typealias BellBlock = BellBlock
typealias BigDripleafBlock = BigDripleafBlock
typealias BigDripleafStemBlock = BigDripleafStemBlock
typealias BlastFurnaceBlock = BlastFurnaceBlock
typealias Block = Block
/*
typealias BlockEntityProvider = BlockEntityProvider
typealias BlockKeys = BlockKeys
typealias BlockRenderType = BlockRenderType
typealias BlockSetType = BlockSetType
typealias BlockState = BlockState
*/
typealias BlockTypes = BlockTypes
/*
typealias BlockWithEntity = BlockWithEntity
*/
typealias Blocks = Blocks
typealias BrewingStandBlock = BrewingStandBlock
typealias BrushableBlock = BrushableBlock
typealias BubbleColumnBlock = BubbleColumnBlock
typealias BuddingAmethystBlock = BuddingAmethystBlock
/*
typealias BulbBlock = BulbBlock
*/
typealias ButtonBlock = ButtonBlock
typealias CactusBlock = CactusBlock
typealias CakeBlock = CakeBlock
typealias CalibratedSculkSensorBlock = CalibratedSculkSensorBlock
typealias CampfireBlock = CampfireBlock
typealias CandleBlock = CandleBlock
typealias CandleCakeBlock = CandleCakeBlock
typealias CarpetBlock = CarpetBlock
/*
typealias CarrotsBlock = CarrotsBlock
*/
typealias CartographyTableBlock = CartographyTableBlock
typealias CarvedPumpkinBlock = CarvedPumpkinBlock
typealias CauldronBlock = CauldronBlock
typealias CaveVines = CaveVines
/*
typealias CaveVinesBodyBlock = CaveVinesBodyBlock
typealias CaveVinesHeadBlock = CaveVinesHeadBlock
*/
typealias ChainBlock = ChainBlock
typealias CherryLeavesBlock = CherryLeavesBlock
typealias ChestBlock = ChestBlock
/*
typealias ChiseledBookshelfBlock = ChiseledBookshelfBlock
*/
typealias ChorusFlowerBlock = ChorusFlowerBlock
typealias ChorusPlantBlock = ChorusPlantBlock
/*
typealias CobwebBlock = CobwebBlock
*/
typealias CocoaBlock = CocoaBlock
typealias ColoredFallingBlock = ColoredFallingBlock
typealias CommandBlock = CommandBlock
typealias ComparatorBlock = ComparatorBlock
typealias ComposterBlock = ComposterBlock
typealias ConcretePowderBlock = ConcretePowderBlock
typealias ConduitBlock = ConduitBlock
/*
typealias ConnectingBlock = ConnectingBlock
*/
typealias CoralBlock = CoralBlock
/*
typealias CoralBlockBlock = CoralBlockBlock
*/
typealias CoralFanBlock = CoralFanBlock
/*
typealias CoralParentBlock = CoralParentBlock
*/
typealias CoralWallFanBlock = CoralWallFanBlock
typealias CrafterBlock = CrafterBlock
typealias CraftingTableBlock = CraftingTableBlock
typealias CropBlock = CropBlock
typealias CryingObsidianBlock = CryingObsidianBlock
typealias DaylightDetectorBlock = DaylightDetectorBlock
typealias DeadBushBlock = DeadBushBlock
/*
typealias DeadCoralBlock = DeadCoralBlock
typealias DeadCoralFanBlock = DeadCoralFanBlock
typealias DeadCoralWallFanBlock = DeadCoralWallFanBlock
*/
typealias DecoratedPotBlock = DecoratedPotBlock
/*
typealias DecoratedPotPattern = DecoratedPotPattern
typealias DecoratedPotPatterns = DecoratedPotPatterns
typealias Degradable<E> = Degradable<E>
*/
typealias DetectorRailBlock = DetectorRailBlock
typealias DirtPathBlock = DirtPathBlock
typealias DispenserBlock = DispenserBlock
typealias DoorBlock = DoorBlock
/*
typealias DoubleBlockProperties = DoubleBlockProperties
*/
typealias DragonEggBlock = DragonEggBlock
typealias DropperBlock = DropperBlock
/*
typealias DyedCarpetBlock = DyedCarpetBlock
*/
typealias EnchantingTableBlock = EnchantingTableBlock
typealias EndGatewayBlock = EndGatewayBlock
typealias EndPortalBlock = EndPortalBlock
typealias EndPortalFrameBlock = EndPortalFrameBlock
typealias EndRodBlock = EndRodBlock
typealias EnderChestBlock = EnderChestBlock
/*
typealias EntityShapeContext = EntityShapeContext
typealias ExperienceDroppingBlock = ExperienceDroppingBlock
typealias FacingBlock = FacingBlock
typealias FallingBlock = FallingBlock
typealias FarmlandBlock = FarmlandBlock
*/
typealias FenceBlock = FenceBlock
typealias FenceGateBlock = FenceGateBlock
/*
typealias Fertilizable = Fertilizable
*/
typealias FireBlock = FireBlock
typealias FletchingTableBlock = FletchingTableBlock
typealias FlowerBlock = FlowerBlock
typealias FlowerPotBlock = FlowerPotBlock
/*
typealias FlowerbedBlock = FlowerbedBlock
typealias FluidBlock = FluidBlock
typealias FluidDrainable = FluidDrainable
typealias FluidFillable = FluidFillable
*/
typealias FrogspawnBlock = FrogspawnBlock
typealias FrostedIceBlock = FrostedIceBlock
typealias FungusBlock = FungusBlock
typealias FurnaceBlock = FurnaceBlock
typealias GlazedTerracottaBlock = GlazedTerracottaBlock
typealias GlowLichenBlock = GlowLichenBlock
typealias GrassBlock = GrassBlock
/*
typealias GrateBlock = GrateBlock
*/
typealias GrindstoneBlock = GrindstoneBlock
typealias HangingRootsBlock = HangingRootsBlock
/*
typealias HangingSignBlock = HangingSignBlock
*/
typealias HayBlock = HayBlock
typealias HeavyCoreBlock = HeavyCoreBlock
typealias HoneyBlock = HoneyBlock
typealias HopperBlock = HopperBlock
/*
typealias HorizontalConnectingBlock = HorizontalConnectingBlock
typealias HorizontalFacingBlock = HorizontalFacingBlock
*/
typealias IceBlock = IceBlock
typealias InfestedBlock = InfestedBlock
/*
typealias InventoryProvider = InventoryProvider
*/
typealias JigsawBlock = JigsawBlock
typealias JukeboxBlock = JukeboxBlock
typealias KelpBlock = KelpBlock
typealias KelpPlantBlock = KelpPlantBlock
typealias LadderBlock = LadderBlock
/*
typealias LandingBlock = LandingBlock
*/
typealias LanternBlock = LanternBlock
typealias LavaCauldronBlock = LavaCauldronBlock
typealias LeavesBlock = LeavesBlock
typealias LecternBlock = LecternBlock
/*
typealias LeveledCauldronBlock = LeveledCauldronBlock
*/
typealias LeverBlock = LeverBlock
/*
typealias LichenGrower = LichenGrower
*/
typealias LightBlock = LightBlock
typealias LightningRodBlock = LightningRodBlock
/*
typealias LilyPadBlock = LilyPadBlock
*/
typealias LoomBlock = LoomBlock
typealias MagmaBlock = MagmaBlock
typealias MangroveLeavesBlock = MangroveLeavesBlock
typealias MangroveRootsBlock = MangroveRootsBlock
/*
typealias MapColor = MapColor
typealias MossBlock = MossBlock
*/
typealias MudBlock = MudBlock
/*
typealias MultifaceGrowthBlock = MultifaceGrowthBlock
*/
typealias MushroomBlock = MushroomBlock
/*
typealias MushroomPlantBlock = MushroomPlantBlock
*/
typealias MyceliumBlock = MyceliumBlock
typealias NetherPortalBlock = NetherPortalBlock
typealias NetherWartBlock = NetherWartBlock
typealias NetherrackBlock = NetherrackBlock
typealias NoteBlock = NoteBlock
typealias NyliumBlock = NyliumBlock
typealias ObserverBlock = ObserverBlock
/*
typealias OperatorBlock = OperatorBlock
typealias Oxidizable = Oxidizable
typealias OxidizableBlock = OxidizableBlock
typealias OxidizableBulbBlock = OxidizableBulbBlock
typealias OxidizableDoorBlock = OxidizableDoorBlock
typealias OxidizableGrateBlock = OxidizableGrateBlock
typealias OxidizableSlabBlock = OxidizableSlabBlock
typealias OxidizableStairsBlock = OxidizableStairsBlock
typealias OxidizableTrapdoorBlock = OxidizableTrapdoorBlock
typealias PaneBlock = PaneBlock
typealias PillarBlock = PillarBlock
typealias PistonBlock = PistonBlock
typealias PistonExtensionBlock = PistonExtensionBlock
typealias PistonHeadBlock = PistonHeadBlock
*/
typealias PitcherCropBlock = PitcherCropBlock
/*
typealias PlantBlock = PlantBlock
typealias PlayerSkullBlock = PlayerSkullBlock
*/
typealias PointedDripstoneBlock = PointedDripstoneBlock
typealias Portal = Portal
/*
typealias PotatoesBlock = PotatoesBlock
*/
typealias PowderSnowBlock = PowderSnowBlock
typealias PoweredRailBlock = PoweredRailBlock
typealias PressurePlateBlock = PressurePlateBlock
/*
typealias PropaguleBlock = PropaguleBlock
*/
typealias PumpkinBlock = PumpkinBlock
typealias RailBlock = RailBlock
/*
typealias RailPlacementHelper = RailPlacementHelper
typealias RedstoneBlock = RedstoneBlock
*/
typealias RedstoneLampBlock = RedstoneLampBlock
/*
typealias RedstoneOreBlock = RedstoneOreBlock
*/
typealias RedstoneTorchBlock = RedstoneTorchBlock
/*
typealias RedstoneWireBlock = RedstoneWireBlock
*/
typealias RepeaterBlock = RepeaterBlock
typealias RespawnAnchorBlock = RespawnAnchorBlock
typealias RodBlock = RodBlock
typealias RootedDirtBlock = RootedDirtBlock
typealias RootsBlock = RootsBlock
/*
typealias RotatedInfestedBlock = RotatedInfestedBlock
*/
typealias SaplingBlock = SaplingBlock
/*
typealias SaplingGenerator = SaplingGenerator
*/
typealias ScaffoldingBlock = ScaffoldingBlock
typealias SculkBlock = SculkBlock
typealias SculkCatalystBlock = SculkCatalystBlock
typealias SculkSensorBlock = SculkSensorBlock
typealias SculkShriekerBlock = SculkShriekerBlock
/*
typealias SculkSpreadable = SculkSpreadable
*/
typealias SculkVeinBlock = SculkVeinBlock
typealias SeaPickleBlock = SeaPickleBlock
typealias SeagrassBlock = SeagrassBlock
/*
typealias ShapeContext = ShapeContext
typealias ShortPlantBlock = ShortPlantBlock
*/
typealias ShulkerBoxBlock = ShulkerBoxBlock
/*
typealias SideShapeType = SideShapeType
*/
typealias SignBlock = SignBlock
typealias SkullBlock = SkullBlock
typealias SlabBlock = SlabBlock
typealias SlimeBlock = SlimeBlock
typealias SmallDripleafBlock = SmallDripleafBlock
typealias SmithingTableBlock = SmithingTableBlock
typealias SmokerBlock = SmokerBlock
typealias SnifferEggBlock = SnifferEggBlock
/*
typealias SnowBlock = SnowBlock
typealias SnowyBlock = SnowyBlock
*/
typealias SoulFireBlock = SoulFireBlock
typealias SoulSandBlock = SoulSandBlock
typealias SpawnerBlock = SpawnerBlock
typealias SpongeBlock = SpongeBlock
typealias SporeBlossomBlock = SporeBlossomBlock
/*
typealias SpreadableBlock = SpreadableBlock
typealias SproutsBlock = SproutsBlock
typealias Stainable = Stainable
*/
typealias StainedGlassBlock = StainedGlassBlock
typealias StainedGlassPaneBlock = StainedGlassPaneBlock
/*
typealias StairsBlock = StairsBlock
*/
typealias StemBlock = StemBlock
typealias StonecutterBlock = StonecutterBlock
typealias StructureBlock = StructureBlock
typealias StructureVoidBlock = StructureVoidBlock
typealias SugarCaneBlock = SugarCaneBlock
/*
typealias SuspiciousStewIngredient = SuspiciousStewIngredient
*/
typealias SweetBerryBushBlock = SweetBerryBushBlock
typealias TallFlowerBlock = TallFlowerBlock
/*
typealias TallPlantBlock = TallPlantBlock
*/
typealias TallSeagrassBlock = TallSeagrassBlock
typealias TargetBlock = TargetBlock
typealias TintedGlassBlock = TintedGlassBlock
typealias TntBlock = TntBlock
typealias TorchBlock = TorchBlock
/*
typealias TorchflowerBlock = TorchflowerBlock
typealias TranslucentBlock = TranslucentBlock
*/
typealias TransparentBlock = TransparentBlock
/*
typealias TrapdoorBlock = TrapdoorBlock
*/
typealias TrappedChestBlock = TrappedChestBlock
typealias TrialSpawnerBlock = TrialSpawnerBlock
/*
typealias TripwireBlock = TripwireBlock
typealias TripwireHookBlock = TripwireHookBlock
*/
typealias TurtleEggBlock = TurtleEggBlock
typealias TwistingVinesBlock = TwistingVinesBlock
typealias TwistingVinesPlantBlock = TwistingVinesPlantBlock
typealias VaultBlock = VaultBlock
typealias VineBlock = VineBlock
/*
typealias VineLogic = VineLogic
*/
typealias WallBannerBlock = WallBannerBlock
typealias WallBlock = WallBlock
typealias WallHangingSignBlock = WallHangingSignBlock
/*
typealias WallMountedBlock = WallMountedBlock
typealias WallPiglinHeadBlock = WallPiglinHeadBlock
typealias WallPlayerSkullBlock = WallPlayerSkullBlock
typealias WallRedstoneTorchBlock = WallRedstoneTorchBlock
*/
typealias WallSignBlock = WallSignBlock
typealias WallSkullBlock = WallSkullBlock
typealias WallTorchBlock = WallTorchBlock
/*
typealias WallWitherSkullBlock = WallWitherSkullBlock
typealias Waterloggable = Waterloggable
typealias WearableCarvedPumpkinBlock = WearableCarvedPumpkinBlock
*/
typealias WeepingVinesBlock = WeepingVinesBlock
typealias WeepingVinesPlantBlock = WeepingVinesPlantBlock
typealias WeightedPressurePlateBlock = WeightedPressurePlateBlock
typealias WetSpongeBlock = WetSpongeBlock
typealias WitherRoseBlock = WitherRoseBlock
typealias WitherSkullBlock = WitherSkullBlock
/*
typealias WoodType = WoodType
*/
