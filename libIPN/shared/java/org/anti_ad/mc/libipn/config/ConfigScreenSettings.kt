/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2025 Plamen K. Kosseff <p.kosseff@gmail.com>
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

package org.anti_ad.mc.libipn.config

import org.anti_ad.mc.alias.text.getTranslatable
import org.anti_ad.mc.common.Savable
import org.anti_ad.mc.common.config.builder.ConfigDeclaration
import org.anti_ad.mc.common.config.builder.ConfigSaveLoadManager
import org.anti_ad.mc.common.config.builder.*
import org.anti_ad.mc.common.gui.screen.BaseConfigScreenSettings
import org.anti_ad.mc.libipn.gen.ModInfo


object ConfigScreenSettings: BaseConfigScreenSettings() {

    private const val CONFIG_SCREEN_LABELS_PREFIX = "libipn.common.gui.config."
    private const val CONFIG_SCREEN_OPTIONS_PREFIX = "libipn.common.config."

    const val FILE_NAME = "libipn-demo-config.json"

    private val configs: MutableList<ConfigDeclaration> = mutableListOf(Demo, Demo2, Debugs)

    override val configLabelsPrefix = CONFIG_SCREEN_LABELS_PREFIX

    override val configOptionsPrefix = CONFIG_SCREEN_OPTIONS_PREFIX

    override val configScreenTitle = getTranslatable("${CONFIG_SCREEN_LABELS_PREFIX}title",
                                                     ModInfo.MOD_VERSION)

    override val saveManager: Savable = ConfigSaveLoadManager(ModInfo.MOD_ID, FILE_NAME) {
        configs.toMultiConfig()
    }

    override val openConfigHotkey = Demo.OPEN_CONFIG_MENU

    override val configDeclarations: List<ConfigDeclaration>
        get() {
            return if (Demo.DEBUG.value) {
                configs
            } else {
                configs.filter {
                    it !== Debugs
                }
            }
        }
}
