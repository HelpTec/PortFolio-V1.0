package com.securityjwtsia.sia.Repository;

import com.securityjwtsia.sia.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}