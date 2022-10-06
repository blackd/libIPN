package org.anti_ad.mc.libipn

import org.anti_ad.mc.common.LogBase

object Log: LogBase(false) {
    override val id: String
        get() = "libIPN"

    init {
        shouldDebug = { debugSet.orElements() }
        shouldTrace = { traceSet.orElements() }
    }


}
