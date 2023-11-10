package net.server.dao;


import java.util.List;

public interface Dao<T> {
    void insert(T object);
    T get(Integer id);
    List<T> getAll();
}
