package daif5.blog_personal.repository;

import daif5.blog_personal.model.signinSignup.Role;
import daif5.blog_personal.model.signinSignup.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
