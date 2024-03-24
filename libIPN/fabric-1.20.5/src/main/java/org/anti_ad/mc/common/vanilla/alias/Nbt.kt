package org.anti_ad.mc.common.vanilla.alias

import net.minecraft.nbt.AbstractNbtList
import net.minecraft.nbt.AbstractNbtNumber
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.nbt.NbtHelper
import net.minecraft.nbt.NbtIo
import net.minecraft.nbt.NbtList
import net.minecraft.nbt.NbtString
import net.minecraft.nbt.StringNbtReader
import net.minecraft.command.argument.NbtPathArgumentType

// ============
// nbt
// ============

typealias NbtCompound = NbtCompound
typealias NbtElement = NbtElement
typealias NbtList = NbtList
typealias NbtString = NbtString
typealias NbtIo = NbtIo

typealias AbstractNbtNumber = AbstractNbtNumber
typealias AbstractNbtList<T> = AbstractNbtList<T>

typealias NbtPathArgumentType = NbtPathArgumentType
typealias NbtPathArgumentTypeNbtPath = NbtPathArgumentType.NbtPath
typealias NbtHelper = NbtHelper
typealias StringNbtReader = StringNbtReader // JsonToNBT.getTagFromJson = StringNbtReader.parse
