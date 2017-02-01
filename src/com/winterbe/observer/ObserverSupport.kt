package com.winterbe.observer

import com.winterbe.domain.IEntity

class ObserverSupport<T : IEntity>(private val observers: List<Observer<T, *>>) {

    var suppressReactions = false

    private var notifying = false

    fun notifyObservers() {
        if (suppressReactions || notifying) {
            return
        }
        try {
            notifying = true
            observers.forEach { it.runReaction() }
        } finally {
            notifying = false
        }
    }

}