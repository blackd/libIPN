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

package org.anti_ad.mc.alias.nbt

import net.minecraft.nbt.AbstractNbtList
import net.minecraft.nbt.AbstractNbtNumber
import net.minecraft.nbt.InvalidNbtException
import net.minecraft.nbt.NbtByte
import net.minecraft.nbt.NbtByteArray
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtCrashException
import net.minecraft.nbt.NbtDouble
import net.minecraft.nbt.NbtElement
import net.minecraft.nbt.NbtEnd
import net.minecraft.nbt.NbtException
import net.minecraft.nbt.NbtFloat
import net.minecraft.nbt.NbtHelper
import net.minecraft.nbt.NbtInt
import net.minecraft.nbt.NbtIntArray
import net.minecraft.nbt.NbtIo
import net.minecraft.nbt.NbtList
import net.minecraft.nbt.NbtLong
import net.minecraft.nbt.NbtLongArray
import net.minecraft.nbt.NbtOps
import net.minecraft.nbt.NbtShort
import net.minecraft.nbt.NbtSizeTracker
import net.minecraft.nbt.NbtSizeValidationException
import net.minecraft.nbt.NbtString
import net.minecraft.nbt.NbtType
import net.minecraft.nbt.NbtTypes
import net.minecraft.nbt.StringNbtReader


typealias AbstractNbtList<T> = AbstractNbtList<T>
typealias AbstractNbtNumber = AbstractNbtNumber
typealias InvalidNbtException = InvalidNbtException
typealias NbtByte = NbtByte
typealias NbtByteArray = NbtByteArray
typealias NbtCompound = NbtCompound
typealias NbtCrashException = NbtCrashException
typealias NbtDouble = NbtDouble
typealias NbtElement = NbtElement
typealias NbtEnd = NbtEnd
typealias NbtException = NbtException
typealias NbtFloat = NbtFloat
typealias NbtHelper = NbtHelper
typealias NbtInt = NbtInt
typealias NbtIntArray = NbtIntArray
typealias NbtIo = NbtIo
typealias NbtList = NbtList
typealias NbtLong = NbtLong
typealias NbtLongArray = NbtLongArray
typealias NbtOps = NbtOps
typealias NbtShort = NbtShort
typealias NbtSizeTracker = NbtSizeTracker
typealias NbtSizeValidationException = NbtSizeValidationException
typealias NbtString = NbtString
typealias NbtType<T> = NbtType<T>
typealias NbtTypes = NbtTypes
typealias StringNbtReader = StringNbtReader
