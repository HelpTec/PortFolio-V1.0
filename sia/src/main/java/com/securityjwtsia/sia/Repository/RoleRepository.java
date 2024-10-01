package com.securityjwtsia.sia.Repository;

import com.securityjwtsia.sia.Entity.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
