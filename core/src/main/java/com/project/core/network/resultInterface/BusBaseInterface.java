package com.project.core.network.resultInterface;


public interface BusBaseInterface<T> {
    void success(T item);

    void error(String message);
}