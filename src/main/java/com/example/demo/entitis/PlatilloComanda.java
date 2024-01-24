package com.example.demo.entitis;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "platillocomanda")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlatilloComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyx")  // Especifica el nombre de la columna en la base de datos
    private Integer keyx;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "idcomanda")
    private String idComanda;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;
}