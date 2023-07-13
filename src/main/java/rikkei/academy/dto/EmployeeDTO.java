package rikkei.academy.dto;

import rikkei.academy.model.Department;
import rikkei.academy.model.Role;

import java.util.List;
import java.util.Set;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String departmentId;
    private List<String> roles;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String email, String departmentId, List<String> roles) {
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
