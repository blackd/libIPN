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

import org.anti_ad.mc.alias.util.Identifier

val `(REGISTRIES-BLOCK_ENTITY_TYPES-IDS)`
    get() = Registries.BLOCK_ENTITY_TYPE.ids

val `(REGISTRIES-BLOCK-IDS)`
    get() = Registries.BLOCK.ids

val `(REGISTRIES-CONTAINER-IDS)`
    get() = Registries.SCREEN_HANDLER.ids

val `(REGISTRIES-ITEM-IDS)`
    get() = Registries.ITEM.ids

@Suppress("FunctionName")
fun <T> Registry<T>.`(get)`(id: Identifier) = get(id)

