package rikkei.academy.service.department;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Department;
import rikkei.academy.repository.IDepartmentRepository;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentService implements IDepartmentService {
    private final IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findById(Long aLong) {
        return departmentRepository.findById(aLong);
    }


    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }





    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}
