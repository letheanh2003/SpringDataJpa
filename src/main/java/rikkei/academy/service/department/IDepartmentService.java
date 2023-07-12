package rikkei.academy.service.department;

import rikkei.academy.model.Department;
import rikkei.academy.service.IGenericService;


public interface IDepartmentService extends IGenericService<Department, Long> {
    Department findByName(String name);
}
