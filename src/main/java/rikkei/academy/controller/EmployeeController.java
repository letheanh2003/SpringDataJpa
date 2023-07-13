package rikkei.academy.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.dto.EmployeeDTO;
import rikkei.academy.mapper.EmployeeMapper;
import rikkei.academy.model.Department;
import rikkei.academy.model.Employee;
import rikkei.academy.service.DepartmentService;
import rikkei.academy.service.EmployeeService;
import rikkei.academy.service.RoleService;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final EmployeeMapper employeeMapper;


    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/employee")
    public ResponseEntity<?> findAll(@RequestParam(value = "name", required = false) String name, Pageable pageable) {
        Page<Employee> employees;
        if (name != null && !name.isEmpty()) {
            employees = employeeService.findAllByName(name, pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        Page<EmployeeDTO> employeeDTOS = employees.map(employeeMapper::toDto);
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }
    @PostMapping("/employee")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        boolean checkEmail = employeeService.checkEmail(employee.getEmail());
        if (checkEmail) {
            return new ResponseEntity<>("email existed, please try again!", HttpStatus.FAILED_DEPENDENCY);
        }
        employeeService.save(employee);
        EmployeeDTO employeeDto = employeeMapper.toDto(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<?> update(@RequestBody EmployeeDTO employeeDTO) {
        Optional<Employee> employeeByEmail = employeeService.findByEmail(employeeDTO.getEmail());
        if (employeeByEmail.isPresent() && employeeByEmail.get().getId() != employeeDTO.getId()) {
            return new ResponseEntity<>("email existed, please try again! ", HttpStatus.BAD_REQUEST);
        } else {
            Department department = departmentService.findByName(employeeDTO.getDepartmentId());
            Optional<Employee> employeeUpdate = employeeService.findById(employeeDTO.getId());
            employeeUpdate.get().setDepartment(department);
            employeeUpdate.get().setName(employeeDTO.getName());
            employeeUpdate.get().setEmail(employeeDTO.getEmail());
            employeeService.save(employeeUpdate.get());
            return new ResponseEntity<>("update success fully", HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>("not found, please try again! ", HttpStatus.NOT_FOUND);
        } else {
            employeeService.deleteById(id);
            return new ResponseEntity<>("delete success fully!", HttpStatus.OK);
        }
    }
}
