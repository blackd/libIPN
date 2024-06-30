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


package org.anti_ad.mc.alias.registry

/*
import net.minecraft.registry.BuiltinRegistries
*/
import net.minecraft.core.LayeredRegistryAccess
import net.minecraft.core.DefaultedRegistry
import net.minecraft.core.RegistryAccess
/*
import net.minecraft.registry.ExperimentalRegistriesValidator
*/
import net.minecraft.core.WritableRegistry
/*
import net.minecraft.registry.Registerable
*/
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.Registry
import net.minecraft.core.RegistrySetBuilder
/*
import net.minecraft.registry.RegistryCloner
import net.minecraft.registry.RegistryCodecs
import net.minecraft.registry.RegistryEntryLookup
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryLoader
import net.minecraft.registry.RegistryOps
import net.minecraft.registry.RegistryPair
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.ReloadableRegistries
import net.minecraft.registry.SerializableRegistries
import net.minecraft.registry.ServerDynamicRegistryType
import net.minecraft.registry.SimpleDefaultedRegistry
import net.minecraft.registry.SimpleRegistry
import net.minecraft.registry.TradeRebalanceBuiltinRegistries
import net.minecraft.registry.VersionedIdentifier
*/


/*
typealias BuiltinRegistries = BuiltinRegistries
*/
typealias CombinedDynamicRegistries<T> = LayeredRegistryAccess<T>
typealias DefaultedRegistry<T> = DefaultedRegistry<T>
typealias DynamicRegistryManager = RegistryAccess
/*
typealias ExperimentalRegistriesValidator = ExperimentalRegistriesValidator
*/
typealias MutableRegistry<T> = WritableRegistry<T>
/*
typealias Registerable<T> = Registerable<T>
*/
typealias Registries = BuiltInRegistries
typealias Registry<T> = Registry<T>
typealias RegistryBuilder = RegistrySetBuilder
/*
typealias RegistryCloner<T> = RegistryCloner<T>
typealias RegistryCodecs = RegistryCodecs
typealias RegistryEntryLookup<T> = RegistryEntryLookup<T>
typealias RegistryKey<T> = RegistryKey<T>
typealias RegistryKeys<T> = RegistryKeys
typealias RegistryLoader = RegistryLoader
typealias RegistryOps<T> = RegistryOps<T>
typealias RegistryPair<T> = RegistryPair<T>
typealias RegistryWrapper<T> = RegistryWrapper<T>
typealias ReloadableRegistries = ReloadableRegistries
typealias SerializableRegistries = SerializableRegistries
typealias ServerDynamicRegistryType = ServerDynamicRegistryType
typealias SimpleDefaultedRegistry<T> = SimpleDefaultedRegistry<T>
typealias SimpleRegistry<T> = SimpleRegistry<T>
typealias TradeRebalanceBuiltinRegistries = TradeRebalanceBuiltinRegistries
typealias VersionedIdentifier = VersionedIdentifier
*/

