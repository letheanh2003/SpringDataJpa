package rikkei.academy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Employee;
import rikkei.academy.repository.EmployeeRepository;
import rikkei.academy.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceIMPL(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long aLong) {
        return employeeRepository.findById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        employeeRepository.deleteById(aLong);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByName(String name, Pageable pageable) {
        return employeeRepository.findAllByName(name, pageable);
    }

    @Override
    public boolean checkEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
