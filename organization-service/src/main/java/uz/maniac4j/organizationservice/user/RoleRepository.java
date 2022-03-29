package uz.maniac4j.organizationservice.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Short> {
    boolean existsByRoleName(RoleName roleName);
    Optional<Role> findByRoleName(RoleName roleName);
}
