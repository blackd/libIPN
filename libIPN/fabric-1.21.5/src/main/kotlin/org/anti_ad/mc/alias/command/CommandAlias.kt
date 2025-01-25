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

package org.anti_ad.mc.alias.command

import net.minecraft.command.BlockDataObject
import net.minecraft.command.CommandAction
import net.minecraft.command.CommandExecutionContext
import net.minecraft.command.CommandFunctionAction
import net.minecraft.command.CommandQueueEntry
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.command.CommandSource
import net.minecraft.command.ControlFlowAware
import net.minecraft.command.DataCommandObject
import net.minecraft.command.DataCommandStorage
import net.minecraft.command.EntityDataObject
import net.minecraft.command.EntitySelector
import net.minecraft.command.EntitySelectorOptions
import net.minecraft.command.EntitySelectorReader
import net.minecraft.command.ExecutionControl
import net.minecraft.command.ExecutionFlags
import net.minecraft.command.FallthroughCommandAction
import net.minecraft.command.FixedCommandAction
import net.minecraft.command.FloatRangeArgument
import net.minecraft.command.Forkable
import net.minecraft.command.Frame
import net.minecraft.command.IsolatedCommandAction
import net.minecraft.command.MacroInvocation
import net.minecraft.command.ReturnValueConsumer
import net.minecraft.command.SingleCommandAction
import net.minecraft.command.SourcedCommandAction
import net.minecraft.command.SteppedCommandAction
import net.minecraft.command.StorageDataObject
import net.minecraft.command.TranslatableBuiltInExceptions


typealias BlockDataObject = BlockDataObject
typealias CommandAction<T> = CommandAction<T>
typealias CommandExecutionContext<T> = CommandExecutionContext<T>
typealias CommandFunctionAction<T> = CommandFunctionAction<T>
typealias CommandQueueEntry<T> = CommandQueueEntry<T>
typealias CommandRegistryAccess = CommandRegistryAccess
typealias CommandSource = CommandSource
typealias ControlFlowAware<T> = ControlFlowAware<T>
typealias DataCommandObject = DataCommandObject
typealias DataCommandStorage = DataCommandStorage
typealias EntityDataObject = EntityDataObject
typealias EntitySelector = EntitySelector
typealias EntitySelectorOptions = EntitySelectorOptions
typealias EntitySelectorReader = EntitySelectorReader
typealias ExecutionControl<T> = ExecutionControl<T>
typealias ExecutionFlags = ExecutionFlags
typealias FallthroughCommandAction<T> = FallthroughCommandAction<T>
typealias FixedCommandAction<T> = FixedCommandAction<T>
typealias FloatRangeArgument = FloatRangeArgument
typealias Forkable<T> = Forkable<T>
typealias Frame = Frame
typealias IsolatedCommandAction<T> = IsolatedCommandAction<T>
typealias MacroInvocation = MacroInvocation
typealias ReturnValueConsumer = ReturnValueConsumer
typealias SingleCommandAction<T> = SingleCommandAction<T>
typealias SourcedCommandAction<T> = SourcedCommandAction<T>
typealias SteppedCommandAction<T, P> = SteppedCommandAction<T, P>
typealias StorageDataObject = StorageDataObject
typealias TranslatableBuiltInExceptions = TranslatableBuiltInExceptions
