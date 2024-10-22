
package com.portfolio.sia.DataInitializer;

import com.portfolio.sia.Security.Entity.User.Role;
import com.portfolio.sia.Security.Entity.User.User;
import com.portfolio.sia.Security.Repository.RoleRepository;
import com.portfolio.sia.Security.Repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired 
    private PasswordEncoder passwordEncoder;
    
    @Value("${app.default-user.userMail}")
    private String defaultUserMail;
    
    @Value("${app.default-user.password}")
    private String defaultPassword;
    
    @Override
    public void run(String... args)throws Exception {
        if (userRepository.findByUserName(defaultUserMail)== null) {
            
            Role roleUser = roleRepository.findByName("ROLE_USER");
            if (roleUser == null) {
                roleUser = new Role();
                roleUser.setName("ROLE_USER");
                roleRepository.save(roleUser);
            }
            
            Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
            if(roleAdmin == null){
                roleAdmin = new Role();
                roleAdmin.setName("ROLE_ADMIN");
                roleRepository.save(roleAdmin);
            }
            
            Set<Role> roles = new HashSet<>();
            roles.add(roleUser);
            roles.add(roleAdmin);
            
            User user = new User();
            user.setUserName("prueba");
            user.setEmail(defaultUserMail);
            user.setPassword(defaultPassword);
            user.setRoles(roles);
            
            userRepository.save(user);
        }
    }
}
