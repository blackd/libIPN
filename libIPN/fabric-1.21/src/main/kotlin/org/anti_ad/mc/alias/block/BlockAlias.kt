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

import net.minecraft.block.AbstractBannerBlock
import net.minecraft.block.AbstractBlock
import net.minecraft.block.AbstractCandleBlock
import net.minecraft.block.AbstractCauldronBlock
import net.minecraft.block.AbstractChestBlock
import net.minecraft.block.AbstractFireBlock
import net.minecraft.block.AbstractFurnaceBlock
import net.minecraft.block.AbstractPlantBlock
import net.minecraft.block.AbstractPlantPartBlock
import net.minecraft.block.AbstractPlantStemBlock
import net.minecraft.block.AbstractPressurePlateBlock
import net.minecraft.block.AbstractRailBlock
import net.minecraft.block.AbstractRedstoneGateBlock
import net.minecraft.block.AbstractSignBlock
import net.minecraft.block.AbstractSkullBlock
import net.minecraft.block.AbstractTorchBlock
import net.minecraft.block.AirBlock
import net.minecraft.block.AmethystBlock
import net.minecraft.block.AmethystClusterBlock
import net.minecraft.block.AnvilBlock
import net.minecraft.block.AttachedStemBlock
import net.minecraft.block.AzaleaBlock
import net.minecraft.block.BambooBlock
import net.minecraft.block.BambooShootBlock
import net.minecraft.block.BannerBlock
import net.minecraft.block.BarrelBlock
import net.minecraft.block.BarrierBlock
import net.minecraft.block.BeaconBlock
import net.minecraft.block.BedBlock
import net.minecraft.block.BeehiveBlock
import net.minecraft.block.BeetrootsBlock
import net.minecraft.block.BellBlock
import net.minecraft.block.BigDripleafBlock
import net.minecraft.block.BigDripleafStemBlock
import net.minecraft.block.BlastFurnaceBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockKeys
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockSetType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockTypes
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.Blocks
import net.minecraft.block.BrewingStandBlock
import net.minecraft.block.BrushableBlock
import net.minecraft.block.BubbleColumnBlock
import net.minecraft.block.BuddingAmethystBlock
import net.minecraft.block.BulbBlock
import net.minecraft.block.ButtonBlock
import net.minecraft.block.CactusBlock
import net.minecraft.block.CakeBlock
import net.minecraft.block.CalibratedSculkSensorBlock
import net.minecraft.block.CampfireBlock
import net.minecraft.block.CandleBlock
import net.minecraft.block.CandleCakeBlock
import net.minecraft.block.CarpetBlock
import net.minecraft.block.CarrotsBlock
import net.minecraft.block.CartographyTableBlock
import net.minecraft.block.CarvedPumpkinBlock
import net.minecraft.block.CauldronBlock
import net.minecraft.block.CaveVines
import net.minecraft.block.CaveVinesBodyBlock
import net.minecraft.block.CaveVinesHeadBlock
import net.minecraft.block.ChainBlock
import net.minecraft.block.CherryLeavesBlock
import net.minecraft.block.ChestBlock
import net.minecraft.block.ChiseledBookshelfBlock
import net.minecraft.block.ChorusFlowerBlock
import net.minecraft.block.ChorusPlantBlock
import net.minecraft.block.CobwebBlock
import net.minecraft.block.CocoaBlock
import net.minecraft.block.ColoredFallingBlock
import net.minecraft.block.CommandBlock
import net.minecraft.block.ComparatorBlock
import net.minecraft.block.ComposterBlock
import net.minecraft.block.ConcretePowderBlock
import net.minecraft.block.ConduitBlock
import net.minecraft.block.ConnectingBlock
import net.minecraft.block.CoralBlock
import net.minecraft.block.CoralBlockBlock
import net.minecraft.block.CoralFanBlock
import net.minecraft.block.CoralParentBlock
import net.minecraft.block.CoralWallFanBlock
import net.minecraft.block.CrafterBlock
import net.minecraft.block.CraftingTableBlock
import net.minecraft.block.CropBlock
import net.minecraft.block.CryingObsidianBlock
import net.minecraft.block.DaylightDetectorBlock
import net.minecraft.block.DeadBushBlock
import net.minecraft.block.DeadCoralBlock
import net.minecraft.block.DeadCoralFanBlock
import net.minecraft.block.DeadCoralWallFanBlock
import net.minecraft.block.DecoratedPotBlock
import net.minecraft.block.DecoratedPotPattern
import net.minecraft.block.DecoratedPotPatterns
import net.minecraft.block.Degradable
import net.minecraft.block.DetectorRailBlock
import net.minecraft.block.DirtPathBlock
import net.minecraft.block.DispenserBlock
import net.minecraft.block.DoorBlock
import net.minecraft.block.DoubleBlockProperties
import net.minecraft.block.DragonEggBlock
import net.minecraft.block.DropperBlock
import net.minecraft.block.DyedCarpetBlock
import net.minecraft.block.EnchantingTableBlock
import net.minecraft.block.EndGatewayBlock
import net.minecraft.block.EndPortalBlock
import net.minecraft.block.EndPortalFrameBlock
import net.minecraft.block.EndRodBlock
import net.minecraft.block.EnderChestBlock
import net.minecraft.block.EntityShapeContext
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.block.FacingBlock
import net.minecraft.block.FallingBlock
import net.minecraft.block.FarmlandBlock
import net.minecraft.block.FenceBlock
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.Fertilizable
import net.minecraft.block.FireBlock
import net.minecraft.block.FletchingTableBlock
import net.minecraft.block.FlowerBlock
import net.minecraft.block.FlowerPotBlock
import net.minecraft.block.FlowerbedBlock
import net.minecraft.block.FluidBlock
import net.minecraft.block.FluidDrainable
import net.minecraft.block.FluidFillable
import net.minecraft.block.FrogspawnBlock
import net.minecraft.block.FrostedIceBlock
import net.minecraft.block.FungusBlock
import net.minecraft.block.FurnaceBlock
import net.minecraft.block.GlazedTerracottaBlock
import net.minecraft.block.GlowLichenBlock
import net.minecraft.block.GrassBlock
import net.minecraft.block.GrateBlock
import net.minecraft.block.GrindstoneBlock
import net.minecraft.block.HangingRootsBlock
import net.minecraft.block.HangingSignBlock
import net.minecraft.block.HayBlock
import net.minecraft.block.HeavyCoreBlock
import net.minecraft.block.HoneyBlock
import net.minecraft.block.HopperBlock
import net.minecraft.block.HorizontalConnectingBlock
import net.minecraft.block.HorizontalFacingBlock
import net.minecraft.block.IceBlock
import net.minecraft.block.InfestedBlock
import net.minecraft.block.InventoryProvider
import net.minecraft.block.JigsawBlock
import net.minecraft.block.JukeboxBlock
import net.minecraft.block.KelpBlock
import net.minecraft.block.KelpPlantBlock
import net.minecraft.block.LadderBlock
import net.minecraft.block.LandingBlock
import net.minecraft.block.LanternBlock
import net.minecraft.block.LavaCauldronBlock
import net.minecraft.block.LeavesBlock
import net.minecraft.block.LecternBlock
import net.minecraft.block.LeveledCauldronBlock
import net.minecraft.block.LeverBlock
import net.minecraft.block.LichenGrower
import net.minecraft.block.LightBlock
import net.minecraft.block.LightningRodBlock
import net.minecraft.block.LilyPadBlock
import net.minecraft.block.LoomBlock
import net.minecraft.block.MagmaBlock
import net.minecraft.block.MangroveLeavesBlock
import net.minecraft.block.MangroveRootsBlock
import net.minecraft.block.MapColor
import net.minecraft.block.MossBlock
import net.minecraft.block.MudBlock
import net.minecraft.block.MultifaceGrowthBlock
import net.minecraft.block.MushroomBlock
import net.minecraft.block.MushroomPlantBlock
import net.minecraft.block.MyceliumBlock
import net.minecraft.block.NetherPortalBlock
import net.minecraft.block.NetherWartBlock
import net.minecraft.block.NetherrackBlock
import net.minecraft.block.NoteBlock
import net.minecraft.block.NyliumBlock
import net.minecraft.block.ObserverBlock
import net.minecraft.block.OperatorBlock
import net.minecraft.block.Oxidizable
import net.minecraft.block.OxidizableBlock
import net.minecraft.block.OxidizableBulbBlock
import net.minecraft.block.OxidizableDoorBlock
import net.minecraft.block.OxidizableGrateBlock
import net.minecraft.block.OxidizableSlabBlock
import net.minecraft.block.OxidizableStairsBlock
import net.minecraft.block.OxidizableTrapdoorBlock
import net.minecraft.block.PaneBlock
import net.minecraft.block.PillarBlock
import net.minecraft.block.PistonBlock
import net.minecraft.block.PistonExtensionBlock
import net.minecraft.block.PistonHeadBlock
import net.minecraft.block.PitcherCropBlock
import net.minecraft.block.PlantBlock
import net.minecraft.block.PlayerSkullBlock
import net.minecraft.block.PointedDripstoneBlock
import net.minecraft.block.Portal
import net.minecraft.block.PotatoesBlock
import net.minecraft.block.PowderSnowBlock
import net.minecraft.block.PoweredRailBlock
import net.minecraft.block.PressurePlateBlock
import net.minecraft.block.PropaguleBlock
import net.minecraft.block.PumpkinBlock
import net.minecraft.block.RailBlock
import net.minecraft.block.RailPlacementHelper
import net.minecraft.block.RedstoneBlock
import net.minecraft.block.RedstoneLampBlock
import net.minecraft.block.RedstoneOreBlock
import net.minecraft.block.RedstoneTorchBlock
import net.minecraft.block.RedstoneWireBlock
import net.minecraft.block.RepeaterBlock
import net.minecraft.block.RespawnAnchorBlock
import net.minecraft.block.RodBlock
import net.minecraft.block.RootedDirtBlock
import net.minecraft.block.RootsBlock
import net.minecraft.block.RotatedInfestedBlock
import net.minecraft.block.SaplingBlock
import net.minecraft.block.SaplingGenerator
import net.minecraft.block.ScaffoldingBlock
import net.minecraft.block.SculkBlock
import net.minecraft.block.SculkCatalystBlock
import net.minecraft.block.SculkSensorBlock
import net.minecraft.block.SculkShriekerBlock
import net.minecraft.block.SculkSpreadable
import net.minecraft.block.SculkVeinBlock
import net.minecraft.block.SeaPickleBlock
import net.minecraft.block.SeagrassBlock
import net.minecraft.block.ShapeContext
import net.minecraft.block.ShortPlantBlock
import net.minecraft.block.ShulkerBoxBlock
import net.minecraft.block.SideShapeType
import net.minecraft.block.SignBlock
import net.minecraft.block.SkullBlock
import net.minecraft.block.SlabBlock
import net.minecraft.block.SlimeBlock
import net.minecraft.block.SmallDripleafBlock
import net.minecraft.block.SmithingTableBlock
import net.minecraft.block.SmokerBlock
import net.minecraft.block.SnifferEggBlock
import net.minecraft.block.SnowBlock
import net.minecraft.block.SnowyBlock
import net.minecraft.block.SoulFireBlock
import net.minecraft.block.SoulSandBlock
import net.minecraft.block.SpawnerBlock
import net.minecraft.block.SpongeBlock
import net.minecraft.block.SporeBlossomBlock
import net.minecraft.block.SpreadableBlock
import net.minecraft.block.SproutsBlock
import net.minecraft.block.Stainable
import net.minecraft.block.StainedGlassBlock
import net.minecraft.block.StainedGlassPaneBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.StemBlock
import net.minecraft.block.StonecutterBlock
import net.minecraft.block.StructureBlock
import net.minecraft.block.StructureVoidBlock
import net.minecraft.block.SugarCaneBlock
import net.minecraft.block.SuspiciousStewIngredient
import net.minecraft.block.SweetBerryBushBlock
import net.minecraft.block.TallFlowerBlock
import net.minecraft.block.TallPlantBlock
import net.minecraft.block.TallSeagrassBlock
import net.minecraft.block.TargetBlock
import net.minecraft.block.TintedGlassBlock
import net.minecraft.block.TntBlock
import net.minecraft.block.TorchBlock
import net.minecraft.block.TorchflowerBlock
import net.minecraft.block.TranslucentBlock
import net.minecraft.block.TransparentBlock
import net.minecraft.block.TrapdoorBlock
import net.minecraft.block.TrappedChestBlock
import net.minecraft.block.TrialSpawnerBlock
import net.minecraft.block.TripwireBlock
import net.minecraft.block.TripwireHookBlock
import net.minecraft.block.TurtleEggBlock
import net.minecraft.block.TwistingVinesBlock
import net.minecraft.block.TwistingVinesPlantBlock
import net.minecraft.block.VaultBlock
import net.minecraft.block.VineBlock
import net.minecraft.block.VineLogic
import net.minecraft.block.WallBannerBlock
import net.minecraft.block.WallBlock
import net.minecraft.block.WallHangingSignBlock
import net.minecraft.block.WallMountedBlock
import net.minecraft.block.WallPiglinHeadBlock
import net.minecraft.block.WallPlayerSkullBlock
import net.minecraft.block.WallRedstoneTorchBlock
import net.minecraft.block.WallSignBlock
import net.minecraft.block.WallSkullBlock
import net.minecraft.block.WallTorchBlock
import net.minecraft.block.WallWitherSkullBlock
import net.minecraft.block.Waterloggable
import net.minecraft.block.WearableCarvedPumpkinBlock
import net.minecraft.block.WeepingVinesBlock
import net.minecraft.block.WeepingVinesPlantBlock
import net.minecraft.block.WeightedPressurePlateBlock
import net.minecraft.block.WetSpongeBlock
import net.minecraft.block.WitherRoseBlock
import net.minecraft.block.WitherSkullBlock
import net.minecraft.block.WoodType


typealias AbstractBannerBlock = AbstractBannerBlock
typealias AbstractBlock = AbstractBlock
typealias AbstractCandleBlock = AbstractCandleBlock
typealias AbstractCauldronBlock = AbstractCauldronBlock
typealias AbstractChestBlock<E> = AbstractChestBlock<E>
typealias AbstractFireBlock = AbstractFireBlock
typealias AbstractFurnaceBlock = AbstractFurnaceBlock
typealias AbstractPlantBlock = AbstractPlantBlock
typealias AbstractPlantPartBlock = AbstractPlantPartBlock
typealias AbstractPlantStemBlock = AbstractPlantStemBlock
typealias AbstractPressurePlateBlock = AbstractPressurePlateBlock
typealias AbstractRailBlock = AbstractRailBlock
typealias AbstractRedstoneGateBlock = AbstractRedstoneGateBlock
typealias AbstractSignBlock = AbstractSignBlock
typealias AbstractSkullBlock = AbstractSkullBlock
typealias AbstractTorchBlock = AbstractTorchBlock
typealias AirBlock = AirBlock
typealias AmethystBlock = AmethystBlock
typealias AmethystClusterBlock = AmethystClusterBlock
typealias AnvilBlock = AnvilBlock
typealias AttachedStemBlock = AttachedStemBlock
typealias AzaleaBlock = AzaleaBlock
typealias BambooBlock = BambooBlock
typealias BambooShootBlock = BambooShootBlock
typealias BannerBlock = BannerBlock
typealias BarrelBlock = BarrelBlock
typealias BarrierBlock = BarrierBlock
typealias BeaconBlock = BeaconBlock
typealias BedBlock = BedBlock
typealias BeehiveBlock = BeehiveBlock
typealias BeetrootsBlock = BeetrootsBlock
typealias BellBlock = BellBlock
typealias BigDripleafBlock = BigDripleafBlock
typealias BigDripleafStemBlock = BigDripleafStemBlock
typealias BlastFurnaceBlock = BlastFurnaceBlock
typealias Block = Block
typealias BlockEntityProvider = BlockEntityProvider
typealias BlockKeys = BlockKeys
typealias BlockRenderType = BlockRenderType
typealias BlockSetType = BlockSetType
typealias BlockState = BlockState
typealias BlockTypes = BlockTypes
typealias BlockWithEntity = BlockWithEntity
typealias Blocks = Blocks
typealias BrewingStandBlock = BrewingStandBlock
typealias BrushableBlock = BrushableBlock
typealias BubbleColumnBlock = BubbleColumnBlock
typealias BuddingAmethystBlock = BuddingAmethystBlock
typealias BulbBlock = BulbBlock
typealias ButtonBlock = ButtonBlock
typealias CactusBlock = CactusBlock
typealias CakeBlock = CakeBlock
typealias CalibratedSculkSensorBlock = CalibratedSculkSensorBlock
typealias CampfireBlock = CampfireBlock
typealias CandleBlock = CandleBlock
typealias CandleCakeBlock = CandleCakeBlock
typealias CarpetBlock = CarpetBlock
typealias CarrotsBlock = CarrotsBlock
typealias CartographyTableBlock = CartographyTableBlock
typealias CarvedPumpkinBlock = CarvedPumpkinBlock
typealias CauldronBlock = CauldronBlock
typealias CaveVines = CaveVines
typealias CaveVinesBodyBlock = CaveVinesBodyBlock
typealias CaveVinesHeadBlock = CaveVinesHeadBlock
typealias ChainBlock = ChainBlock
typealias CherryLeavesBlock = CherryLeavesBlock
typealias ChestBlock = ChestBlock
typealias ChiseledBookshelfBlock = ChiseledBookshelfBlock
typealias ChorusFlowerBlock = ChorusFlowerBlock
typealias ChorusPlantBlock = ChorusPlantBlock
typealias CobwebBlock = CobwebBlock
typealias CocoaBlock = CocoaBlock
typealias ColoredFallingBlock = ColoredFallingBlock
typealias CommandBlock = CommandBlock
typealias ComparatorBlock = ComparatorBlock
typealias ComposterBlock = ComposterBlock
typealias ConcretePowderBlock = ConcretePowderBlock
typealias ConduitBlock = ConduitBlock
typealias ConnectingBlock = ConnectingBlock
typealias CoralBlock = CoralBlock
typealias CoralBlockBlock = CoralBlockBlock
typealias CoralFanBlock = CoralFanBlock
typealias CoralParentBlock = CoralParentBlock
typealias CoralWallFanBlock = CoralWallFanBlock
typealias CrafterBlock = CrafterBlock
typealias CraftingTableBlock = CraftingTableBlock
typealias CropBlock = CropBlock
typealias CryingObsidianBlock = CryingObsidianBlock
typealias DaylightDetectorBlock = DaylightDetectorBlock
typealias DeadBushBlock = DeadBushBlock
typealias DeadCoralBlock = DeadCoralBlock
typealias DeadCoralFanBlock = DeadCoralFanBlock
typealias DeadCoralWallFanBlock = DeadCoralWallFanBlock
typealias DecoratedPotBlock = DecoratedPotBlock
typealias DecoratedPotPattern = DecoratedPotPattern
typealias DecoratedPotPatterns = DecoratedPotPatterns
typealias Degradable<E> = Degradable<E>
typealias DetectorRailBlock = DetectorRailBlock
typealias DirtPathBlock = DirtPathBlock
typealias DispenserBlock = DispenserBlock
typealias DoorBlock = DoorBlock
typealias DoubleBlockProperties = DoubleBlockProperties
typealias DragonEggBlock = DragonEggBlock
typealias DropperBlock = DropperBlock
typealias DyedCarpetBlock = DyedCarpetBlock
typealias EnchantingTableBlock = EnchantingTableBlock
typealias EndGatewayBlock = EndGatewayBlock
typealias EndPortalBlock = EndPortalBlock
typealias EndPortalFrameBlock = EndPortalFrameBlock
typealias EndRodBlock = EndRodBlock
typealias EnderChestBlock = EnderChestBlock
typealias EntityShapeContext = EntityShapeContext
typealias ExperienceDroppingBlock = ExperienceDroppingBlock
typealias FacingBlock = FacingBlock
typealias FallingBlock = FallingBlock
typealias FarmlandBlock = FarmlandBlock
typealias FenceBlock = FenceBlock
typealias FenceGateBlock = FenceGateBlock
typealias Fertilizable = Fertilizable
typealias FireBlock = FireBlock
typealias FletchingTableBlock = FletchingTableBlock
typealias FlowerBlock = FlowerBlock
typealias FlowerPotBlock = FlowerPotBlock
typealias FlowerbedBlock = FlowerbedBlock
typealias FluidBlock = FluidBlock
typealias FluidDrainable = FluidDrainable
typealias FluidFillable = FluidFillable
typealias FrogspawnBlock = FrogspawnBlock
typealias FrostedIceBlock = FrostedIceBlock
typealias FungusBlock = FungusBlock
typealias FurnaceBlock = FurnaceBlock
typealias GlazedTerracottaBlock = GlazedTerracottaBlock
typealias GlowLichenBlock = GlowLichenBlock
typealias GrassBlock = GrassBlock
typealias GrateBlock = GrateBlock
typealias GrindstoneBlock = GrindstoneBlock
typealias HangingRootsBlock = HangingRootsBlock
typealias HangingSignBlock = HangingSignBlock
typealias HayBlock = HayBlock
typealias HeavyCoreBlock = HeavyCoreBlock
typealias HoneyBlock = HoneyBlock
typealias HopperBlock = HopperBlock
typealias HorizontalConnectingBlock = HorizontalConnectingBlock
typealias HorizontalFacingBlock = HorizontalFacingBlock
typealias IceBlock = IceBlock
typealias InfestedBlock = InfestedBlock
typealias InventoryProvider = InventoryProvider
typealias JigsawBlock = JigsawBlock
typealias JukeboxBlock = JukeboxBlock
typealias KelpBlock = KelpBlock
typealias KelpPlantBlock = KelpPlantBlock
typealias LadderBlock = LadderBlock
typealias LandingBlock = LandingBlock
typealias LanternBlock = LanternBlock
typealias LavaCauldronBlock = LavaCauldronBlock
typealias LeavesBlock = LeavesBlock
typealias LecternBlock = LecternBlock
typealias LeveledCauldronBlock = LeveledCauldronBlock
typealias LeverBlock = LeverBlock
typealias LichenGrower = LichenGrower
typealias LightBlock = LightBlock
typealias LightningRodBlock = LightningRodBlock
typealias LilyPadBlock = LilyPadBlock
typealias LoomBlock = LoomBlock
typealias MagmaBlock = MagmaBlock
typealias MangroveLeavesBlock = MangroveLeavesBlock
typealias MangroveRootsBlock = MangroveRootsBlock
typealias MapColor = MapColor
typealias MossBlock = MossBlock
typealias MudBlock = MudBlock
typealias MultifaceGrowthBlock = MultifaceGrowthBlock
typealias MushroomBlock = MushroomBlock
typealias MushroomPlantBlock = MushroomPlantBlock
typealias MyceliumBlock = MyceliumBlock
typealias NetherPortalBlock = NetherPortalBlock
typealias NetherWartBlock = NetherWartBlock
typealias NetherrackBlock = NetherrackBlock
typealias NoteBlock = NoteBlock
typealias NyliumBlock = NyliumBlock
typealias ObserverBlock = ObserverBlock
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
typealias PitcherCropBlock = PitcherCropBlock
typealias PlantBlock = PlantBlock
typealias PlayerSkullBlock = PlayerSkullBlock
typealias PointedDripstoneBlock = PointedDripstoneBlock
typealias Portal = Portal
typealias PotatoesBlock = PotatoesBlock
typealias PowderSnowBlock = PowderSnowBlock
typealias PoweredRailBlock = PoweredRailBlock
typealias PressurePlateBlock = PressurePlateBlock
typealias PropaguleBlock = PropaguleBlock
typealias PumpkinBlock = PumpkinBlock
typealias RailBlock = RailBlock
typealias RailPlacementHelper = RailPlacementHelper
typealias RedstoneBlock = RedstoneBlock
typealias RedstoneLampBlock = RedstoneLampBlock
typealias RedstoneOreBlock = RedstoneOreBlock
typealias RedstoneTorchBlock = RedstoneTorchBlock
typealias RedstoneWireBlock = RedstoneWireBlock
typealias RepeaterBlock = RepeaterBlock
typealias RespawnAnchorBlock = RespawnAnchorBlock
typealias RodBlock = RodBlock
typealias RootedDirtBlock = RootedDirtBlock
typealias RootsBlock = RootsBlock
typealias RotatedInfestedBlock = RotatedInfestedBlock
typealias SaplingBlock = SaplingBlock
typealias SaplingGenerator = SaplingGenerator
typealias ScaffoldingBlock = ScaffoldingBlock
typealias SculkBlock = SculkBlock
typealias SculkCatalystBlock = SculkCatalystBlock
typealias SculkSensorBlock = SculkSensorBlock
typealias SculkShriekerBlock = SculkShriekerBlock
typealias SculkSpreadable = SculkSpreadable
typealias SculkVeinBlock = SculkVeinBlock
typealias SeaPickleBlock = SeaPickleBlock
typealias SeagrassBlock = SeagrassBlock
typealias ShapeContext = ShapeContext
typealias ShortPlantBlock = ShortPlantBlock
typealias ShulkerBoxBlock = ShulkerBoxBlock
typealias SideShapeType = SideShapeType
typealias SignBlock = SignBlock
typealias SkullBlock = SkullBlock
typealias SlabBlock = SlabBlock
typealias SlimeBlock = SlimeBlock
typealias SmallDripleafBlock = SmallDripleafBlock
typealias SmithingTableBlock = SmithingTableBlock
typealias SmokerBlock = SmokerBlock
typealias SnifferEggBlock = SnifferEggBlock
typealias SnowBlock = SnowBlock
typealias SnowyBlock = SnowyBlock
typealias SoulFireBlock = SoulFireBlock
typealias SoulSandBlock = SoulSandBlock
typealias SpawnerBlock = SpawnerBlock
typealias SpongeBlock = SpongeBlock
typealias SporeBlossomBlock = SporeBlossomBlock
typealias SpreadableBlock = SpreadableBlock
typealias SproutsBlock = SproutsBlock
typealias Stainable = Stainable
typealias StainedGlassBlock = StainedGlassBlock
typealias StainedGlassPaneBlock = StainedGlassPaneBlock
typealias StairsBlock = StairsBlock
typealias StemBlock = StemBlock
typealias StonecutterBlock = StonecutterBlock
typealias StructureBlock = StructureBlock
typealias StructureVoidBlock = StructureVoidBlock
typealias SugarCaneBlock = SugarCaneBlock
typealias SuspiciousStewIngredient = SuspiciousStewIngredient
typealias SweetBerryBushBlock = SweetBerryBushBlock
typealias TallFlowerBlock = TallFlowerBlock
typealias TallPlantBlock = TallPlantBlock
typealias TallSeagrassBlock = TallSeagrassBlock
typealias TargetBlock = TargetBlock
typealias TintedGlassBlock = TintedGlassBlock
typealias TntBlock = TntBlock
typealias TorchBlock = TorchBlock
typealias TorchflowerBlock = TorchflowerBlock
typealias TranslucentBlock = TranslucentBlock
typealias TransparentBlock = TransparentBlock
typealias TrapdoorBlock = TrapdoorBlock
typealias TrappedChestBlock = TrappedChestBlock
typealias TrialSpawnerBlock = TrialSpawnerBlock
typealias TripwireBlock = TripwireBlock
typealias TripwireHookBlock = TripwireHookBlock
typealias TurtleEggBlock = TurtleEggBlock
typealias TwistingVinesBlock = TwistingVinesBlock
typealias TwistingVinesPlantBlock = TwistingVinesPlantBlock
typealias VaultBlock = VaultBlock
typealias VineBlock = VineBlock
typealias VineLogic = VineLogic
typealias WallBannerBlock = WallBannerBlock
typealias WallBlock = WallBlock
typealias WallHangingSignBlock = WallHangingSignBlock
typealias WallMountedBlock = WallMountedBlock
typealias WallPiglinHeadBlock = WallPiglinHeadBlock
typealias WallPlayerSkullBlock = WallPlayerSkullBlock
typealias WallRedstoneTorchBlock = WallRedstoneTorchBlock
typealias WallSignBlock = WallSignBlock
typealias WallSkullBlock = WallSkullBlock
typealias WallTorchBlock = WallTorchBlock
typealias WallWitherSkullBlock = WallWitherSkullBlock
typealias Waterloggable = Waterloggable
typealias WearableCarvedPumpkinBlock = WearableCarvedPumpkinBlock
typealias WeepingVinesBlock = WeepingVinesBlock
typealias WeepingVinesPlantBlock = WeepingVinesPlantBlock
typealias WeightedPressurePlateBlock = WeightedPressurePlateBlock
typealias WetSpongeBlock = WetSpongeBlock
typealias WitherRoseBlock = WitherRoseBlock
typealias WitherSkullBlock = WitherSkullBlock
typealias WoodType = WoodType
