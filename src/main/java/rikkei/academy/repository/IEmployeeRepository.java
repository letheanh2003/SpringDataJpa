package rikkei.academy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Employee;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findAllByName(String name, Pageable pageable);
    boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);


}
