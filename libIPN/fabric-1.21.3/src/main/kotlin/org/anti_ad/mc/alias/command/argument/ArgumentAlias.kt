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

package org.anti_ad.mc.alias.command.argument

import net.minecraft.command.argument.AngleArgumentType
import net.minecraft.command.argument.ArgumentHelper
import net.minecraft.command.argument.ArgumentTypes
import net.minecraft.command.argument.BlockArgumentParser
import net.minecraft.command.argument.BlockMirrorArgumentType
import net.minecraft.command.argument.BlockPosArgumentType
import net.minecraft.command.argument.BlockPredicateArgumentType
import net.minecraft.command.argument.BlockRotationArgumentType
import net.minecraft.command.argument.BlockStateArgument
import net.minecraft.command.argument.BlockStateArgumentType
import net.minecraft.command.argument.ColorArgumentType
import net.minecraft.command.argument.ColumnPosArgumentType
import net.minecraft.command.argument.CommandFunctionArgumentType
import net.minecraft.command.argument.CoordinateArgument
import net.minecraft.command.argument.DefaultPosArgument
import net.minecraft.command.argument.DimensionArgumentType
import net.minecraft.command.argument.EntityAnchorArgumentType
import net.minecraft.command.argument.EntityArgumentType
import net.minecraft.command.argument.EnumArgumentType
import net.minecraft.command.argument.GameModeArgumentType
import net.minecraft.command.argument.GameProfileArgumentType
import net.minecraft.command.argument.HeightmapArgumentType
import net.minecraft.command.argument.IdentifierArgumentType
import net.minecraft.command.argument.ItemPredicateArgumentType
import net.minecraft.command.argument.ItemSlotArgumentType
import net.minecraft.command.argument.ItemStackArgument
import net.minecraft.command.argument.ItemStackArgumentType
import net.minecraft.command.argument.ItemStringReader
import net.minecraft.command.argument.LookingPosArgument
import net.minecraft.command.argument.MessageArgumentType
import net.minecraft.command.argument.NbtCompoundArgumentType
import net.minecraft.command.argument.NbtElementArgumentType
import net.minecraft.command.argument.NbtPathArgumentType
import net.minecraft.command.argument.NumberRangeArgumentType
import net.minecraft.command.argument.OperationArgumentType
import net.minecraft.command.argument.ParticleEffectArgumentType
import net.minecraft.command.argument.PosArgument
import net.minecraft.command.argument.RegistryEntryArgumentType
import net.minecraft.command.argument.RegistryEntryPredicateArgumentType
import net.minecraft.command.argument.RegistryEntryReferenceArgumentType
import net.minecraft.command.argument.RegistryKeyArgumentType
import net.minecraft.command.argument.RegistryPredicateArgumentType
import net.minecraft.command.argument.RotationArgumentType
import net.minecraft.command.argument.ScoreHolderArgumentType
import net.minecraft.command.argument.ScoreboardCriterionArgumentType
import net.minecraft.command.argument.ScoreboardObjectiveArgumentType
import net.minecraft.command.argument.ScoreboardSlotArgumentType
import net.minecraft.command.argument.SignedArgumentList
import net.minecraft.command.argument.SignedArgumentType
import net.minecraft.command.argument.SlotRangeArgumentType
import net.minecraft.command.argument.StyleArgumentType
import net.minecraft.command.argument.SwizzleArgumentType
import net.minecraft.command.argument.TeamArgumentType
import net.minecraft.command.argument.TestClassArgumentType
import net.minecraft.command.argument.TestFunctionArgumentType
import net.minecraft.command.argument.TextArgumentType
import net.minecraft.command.argument.TimeArgumentType
import net.minecraft.command.argument.UuidArgumentType
import net.minecraft.command.argument.Vec2ArgumentType
import net.minecraft.command.argument.Vec3ArgumentType


typealias AngleArgumentType = AngleArgumentType
typealias ArgumentHelper = ArgumentHelper
typealias ArgumentTypes = ArgumentTypes
typealias BlockArgumentParser = BlockArgumentParser
typealias BlockMirrorArgumentType = BlockMirrorArgumentType
typealias BlockPosArgumentType = BlockPosArgumentType
typealias BlockPredicateArgumentType = BlockPredicateArgumentType
typealias BlockRotationArgumentType = BlockRotationArgumentType
typealias BlockStateArgument = BlockStateArgument
typealias BlockStateArgumentType = BlockStateArgumentType
typealias ColorArgumentType = ColorArgumentType
typealias ColumnPosArgumentType = ColumnPosArgumentType
typealias CommandFunctionArgumentType = CommandFunctionArgumentType
typealias CoordinateArgument = CoordinateArgument
typealias DefaultPosArgument = DefaultPosArgument
typealias DimensionArgumentType = DimensionArgumentType
typealias EntityAnchorArgumentType = EntityAnchorArgumentType
typealias EntityArgumentType = EntityArgumentType
typealias EnumArgumentType<T> = EnumArgumentType<T>
typealias GameModeArgumentType = GameModeArgumentType
typealias GameProfileArgumentType = GameProfileArgumentType
typealias HeightmapArgumentType = HeightmapArgumentType
typealias IdentifierArgumentType = IdentifierArgumentType
typealias ItemPredicateArgumentType = ItemPredicateArgumentType
typealias ItemSlotArgumentType = ItemSlotArgumentType
typealias ItemStackArgument = ItemStackArgument
typealias ItemStackArgumentType = ItemStackArgumentType
typealias ItemStringReader = ItemStringReader
typealias LookingPosArgument = LookingPosArgument
typealias MessageArgumentType = MessageArgumentType
typealias NbtCompoundArgumentType = NbtCompoundArgumentType
typealias NbtElementArgumentType = NbtElementArgumentType
typealias NbtPathArgumentType = NbtPathArgumentType
typealias NbtPathArgumentTypeNbtPath = NbtPathArgumentType.NbtPath
typealias NumberRangeArgumentType<T> = NumberRangeArgumentType<T>
typealias OperationArgumentType = OperationArgumentType
typealias ParticleEffectArgumentType = ParticleEffectArgumentType
typealias PosArgument = PosArgument
typealias RegistryEntryArgumentType<T> = RegistryEntryArgumentType<T>
typealias RegistryEntryPredicateArgumentType<T> = RegistryEntryPredicateArgumentType<T>
typealias RegistryEntryReferenceArgumentType<T> = RegistryEntryReferenceArgumentType<T>
typealias RegistryKeyArgumentType<T> = RegistryKeyArgumentType<T>
typealias RegistryPredicateArgumentType<T> = RegistryPredicateArgumentType<T>
typealias RotationArgumentType = RotationArgumentType
typealias ScoreHolderArgumentType = ScoreHolderArgumentType
typealias ScoreboardCriterionArgumentType = ScoreboardCriterionArgumentType
typealias ScoreboardObjectiveArgumentType = ScoreboardObjectiveArgumentType
typealias ScoreboardSlotArgumentType = ScoreboardSlotArgumentType
typealias SignedArgumentList<T> = SignedArgumentList<T>
typealias SignedArgumentType<T> = SignedArgumentType<T>
typealias SlotRangeArgumentType = SlotRangeArgumentType
typealias StyleArgumentType = StyleArgumentType
typealias SwizzleArgumentType = SwizzleArgumentType
typealias TeamArgumentType = TeamArgumentType
typealias TestClassArgumentType = TestClassArgumentType
typealias TestFunctionArgumentType = TestFunctionArgumentType
typealias TextArgumentType = TextArgumentType
typealias TimeArgumentType = TimeArgumentType
typealias UuidArgumentType = UuidArgumentType
typealias Vec2ArgumentType = Vec2ArgumentType
typealias Vec3ArgumentType = Vec3ArgumentType
