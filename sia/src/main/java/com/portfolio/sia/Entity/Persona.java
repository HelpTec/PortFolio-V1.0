
package com.portfolio.sia.Entity;

import com.portfolio.sia.Security.Entity.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    private String apellido;
    
    private String fPerfil;
    
    private String fBanner;
    
    private Long telefono;
    
    @Column(length = 1000)
    private String aboutMe;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;
}
