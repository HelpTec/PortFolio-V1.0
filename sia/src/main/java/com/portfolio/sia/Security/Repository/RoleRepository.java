package com.portfolio.sia.Security.Repository;

import com.portfolio.sia.Security.Entity.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
