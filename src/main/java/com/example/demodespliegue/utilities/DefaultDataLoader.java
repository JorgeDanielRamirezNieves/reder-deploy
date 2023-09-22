package com.example.demodespliegue.utilities;

import com.example.demodespliegue.entities.PersonaEntity;
import com.example.demodespliegue.repositories.PersonaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataLoader {

    @Autowired
    private PersonaRepository personaRepository;

    @PostConstruct
    public void init() {
        if (personaRepository.count() == 0) {

            PersonaEntity person1 = new PersonaEntity();
            person1.setNombre("Persona 1");
            person1.setApellido("Apellido 1");
            person1.setCorreo("Correo 1");
            personaRepository.save(person1);


            PersonaEntity person2 = new PersonaEntity();
            person2.setNombre("Persona 2");
            person2.setApellido("Apellido 2");
            person2.setCorreo("Correo 2");
            personaRepository.save(person2);


            PersonaEntity person3 = new PersonaEntity();
            person3.setNombre("Persona 3");
            person3.setApellido("Apellido 3");
            person3.setCorreo("Correo 3");
            personaRepository.save(person3);
        }
    }

}