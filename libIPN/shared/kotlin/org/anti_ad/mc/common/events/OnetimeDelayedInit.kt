package org.anti_ad.mc.common.events

import org.anti_ad.mc.common.events.TicksDispatcher.ActionType.POST
import org.anti_ad.mc.common.events.TicksDispatcher.ActionType.PRE

object OnetimeDelayedInit {

    private var doTrigger: Boolean = true
    private var doTriggerPost: Boolean = true

    private val actions = mutableListOf<Pair<Int, () -> Unit>>()
    private val postActions = mutableListOf<Pair<Int, () -> Unit>>()

    fun init() {
        TicksDispatcher.register(PRE, this::onTickPre)
        TicksDispatcher.register(POST, this::onTickPost)
    }

    fun register(priority: Int, action: () -> Unit) {
        if (doTrigger) {
            actions.add(Pair(priority, action))
        }
    }

    fun registerPost(priority: Int, action: () -> Unit) {
        if (doTriggerPost) {
            postActions.add(Pair(priority, action))
        }
    }

    private fun onTickPre() {
        if (doTrigger) {
            TicksDispatcher.removePre(this::onTickPre)
            doTrigger = false
            actions.sortBy {  ( priority, _) ->
                priority
            }
            actions.forEach { (_, action) ->
                action()
            }
            actions.clear()
        }
    }

    private fun onTickPost() {
        if (doTriggerPost) {
            TicksDispatcher.removePost(this::onTickPost)
            doTriggerPost = false
            postActions.sortBy {  ( priority, _) ->
                priority
            }
            postActions.forEach { (_, action) ->
                action()
            }
            postActions.clear()
        }
    }
}
