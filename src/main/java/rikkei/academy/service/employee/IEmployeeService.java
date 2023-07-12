package rikkei.academy.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.model.Employee;
import rikkei.academy.service.IGenericService;

import java.util.Optional;

public interface IEmployeeService extends IGenericService<Employee,Long> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findAllByName(String name, Pageable pageable);
    boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);


}
