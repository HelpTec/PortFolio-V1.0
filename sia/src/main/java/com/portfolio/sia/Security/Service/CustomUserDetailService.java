package com.portfolio.sia.Security.Service;

import com.portfolio.sia.Security.Entity.User.User;
import com.portfolio.sia.Security.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService{
    
    private UserRepository userRepository;
    
    public CustomUserDetailService(UserRepository userRepo){
        this.userRepository = userRepo;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if(!optionalUser.isPresent()){
            throw new UsernameNotFoundException("no encontrado");
        }
        User user = optionalUser.get();
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }
    
}
