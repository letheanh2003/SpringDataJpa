package rikkei.academy.service.serviceImpl;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Role;
import rikkei.academy.repository.RoleRepository;
import rikkei.academy.service.RoleService;


import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceIMPL implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceIMPL(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Optional<Role> findById(Long aLong) {
        return roleRepository.findById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        roleRepository.deleteById(aLong);
    }


}