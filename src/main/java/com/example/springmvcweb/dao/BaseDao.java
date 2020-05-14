package com.example.springmvcweb.dao;

import java.util.List;

public interface BaseDao<T> {
    T get(Long id);

    void save(T obj);

    void delete(T obj);
}
