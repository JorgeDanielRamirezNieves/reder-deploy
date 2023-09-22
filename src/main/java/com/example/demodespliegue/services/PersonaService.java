package com.example.demodespliegue.services;

import com.example.demodespliegue.entities.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public List<PersonaEntity> find();
    public void save(PersonaEntity cliente);
    public PersonaEntity delete (Long id);
    public PersonaEntity update (PersonaEntity cliente);
}
