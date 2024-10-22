package com.portfolio.sia.Security.DTO;

import com.portfolio.sia.Security.Entity.User.Role;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter @Setter private String userName;
    @Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter @Setter private Set<Role> Roles = new HashSet<>();
}
