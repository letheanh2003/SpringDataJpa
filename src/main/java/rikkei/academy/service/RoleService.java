package rikkei.academy.service;

import rikkei.academy.model.Role;

import java.util.List;
import java.util.Optional;


public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Optional<Role> findById(Long id);

    void deleteById(Long id);
}
