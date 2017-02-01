package com.winterbe.observer

interface Reaction<in T : Any, S : Any?> {
    fun getState(observable: T): S
    fun onStateChange(observable: T, newValue: S, oldValue: S)
}