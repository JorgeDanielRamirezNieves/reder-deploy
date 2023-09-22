package com.example.demodespliegue.services.interfaces;

import com.example.demodespliegue.entities.PersonaEntity;
import com.example.demodespliegue.repositories.PersonaRepository;
import com.example.demodespliegue.services.PersonaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImplement implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional (readOnly = true)
    public List<PersonaEntity> find() {
        return personaRepository.findAll();
    }

    @Override
    public void save(PersonaEntity persona) {
        personaRepository.save(persona);
    }

    @Override
    @Transactional
    public PersonaEntity delete(Long id) {
        PersonaEntity personaAux = personaRepository.findByIdRepository(id);
        if (personaAux == null){
            throw new EntityNotFoundException();
        }

        personaRepository.delete(personaAux);
        return personaAux;
    }

    @Override
    @Transactional
    public PersonaEntity update(PersonaEntity clientes) {
        return personaRepository.save(clientes);
    }


}