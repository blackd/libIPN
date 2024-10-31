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

@file:Suppress("unused", "ObjectPropertyName", "HasPlatformType")
package org.anti_ad.mc.alias.registry

import net.minecraftforge.registries.ForgeRegistries
import org.anti_ad.mc.alias.util.Identifier

val `(REGISTRIES-BLOCK_ENTITY_TYPES-IDS)`
    get() = ForgeRegistries.BLOCK_ENTITY_TYPES.keys

val `(REGISTRIES-BLOCK-IDS)`
    get() = ForgeRegistries.BLOCKS.keys

val `(REGISTRIES-CONTAINER-IDS)`
    get() = ForgeRegistries.MENU_TYPES.keys

val `(REGISTRIES-ITEM-IDS)`
    get() = ForgeRegistries.ITEMS.keys

@Suppress("FunctionName")
fun <T> Registry<T>.`(get)`(id: Identifier) = get(id)
