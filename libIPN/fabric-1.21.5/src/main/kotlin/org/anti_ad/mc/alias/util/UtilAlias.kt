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

package org.anti_ad.mc.alias.util

import net.minecraft.util.ActionResult
import net.minecraft.util.ApiServices
import net.minecraft.util.Arm
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation
import net.minecraft.util.CachedMapper
import net.minecraft.util.Clearable
import net.minecraft.util.ClickType
import net.minecraft.util.ColorCode
import net.minecraft.util.Colors
import net.minecraft.util.CsvWriter
import net.minecraft.util.CubicSampler
import net.minecraft.util.CuboidBlockIterator
import net.minecraft.util.DateTimeFormatters
import net.minecraft.util.DelegatingDataOutput
import net.minecraft.util.Downloader
import net.minecraft.util.DyeColor
import net.minecraft.util.ErrorReporter
import net.minecraft.util.FixedBufferInputStream
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.InvalidHierarchicalFileException
import net.minecraft.util.InvalidIdentifierException
import net.minecraft.util.ItemScatterer
import net.minecraft.util.JsonHelper
import net.minecraft.util.Language
import net.minecraft.util.Lazy
import net.minecraft.util.LowercaseEnumTypeAdapterFactory
import net.minecraft.util.ModStatus
import net.minecraft.util.NameGenerator
import net.minecraft.util.Nameable
import net.minecraft.util.NetworkUtils
import net.minecraft.util.Nullables
import net.minecraft.util.Pair
import net.minecraft.util.PngMetadata
import net.minecraft.util.ProgressListener
import net.minecraft.util.Rarity
import net.minecraft.util.StringHelper
import net.minecraft.util.StringIdentifiable
import net.minecraft.util.SystemDetails
import net.minecraft.util.TextifiedException
import net.minecraft.util.ThrowableDeliverer
import net.minecraft.util.TickDurationMonitor
import net.minecraft.util.TimeHelper
import net.minecraft.util.TimeSupplier
import net.minecraft.util.TopologicalSorts
import net.minecraft.util.TranslatableOption
import net.minecraft.util.TypeFilter
import net.minecraft.util.Unit
import net.minecraft.util.Urls
import net.minecraft.util.UserCache
import net.minecraft.util.Util
import net.minecraft.util.Uuids
import net.minecraft.util.WinNativeModuleUtil
import net.minecraft.util.WorldSavePath
import net.minecraft.util.ZipCompressor


typealias ActionResult = ActionResult
typealias ApiServices = ApiServices
typealias Arm = Arm
typealias BlockMirror = BlockMirror
typealias BlockRotation = BlockRotation
typealias CachedMapper<K, V> = CachedMapper<K, V>
typealias Clearable = Clearable
typealias ClickType = ClickType
typealias ColorCode = ColorCode
typealias Colors = Colors
typealias CsvWriter = CsvWriter
typealias CubicSampler = CubicSampler
typealias CuboidBlockIterator = CuboidBlockIterator
typealias DateTimeFormatters = DateTimeFormatters
typealias DelegatingDataOutput = DelegatingDataOutput
typealias Downloader = Downloader
typealias DyeColor = DyeColor
typealias ErrorReporter = ErrorReporter
typealias FixedBufferInputStream = FixedBufferInputStream
typealias Formatting = Formatting
typealias Hand = Hand
typealias Identifier = Identifier
typealias InvalidHierarchicalFileException = InvalidHierarchicalFileException
typealias InvalidIdentifierException = InvalidIdentifierException
typealias ItemScatterer = ItemScatterer
typealias JsonHelper = JsonHelper
typealias Language = Language
typealias Lazy<T> = Lazy<T>
typealias LowercaseEnumTypeAdapterFactory = LowercaseEnumTypeAdapterFactory
typealias ModStatus = ModStatus
typealias NameGenerator = NameGenerator
typealias Nameable = Nameable
typealias NetworkUtils = NetworkUtils
typealias Nullables = Nullables
typealias Pair<K, V> = Pair<K, V>
typealias PngMetadata = PngMetadata
typealias ProgressListener = ProgressListener
typealias Rarity = Rarity
typealias StringHelper = StringHelper
typealias StringIdentifiable = StringIdentifiable
typealias SystemDetails = SystemDetails
typealias TextifiedException = TextifiedException
typealias ThrowableDeliverer<T> = ThrowableDeliverer<T>
typealias TickDurationMonitor = TickDurationMonitor
typealias TimeHelper = TimeHelper
typealias TimeSupplier = TimeSupplier
typealias TopologicalSorts = TopologicalSorts
typealias TranslatableOption = TranslatableOption
typealias TypeFilter<T, B> = TypeFilter<T, B>
typealias Urls = Urls
typealias UserCache = UserCache
typealias Util = Util
typealias Uuids = Uuids
typealias WinNativeModuleUtil = WinNativeModuleUtil
typealias WorldSavePath = WorldSavePath
typealias ZipCompressor = ZipCompressor
