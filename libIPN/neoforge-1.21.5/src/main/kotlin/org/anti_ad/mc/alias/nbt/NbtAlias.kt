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

import net.minecraft.nbt.CollectionTag
import net.minecraft.nbt.NumericTag
import net.minecraft.nbt.NbtFormatException
import net.minecraft.nbt.ByteTag
import net.minecraft.nbt.ByteArrayTag
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ReportedNbtException
import net.minecraft.nbt.DoubleTag
import net.minecraft.nbt.Tag
import net.minecraft.nbt.EndTag
import net.minecraft.nbt.NbtException
import net.minecraft.nbt.FloatTag
import net.minecraft.nbt.NbtUtils
import net.minecraft.nbt.IntTag
import net.minecraft.nbt.IntArrayTag
import net.minecraft.nbt.NbtIo
import net.minecraft.nbt.ListTag
import net.minecraft.nbt.LongTag
import net.minecraft.nbt.LongArrayTag
import net.minecraft.nbt.NbtOps
import net.minecraft.nbt.ShortTag
import net.minecraft.nbt.NbtAccounter
import net.minecraft.nbt.NbtAccounterException
import net.minecraft.nbt.StringTag
import net.minecraft.nbt.TagType
import net.minecraft.nbt.TagTypes
import net.minecraft.nbt.TagParser

typealias AbstractNbtList = CollectionTag
typealias AbstractNbtNumber = NumericTag
typealias InvalidNbtException = NbtFormatException
typealias NbtByte = ByteTag
typealias NbtByteArray = ByteArrayTag
typealias NbtCompound = CompoundTag
typealias NbtCrashException = ReportedNbtException
typealias NbtDouble = DoubleTag
typealias NbtElement = Tag
typealias NbtEnd = EndTag
typealias NbtException = NbtException
typealias NbtFloat = FloatTag
typealias NbtHelper = NbtUtils
typealias NbtInt = IntTag
typealias NbtIntArray = IntArrayTag
typealias NbtIo = NbtIo
typealias NbtList = ListTag
typealias NbtLong = LongTag
typealias NbtLongArray = LongArrayTag
typealias NbtOps = NbtOps
typealias NbtShort = ShortTag
typealias NbtSizeTracker = NbtAccounter
typealias NbtSizeValidationException = NbtAccounterException
typealias NbtString = StringTag
typealias NbtType<T> = TagType<T>
typealias NbtTypes = TagTypes
typealias StringNbtReader<T> = TagParser<T>
