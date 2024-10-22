package com.portfolio.sia.Security.Repository;

import com.portfolio.sia.Security.Entity.User.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findUserByEmail(String email);
  User findByUserName(String email);
  boolean existsByEmail(String email);
  
}