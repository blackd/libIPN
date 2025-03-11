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

package org.anti_ad.mc.alias.village

import org.anti_ad.mc.alias.item.ItemStack

val VillagerProfession.`(professionId)`
    inline get() = this.name

val TradeOffer.`(originalFirstBuyItem)`
    get() = itemCostA

val TradeOffer.`(secondBuyItem)`
    get() =  if (itemCostB.isPresent) itemCostB.get() else null

val TradeOffer.`(sellItem)`
    get() = result

val TradeOffer.`(isDisabled)`
    get() = isOutOfStock
