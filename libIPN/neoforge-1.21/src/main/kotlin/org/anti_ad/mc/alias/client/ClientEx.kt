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

package org.anti_ad.mc.alias.client

import net.minecraft.client.resources.language.I18n
import org.anti_ad.mc.alias.sound.SoundEvent

fun vanillaTranslate(string: String,
                     vararg objects: Any?): String = I18n.get(string, *objects)

fun PositionedSoundInstance_Master(sound: SoundEvent, pitch: Float, volume: Float) = PositionedSoundInstance.forUI(sound, pitch, volume)