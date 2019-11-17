package com.enver.itcompany.dao;

import java.util.List;

public interface EntityInterface<T> {

    void add(T t);

    void update(T t);

    void remove(long id);

    T getById(long id);

    List<T> getAll();
}
