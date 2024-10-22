package com.portfolio.sia.Security.Entity.User;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @Getter @Setter private String userName;
    @Getter @Setter private String email;
    @Getter @Setter private String password;
    
    @ManyToMany    
    @Getter @Setter private Set<Role> Roles = new HashSet<>();
    
}
