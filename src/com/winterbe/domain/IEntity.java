package com.winterbe.domain;

import com.winterbe.observer.ObserverSupport;

public interface IEntity {
    ObserverSupport getObserverSupport();
    void setObserverSupport(ObserverSupport observerSupport);
}
