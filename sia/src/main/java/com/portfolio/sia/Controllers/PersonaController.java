package com.portfolio.sia.Controllers;

import com.portfolio.sia.DTO.PersonaPublicaDTO;
import com.portfolio.sia.Entity.Persona;
import com.portfolio.sia.Repositorios.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    private final PersonaRepository personaRepository;
            
    public PersonaController(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    
    @GetMapping("/public")
    public List<PersonaPublicaDTO> getPersonasPublicas(){
        List<Persona> personas = personaRepository.findAll();
        
        return personas.stream()
                .map(persona -> new PersonaPublicaDTO(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getFPerfil(),
                        persona.getFBanner(), 
                        persona.getTelefono(),
                        persona.getAboutMe()))
                .collect(Collectors.toList());
    }
    
}
