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

package org.anti_ad.mc.libipn

import org.anti_ad.mc.common.LogBase
import org.anti_ad.mc.libipn.config.Debugs
import org.anti_ad.mc.libipn.config.Demo

object Log: LogBase(::falseByDefault, ::falseByDefault) {

    init {
        this.shouldDebug = { Demo.DEBUG.value || debugSet.orElements() }
        this.shouldTrace = { Demo.DEBUG.value && Debugs.TRACE_LOGS.value || traceSet.orElements() }
    }
    override val id = "libIPN"

}
