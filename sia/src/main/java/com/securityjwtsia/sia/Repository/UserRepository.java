package com.securityjwtsia.sia.Repository;

import com.securityjwtsia.sia.Entity.User.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findUserByEmail(String email);
  boolean existsByEmail(String email);
  
}