package rikkei.academy.dto;

import rikkei.academy.model.Department;
import rikkei.academy.model.Role;
import java.util.Set;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Department departmentId;
    private Set<Role> roles;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String email, Department departmentId, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
