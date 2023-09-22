package com.example.demodespliegue.rest;

import com.example.demodespliegue.entities.PersonaEntity;
import com.example.demodespliegue.services.PersonaService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/persona")
public class PersonaRest {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/list")
    private ResponseEntity<List<PersonaEntity>> listarEquipo() {
        return ResponseEntity.ok((personaService.find()));
    }

    @PostMapping("/create")
    private ResponseEntity<PersonaEntity> guardar(@Validated @RequestBody PersonaEntity persona) {
        try {
            personaService.save(persona);
            ResponseEntity.status(200);
            return ResponseEntity.ok(persona);
        } catch (Exception e) {
            System.err.println("El error es: " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable("id") Long id) { //No devolverá un valor en específico
        try {
            personaService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.err.println("Error → " + e);
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();
        }
    }

    @PutMapping("/update")
    private ResponseEntity<PersonaEntity> update(@RequestBody PersonaEntity persona) {
        PersonaEntity temporal = personaService.update(persona);
        try {
            return ResponseEntity.created(new URI("/api/contactos" + temporal.getId_persona())).body(temporal);
        } catch (Exception e) {
            System.err.println("Error → " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
