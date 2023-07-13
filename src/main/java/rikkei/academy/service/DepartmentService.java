package rikkei.academy.service;

import rikkei.academy.model.Department;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    Department findByName(String name);

    List<Department> findAll();

    void save(Department department);

    Optional<Department> findById(Long id);

    void deleteById(Long id);
}
