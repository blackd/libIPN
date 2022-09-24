package org.anti_ad.mc.libipn.forge

object ForgePostponedInitManager {

    private val actions: MutableSet<() -> Unit> = mutableSetOf()

    fun register(action: () -> Unit) {
        actions.add(action)
    }

    fun onStartTick() {
        actions.forEach {
            it()
        }
    }
}
