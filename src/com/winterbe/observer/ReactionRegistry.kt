package com.winterbe.observer

import com.winterbe.domain.IEntity

class ReactionRegistry {

    internal class Descriptor<T : Any, S>(val javaClass: Class<T>, val reaction: Reaction<T, S>)

    internal val descriptors: MutableList<Descriptor<*, *>> = mutableListOf()

    fun <T : IEntity, S> register(javaClass: Class<T>, reaction: Reaction<T, S>) {
        val descriptor = Descriptor(javaClass, reaction)
        descriptors.add(descriptor)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : IEntity> observe(entity: T) {
        if (entity.observerSupport != null) {
            return
        }

        val observers = descriptors
                .filter { it.javaClass.isAssignableFrom(entity.javaClass) }
                .map {
                    Observer<T, Any?>(entity, it.reaction as Reaction<T, Any?>)
                }

        if (observers.isNotEmpty()) {
            val observerSupport = ObserverSupport(observers)
            entity.observerSupport = observerSupport
        }
    }

    internal fun unregisterAll() {
        descriptors.clear()
    }

}