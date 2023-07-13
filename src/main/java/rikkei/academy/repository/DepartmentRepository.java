package rikkei.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Department;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);

}
