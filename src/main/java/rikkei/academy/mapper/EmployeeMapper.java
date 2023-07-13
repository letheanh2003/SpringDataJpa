package rikkei.academy.mapper;

import org.springframework.stereotype.Component;
import rikkei.academy.dto.EmployeeDTO;
import rikkei.academy.model.Employee;
import rikkei.academy.model.Role;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper implements IEntityMapper<EmployeeDTO, Employee> {
    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        return employee;
    }

    @Override
    public EmployeeDTO toDto(Employee entity) {
        if (entity == null) {
            return null;
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(entity.getId());
        employeeDTO.setName(entity.getName());
        employeeDTO.setEmail(entity.getEmail());
        employeeDTO.setDepartmentId(entity.getDepartment().getName());
        List<String> listRole = new ArrayList<>();
        for (Role role : entity.getRoles()) {
            listRole.add(role.getName());
        }
        employeeDTO.setRoles(listRole);
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
