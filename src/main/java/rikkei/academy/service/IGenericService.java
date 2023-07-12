package rikkei.academy.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T,E> {
    List<T> findAll();
    void save(T t);
    Optional<T> findById(E e);
    void deleteById(E e);
}
