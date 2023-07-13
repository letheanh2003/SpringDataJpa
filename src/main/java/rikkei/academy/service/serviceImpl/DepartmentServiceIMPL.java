package rikkei.academy.service.serviceImpl;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Department;
import rikkei.academy.repository.DepartmentRepository;
import rikkei.academy.service.DepartmentService;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceIMPL implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceIMPL(DepartmentRepository departmentRepository) {
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
