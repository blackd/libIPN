package org.anti_ad.mc.common.vanilla.alias

import net.minecraft.nbt.CollectionNBT
import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.CompressedStreamTools
import net.minecraft.nbt.JsonToNBT
import net.minecraft.nbt.ListNBT
import net.minecraft.nbt.NBTUtil
import net.minecraft.nbt.NumberNBT
import net.minecraft.nbt.StringNBT
import net.minecraft.nbt.INBT as NbtTag
import net.minecraft.command.arguments.NBTPathArgument

import net.minecraft.tags.ITagCollection
import net.minecraft.tags.ItemTags

import net.minecraft.tags.ITag as TagTag

// ============
// nbt
// ============

typealias NbtCompound = CompoundNBT
typealias NbtElement = NbtTag
typealias NbtList = ListNBT
typealias NbtString = StringNBT
typealias NbtIo = CompressedStreamTools

typealias AbstractNbtNumber = NumberNBT
typealias AbstractNbtList<T> = CollectionNBT<T>

typealias NbtPathArgumentType = NBTPathArgument
typealias NbtPathArgumentTypeNbtPath = NBTPathArgument.NBTPath
typealias NbtHelper = NBTUtil
typealias StringNbtReader = JsonToNBT // JsonToNBT.getTagFromJson = StringNbtReader.parse


typealias ItemTags = ItemTags
typealias TagTag<T> = TagTag<T>
typealias TagGroup<T> = ITagCollection<T>
