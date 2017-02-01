package com.winterbe.observer

import com.winterbe.domain.IEntity

class Observer<in T : IEntity, S : Any?>(private val observable: T, private val reaction: Reaction<T, S?>) {

    private var snapshot: S? = null

    init {
        snapshot = reaction.getState(observable)
    }

    fun runReaction() {
        val oldValue = snapshot
        val newValue = reaction.getState(observable)
        if (oldValue != newValue) {
            reaction.onStateChange(observable, newValue, oldValue)
            snapshot = newValue
        }
    }

}