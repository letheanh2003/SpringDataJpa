package rikkei.academy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByName(String name, Pageable pageable);

    boolean checkEmail(String email);

    Optional<Employee> findByEmail(String email);

    List<Employee> findAll();

    void save(Employee employee);

    Optional<Employee> findById(Long id);

    void deleteById(Long id);
}
