package com.example.demodespliegue.repositories;

import com.example.demodespliegue.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository <PersonaEntity, Long> {

    @Query("SELECT a FROM PersonaEntity a WHERE a.id_persona = ?1")
    public PersonaEntity findByIdRepository(Long id);

}
