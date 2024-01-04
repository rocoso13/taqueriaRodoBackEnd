package com.example.demo.entitis;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "platillos")  // Especifica el nombre de la tabla en la base de datos
public class Platillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyx")  // Especifica el nombre de la columna en la base de datos
    private Long keyx;

    @Column(name = "carreta")
    private int carreta;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;
}