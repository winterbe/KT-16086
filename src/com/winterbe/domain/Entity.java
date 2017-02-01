package com.winterbe.domain;

import com.winterbe.observer.ObserverSupport;

/**
 * @author Benjamin Winterberg
 */
public class Entity implements IEntity {

    private ObserverSupport observerSupport;

    @Override
    public ObserverSupport getObserverSupport() {
        return observerSupport;
    }

    @Override
    public void setObserverSupport(ObserverSupport observerSupport) {
        this.observerSupport = observerSupport;
    }
}
