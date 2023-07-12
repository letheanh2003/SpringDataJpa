package rikkei.academy.service.role;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Role;
import rikkei.academy.repository.IRoleRepository;


import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
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