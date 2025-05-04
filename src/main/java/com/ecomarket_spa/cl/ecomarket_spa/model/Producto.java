package com.ecomarket_spa.cl.ecomarket_spa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 13,nullable = false)
    private String ean; //nombre del codigo unico por producto

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer precio;

    @Column(nullable = true)
    private LocalDate fechaVencimiento;

    //Insertar productos en base de datos
    //INSERT INTO productos (ean, nombre,descripcion,precio,fecha_vencimiento) VALUES ('5482739106247','Jabón artesanal','Aroma lavanda, hecho con aceites vegetales y sin químicos',2990,'2026-08-15'),('1035827491653','Cepillo de dientes de bambú','Mango biodegradable y cerdas suaves sin BPA',3500,'2029-12-31'),('9821374650912','Shampo sólido','Coningredientes naturales, sin fulfatos ni envase plástico',5490,'2026-05-10'),('7364918203579','Bolsa reutilizable de algodón','Bolsa ecológica lavable, ideal para compras a granle',4200,'2030-01-01'),('6142098371546','Cera vegetal para velas','Cera de soja sin parafina, ideal para velas artesanales',6700,'2027-11-20')
}
