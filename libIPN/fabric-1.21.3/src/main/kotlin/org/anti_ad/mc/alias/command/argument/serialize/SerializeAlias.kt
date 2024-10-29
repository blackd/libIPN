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

package org.anti_ad.mc.alias.command.argument.serialize

import net.minecraft.command.argument.serialize.ArgumentSerializer
import net.minecraft.command.argument.serialize.ConstantArgumentSerializer
import net.minecraft.command.argument.serialize.DoubleArgumentSerializer
import net.minecraft.command.argument.serialize.FloatArgumentSerializer
import net.minecraft.command.argument.serialize.IntegerArgumentSerializer
import net.minecraft.command.argument.serialize.LongArgumentSerializer
import net.minecraft.command.argument.serialize.StringArgumentSerializer


typealias ArgumentSerializer<A, T> = ArgumentSerializer<A, T>
typealias ConstantArgumentSerializer<T> = ConstantArgumentSerializer<T>
typealias DoubleArgumentSerializer = DoubleArgumentSerializer
typealias FloatArgumentSerializer = FloatArgumentSerializer
typealias IntegerArgumentSerializer = IntegerArgumentSerializer
typealias LongArgumentSerializer = LongArgumentSerializer
typealias StringArgumentSerializer = StringArgumentSerializer
