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

import net.minecraft.commands.arguments.AngleArgument
/*
import net.minecraft.commands.arguments.ArgumentHelper
import net.minecraft.commands.arguments.Arguments
import net.minecraft.commands.arguments.BlockArgumentParser
import net.minecraft.commands.arguments.BlockMirrorArgument
import net.minecraft.commands.arguments.BlockPosArgument
import net.minecraft.commands.arguments.BlockPredicateArgument
import net.minecraft.commands.arguments.BlockRotationArgument
import net.minecraft.commands.arguments.BlockStateArgument
import net.minecraft.commands.arguments.BlockStateArgument
*/
import net.minecraft.commands.arguments.ColorArgument
/*
import net.minecraft.commands.arguments.ColumnPosArgument
import net.minecraft.commands.arguments.CommandFunctionArgument
import net.minecraft.commands.arguments.CoordinateArgument
import net.minecraft.commands.arguments.DefaultPosArgument
*/
import net.minecraft.commands.arguments.DimensionArgument
import net.minecraft.commands.arguments.EntityAnchorArgument
import net.minecraft.commands.arguments.EntityArgument
/*
import net.minecraft.commands.arguments.EnumArgument
*/
import net.minecraft.commands.arguments.GameModeArgument
import net.minecraft.commands.arguments.GameProfileArgument
/*
import net.minecraft.commands.arguments.HeightmapArgument
import net.minecraft.commands.arguments.IdentifierArgument
import net.minecraft.commands.arguments.ItemPredicateArgument
import net.minecraft.commands.arguments.ItemSlotArgument
import net.minecraft.commands.arguments.ItemStackArgument
import net.minecraft.commands.arguments.ItemStackArgument
import net.minecraft.commands.arguments.ItemStringReader
import net.minecraft.commands.arguments.LookingPosArgument
*/
import net.minecraft.commands.arguments.MessageArgument
/*
import net.minecraft.commands.arguments.NbtCompoundArgument
import net.minecraft.commands.arguments.NbtElementArgument
*/
import net.minecraft.commands.arguments.NbtPathArgument
/*
import net.minecraft.commands.arguments.NumberRangeArgument
*/
import net.minecraft.commands.arguments.OperationArgument
/*
import net.minecraft.commands.arguments.ParticleEffectArgument
import net.minecraft.commands.arguments.PosArgument
import net.minecraft.commands.arguments.RegistryEntryArgument
import net.minecraft.commands.arguments.RegistryEntryPredicateArgument
import net.minecraft.commands.arguments.RegistryEntryReferenceArgument
import net.minecraft.commands.arguments.RegistryKeyArgument
import net.minecraft.commands.arguments.RegistryPredicateArgument
import net.minecraft.commands.arguments.RotationArgument
*/
import net.minecraft.commands.arguments.ScoreHolderArgument
/*
import net.minecraft.commands.arguments.ScoreboardCriterionArgument
import net.minecraft.commands.arguments.ScoreboardObjectiveArgument
*/
import net.minecraft.commands.arguments.ScoreboardSlotArgument
/*
import net.minecraft.commands.arguments.SignedArgumentList
*/
import net.minecraft.commands.arguments.SignedArgument
/*
import net.minecraft.commands.arguments.SlotRangeArgument
*/
import net.minecraft.commands.arguments.StyleArgument
import net.minecraft.commands.arguments.coordinates.SwizzleArgument
import net.minecraft.commands.arguments.TeamArgument
/*
import net.minecraft.commands.arguments.TestClassArgument
import net.minecraft.commands.arguments.TestFunctionArgument
import net.minecraft.commands.arguments.TextArgument
*/
import net.minecraft.commands.arguments.TimeArgument
import net.minecraft.commands.arguments.UuidArgument
import net.minecraft.commands.arguments.coordinates.Vec2Argument
import net.minecraft.commands.arguments.coordinates.Vec3Argument


typealias AngleArgumentType = AngleArgument
/*
typealias ArgumentHelper = ArgumentHelper
typealias ArgumentTypes = Arguments
typealias BlockArgumentParser = BlockArgumentParser
typealias BlockMirrorArgumentType = BlockMirrorArgument
typealias BlockPosArgumentType = BlockPosArgument
typealias BlockPredicateArgumentType = BlockPredicateArgument
typealias BlockRotationArgumentType = BlockRotationArgument
typealias BlockStateArgument = BlockStateArgument
typealias BlockStateArgumentType = BlockStateArgument
*/
typealias ColorArgumentType = ColorArgument
/*
typealias ColumnPosArgumentType = ColumnPosArgument
typealias CommandFunctionArgumentType = CommandFunctionArgument
typealias CoordinateArgument = CoordinateArgument
typealias DefaultPosArgument = DefaultPosArgument
*/
typealias DimensionArgumentType = DimensionArgument
typealias EntityAnchorArgumentType = EntityAnchorArgument
typealias EntityArgumentType = EntityArgument
/*
typealias EnumArgumentType<T> = EnumArgument<T>
*/
typealias GameModeArgumentType = GameModeArgument
typealias GameProfileArgumentType = GameProfileArgument
/*
typealias HeightmapArgumentType = HeightmapArgument
typealias IdentifierArgumentType = IdentifierArgument
typealias ItemPredicateArgumentType = ItemPredicateArgument
typealias ItemSlotArgumentType = ItemSlotArgument
typealias ItemStackArgument = ItemStackArgument
typealias ItemStackArgumentType = ItemStackArgument
typealias ItemStringReader = ItemStringReader
typealias LookingPosArgument = LookingPosArgument
*/
typealias MessageArgumentType = MessageArgument
/*
typealias NbtCompoundArgumentType = NbtCompoundArgument
typealias NbtElementArgumentType = NbtElementArgument
*/
typealias NbtPathArgumentType = NbtPathArgument
typealias NbtPathArgumentTypeNbtPath = NbtPathArgument.NbtPath
/*
typealias NumberRangeArgumentType<T> = NumberRangeArgument<T>
*/
typealias OperationArgumentType = OperationArgument
/*
typealias ParticleEffectArgumentType = ParticleEffectArgument
typealias PosArgument = PosArgument
typealias RegistryEntryArgumentType<T> = RegistryEntryArgument<T>
typealias RegistryEntryPredicateArgumentType<T> = RegistryEntryPredicateArgument<T>
typealias RegistryEntryReferenceArgumentType<T> = RegistryEntryReferenceArgument<T>
typealias RegistryKeyArgumentType<T> = RegistryKeyArgument<T>
typealias RegistryPredicateArgumentType<T> = RegistryPredicateArgument<T>
typealias RotationArgumentType = RotationArgument
*/
typealias ScoreHolderArgumentType = ScoreHolderArgument
/*
typealias ScoreboardCriterionArgumentType = ScoreboardCriterionArgument
typealias ScoreboardObjectiveArgumentType = ScoreboardObjectiveArgument
*/
typealias ScoreboardSlotArgumentType = ScoreboardSlotArgument
/*
typealias SignedArgumentList<T> = SignedArgumentList<T>
*/
typealias SignedArgumentType<T> = SignedArgument<T>
/*
typealias SlotRangeArgumentType = SlotRangeArgument
*/
typealias StyleArgumentType = StyleArgument
typealias SwizzleArgumentType = SwizzleArgument
typealias TeamArgumentType = TeamArgument
/*
typealias TestClassArgumentType = TestClassArgument
typealias TestFunctionArgumentType = TestFunctionArgument
typealias TextArgumentType = TextArgument
*/
typealias TimeArgumentType = TimeArgument
typealias UuidArgumentType = UuidArgument
typealias Vec2ArgumentType = Vec2Argument
typealias Vec3ArgumentType = Vec3Argument
