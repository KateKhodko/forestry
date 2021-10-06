package com.khodko.forestry.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

    Serializable save(T item);

    void update(T item);

    void delete(T item);

    T findById(int id);

    List<T> findAll();
}
