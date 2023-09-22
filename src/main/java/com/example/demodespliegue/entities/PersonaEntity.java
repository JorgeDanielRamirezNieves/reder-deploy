package com.example.demodespliegue.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "Personas")
public class PersonaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id_persona;

    @NotNull
    @Size(max = 30)
    @Column
    private String nombre;

    @NotNull
    @Size(max = 30)
    @Column
    private String apellido;

    @NotNull
    @Size(max = 30)
    @Column
    private String correo;
}
