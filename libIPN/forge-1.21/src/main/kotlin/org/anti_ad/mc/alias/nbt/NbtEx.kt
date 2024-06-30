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

package org.anti_ad.mc.alias.nbt

fun NbtHelper_toFormattedString(element: NbtElement, boolean: Boolean) = NbtHelper.prettyPrint(element, boolean)
fun NbtHelper_toFormattedString(element: NbtElement) = NbtHelper.prettyPrint(element)
fun NbtHelper_toFormattedString(sb: StringBuilder, element: NbtElement, level: Int, boolean: Boolean) = NbtHelper.prettyPrint(sb, element, level, boolean)
