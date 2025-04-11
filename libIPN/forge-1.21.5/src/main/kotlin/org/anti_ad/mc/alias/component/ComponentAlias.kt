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

package org.anti_ad.mc.alias.component

import net.minecraft.core.component.TypedDataComponent
import net.minecraft.core.component.DataComponentPatch
import net.minecraft.core.component.DataComponentHolder
import net.minecraft.core.component.DataComponentMap
import net.minecraft.core.component.PatchedDataComponentMap
import net.minecraft.core.component.DataComponentType
import net.minecraft.core.component.DataComponents
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents


typealias Component<T> = TypedDataComponent<T>
typealias ComponentChanges = DataComponentPatch
typealias ComponentHolder = DataComponentHolder
typealias ComponentMap = DataComponentMap
typealias MergedComponentMap = PatchedDataComponentMap
typealias ComponentType<T> = DataComponentType<T>
typealias DataComponentTypes = DataComponents
typealias EnchantmentEffectComponentTypes = EnchantmentEffectComponents
