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


/*
import net.minecraft.text.BlockNbtDataSource
import net.minecraft.text.CharacterVisitor
import net.minecraft.text.ClickEvent
import net.minecraft.text.Decoration
import net.minecraft.text.EntityNbtDataSource
*/
import net.minecraft.network.chat.HoverEvent
/*
import net.minecraft.text.KeybindTextContent
import net.minecraft.text.KeybindTranslations
import net.minecraft.text.MutableText
import net.minecraft.text.NbtDataSource
import net.minecraft.text.NbtTextContent
import net.minecraft.text.OrderedText
import net.minecraft.text.PlainTextContent
import net.minecraft.text.RawFilteredPair
import net.minecraft.text.ScoreTextContent
import net.minecraft.text.SelectorTextContent
import net.minecraft.text.StorageNbtDataSource
import net.minecraft.text.StringVisitable
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.TextCodecs
import net.minecraft.text.TextColor
import net.minecraft.text.TextContent
import net.minecraft.text.TextReorderingProcessor
import net.minecraft.text.TextVisitFactory
import net.minecraft.text.Texts
import net.minecraft.text.TranslatableTextContent
import net.minecraft.text.TranslationException
*/


import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.Style
import net.minecraft.network.chat.ClickEvent



/*
typealias BlockNbtDataSource = BlockNbtDataSource
typealias CharacterVisitor = CharacterVisitor
*/
typealias ClickEvent = ClickEvent
typealias ClickEventAction = ClickEvent.Action
/*
typealias Decoration = Decoration
typealias EntityNbtDataSource = EntityNbtDataSource
*/
typealias HoverEvent = HoverEvent
typealias HoverEventAction<T> = HoverEvent.Action<T>
/*
typealias KeybindTextContent = KeybindTextContent
typealias KeybindTranslations = KeybindTranslations
*/
typealias MutableText = MutableComponent
/*
typealias NbtDataSource = NbtDataSource
typealias NbtTextContent = NbtTextContent
typealias OrderedText = OrderedText
typealias PlainTextContent = PlainTextContent
typealias RawFilteredPair<T> = RawFilteredPair<T>
typealias ScoreTextContent = ScoreTextContent
typealias SelectorTextContent = SelectorTextContent
typealias StorageNbtDataSource = StorageNbtDataSource
typealias StringVisitable = StringVisitable
*/
typealias Style = Style
typealias Text = Component
typealias TextSerializer = Component.Serializer
/*
typealias TextCodecs = TextCodecs
typealias TextColor = TextColor
typealias TextContent = TextContent
typealias TextReorderingProcessor = TextReorderingProcessor
typealias TextVisitFactory = TextVisitFactory
typealias Texts = Texts
typealias TranslatableTextContent = TranslatableTextContent
typealias TranslationException = TranslationException
*/
