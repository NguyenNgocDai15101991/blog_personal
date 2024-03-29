package daif5.blog_personal.service.impl;

import daif5.blog_personal.model.signinSignup.Role;
import daif5.blog_personal.model.signinSignup.RoleName;
import daif5.blog_personal.repository.RoleRepository;
import daif5.blog_personal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }
}
