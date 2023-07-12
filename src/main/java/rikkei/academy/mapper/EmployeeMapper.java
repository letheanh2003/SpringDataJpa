package rikkei.academy.mapper;

import org.springframework.stereotype.Component;
import rikkei.academy.dto.EmployeeDTO;
import rikkei.academy.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper implements IEntityMapper<EmployeeDTO, Employee> {
    @Override
    public Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartmentId());
        return employee;
    }

    @Override
    public EmployeeDTO toDto(Employee entity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(entity.getId());
        employeeDTO.setName(entity.getName());
        employeeDTO.setEmail(entity.getEmail());
        employeeDTO.setDepartmentId(entity.getDepartment());
        return employeeDTO;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDTO> dtoList) {
        List<Employee> employees = new ArrayList<>();
        for (EmployeeDTO employeeDTO : dtoList) {
            employees.add(toEntity(employeeDTO));
        }
        return employees;
    }

    @Override
    public List<EmployeeDTO> toDto(List<Employee> entityList) {
        List<EmployeeDTO> employeeDTO = new ArrayList<>();
        for (Employee employee : entityList) {
            employeeDTO.add(toDto(employee));
        }
        return employeeDTO;
    }
}
