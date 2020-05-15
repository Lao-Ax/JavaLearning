package com.Alex.patterns.CompositePattern_1.Observer;

import com.Alex.patterns.CompositePattern_1.QuackObservable;

public interface Observer {
    public void update(QuackObservable duck);
}
