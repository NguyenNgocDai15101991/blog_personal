package daif5.blog_personal.service;

import daif5.blog_personal.model.signinSignup.Role;
import daif5.blog_personal.model.signinSignup.RoleName;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(RoleName roleName);
    void save(Role role);
    List<Role> findAll();
    void delete(Role role);
}
