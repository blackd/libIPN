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

package org.anti_ad.mc.alias.text

import org.anti_ad.mc.alias.registry.DynamicRegistryManager

// this is here because the alias system can't handle
// direct usage of HoverEventAction.SHOW_TEXT in
// .withHoverEvent(HoverEvent(HoverEventAction.SHOW_TEXT


fun getTranslatable(s: String, vararg args: Any): Text = Text.translatable(s, *args)

fun getLiteral(s: String): Text = Text.literal(s)

val Text.`(formattedText)`
    get() = (this as MutableText).toString()

fun fromSerializedJson(json: String): MutableText? {
    return TextSerializer.fromJson(json, DynamicRegistryManager.EMPTY)
}
