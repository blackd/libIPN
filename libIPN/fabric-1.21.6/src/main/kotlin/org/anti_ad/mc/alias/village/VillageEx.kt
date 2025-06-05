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

@file:Suppress("ObjectPropertyName", "unused", "HasPlatformType")

package org.anti_ad.mc.alias.village

import org.anti_ad.mc.alias.registry.RegistryKey
import org.anti_ad.mc.alias.registry.entry.RegistryEntry

val RegistryKey<VillagerProfession>.`(professionId)`
    inline get() = this.value.path

val RegistryEntry<VillagerProfession>.`(professionId)`: String
    inline get() = this.key.get().value.path


val TradeOffer.`(originalFirstBuyItem)`
    get() = firstBuyItem

val TradeOffer.`(secondBuyItem)`
    get() = if (secondBuyItem.isPresent) secondBuyItem.get() else null

val TradeOffer.`(sellItem)`
    get() = sellItem

val TradeOffer.`(isDisabled)`
    get() = isDisabled

val VillagerProfession.`(id)`
    get() = id
