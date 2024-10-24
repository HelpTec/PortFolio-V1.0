package com.portfolio.sia.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaPublicaDTO {

    private String nombre;
    private String apellido;
    private String fPerfil;
    private String fBanner;
    private Long telefono;
    private String aboutMe;

    public PersonaPublicaDTO(
            String nombre, 
            String apellido, 
            String fotoPerfil, 
            String fotoBanner, 
            Long telefono,
            String aboutMe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fPerfil = fotoPerfil;
        this.fBanner = fotoBanner;
        this.telefono = telefono;
        this.aboutMe = aboutMe;
    }

}
