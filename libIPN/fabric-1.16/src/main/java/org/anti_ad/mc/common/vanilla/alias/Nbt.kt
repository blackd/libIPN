package org.anti_ad.mc.common.vanilla.alias

import net.minecraft.command.argument.NbtPathArgumentType
import net.minecraft.nbt.AbstractListTag
import net.minecraft.nbt.AbstractNumberTag
import net.minecraft.nbt.ByteArrayTag
import net.minecraft.nbt.ByteTag
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.DoubleTag
import net.minecraft.nbt.EndTag
import net.minecraft.nbt.FloatTag
import net.minecraft.nbt.IntArrayTag
import net.minecraft.nbt.IntTag
import net.minecraft.nbt.ListTag
import net.minecraft.nbt.LongArrayTag
import net.minecraft.nbt.LongTag
import net.minecraft.nbt.NbtHelper
import net.minecraft.nbt.NbtIo
import net.minecraft.nbt.NbtOps
import net.minecraft.nbt.PositionTracker
import net.minecraft.nbt.ShortTag
import net.minecraft.nbt.StringNbtReader
import net.minecraft.nbt.StringTag
import net.minecraft.nbt.TagReader
import net.minecraft.nbt.TagReaders

import net.minecraft.nbt.Tag

// ============
// nbt
// ============

typealias NbtCompound = CompoundTag
typealias NbtElement = Tag
typealias NbtList = ListTag
typealias NbtString = StringTag
typealias NbtIo = NbtIo
typealias NbtAbstractList<T> = AbstractListTag<T>
typealias NbtAbstractNumber = AbstractNumberTag
typealias NbtByteArray = ByteArrayTag
typealias NbtByte = ByteTag
typealias NbtDouble = DoubleTag
typealias NbtEnd = EndTag
typealias NbtFloat = FloatTag
typealias NbtIntArray = IntArrayTag
typealias NbtInt = IntTag
typealias NbtLongArray = LongArrayTag
typealias NbtLong = LongTag
typealias NbtOps = NbtOps
typealias NbtTagSizeTracker = PositionTracker
typealias NbtShort = ShortTag
typealias NbtType<T> = TagReader<T>
typealias NbtTypes = TagReaders
typealias AbstractNbtNumber = AbstractNumberTag
typealias AbstractNbtList<T> = AbstractListTag<T>
typealias StringNbtReader = StringNbtReader

typealias NbtPathArgumentType = NbtPathArgumentType
typealias NbtPathArgumentTypeNbtPath = NbtPathArgumentType.NbtPath
typealias NbtHelper = NbtHelper
