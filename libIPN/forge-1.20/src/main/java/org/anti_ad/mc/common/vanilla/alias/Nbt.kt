package org.anti_ad.mc.common.vanilla.alias

import net.minecraft.commands.arguments.NbtPathArgument
import net.minecraft.nbt.CollectionTag
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import net.minecraft.nbt.NbtIo
import net.minecraft.nbt.NbtUtils
import net.minecraft.nbt.NumericTag
import net.minecraft.nbt.StringTag
import net.minecraft.nbt.TagParser
import net.minecraft.nbt.Tag as NbtTag

// ============
// nbt
// ============

typealias NbtCompound = CompoundTag
typealias NbtElement = NbtTag
typealias NbtList = ListTag
typealias NbtString = StringTag
typealias NbtIo = NbtIo

typealias AbstractNbtNumber = NumericTag
typealias AbstractNbtList<T> = CollectionTag<T>

typealias NbtPathArgumentType = NbtPathArgument
typealias NbtPathArgumentTypeNbtPath = NbtPathArgument.NbtPath
typealias NbtHelper = NbtUtils
typealias StringNbtReader =  TagParser// JsonToNBT.getTagFromJson = StringNbtReader.parse
