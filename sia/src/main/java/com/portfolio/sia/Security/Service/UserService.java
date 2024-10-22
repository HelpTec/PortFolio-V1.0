package com.portfolio.sia.Security.Service;

import com.portfolio.sia.Security.Entity.User.Role;
import com.portfolio.sia.Security.Entity.User.User;
import com.portfolio.sia.Security.Repository.RoleRepository;
import com.portfolio.sia.Security.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository; // Asumiendo que tienes un repo de roles.

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(String userName, String email, String password) throws Exception {
        if (userRepository.existsByEmail(email)) {
            throw new Exception("El usuario ya existe.");
        }

        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);

        // Asignar el rol por defecto
        Role userRole = roleRepository.findByName("USER");
        user.getRoles().add(userRole);

        return userRepository.save(user);
    }
}