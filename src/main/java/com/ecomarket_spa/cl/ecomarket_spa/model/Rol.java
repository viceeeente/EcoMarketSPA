package com.ecomarket_spa.cl.ecomarket_spa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "rol")
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre; //Ej del caso de estudio: ADMINISTRADOR, GERENTE, EMPLEADO, LOGISTICA
    //Insert en tabla:  INSERT INTO rol (nombre) VALUES ('ADMINISTRADOR'),('GERENTE'),('EMPLEADO'),('LOGISTICA')

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}
