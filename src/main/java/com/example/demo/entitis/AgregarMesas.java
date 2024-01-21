package com.example.demo.entitis;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "mesas")
@AllArgsConstructor
@NoArgsConstructor
@Data  // Especifica el nombre de la tabla en la base de datos
public class AgregarMesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyx")  // Especifica el nombre de la columna en la base de datos
    private Integer keyx;

    @Column(name = "numeromesa")
    private Integer numeroMesa;

    @Column(name = "habilitada")
    private Integer habilitada;

    @Column(name = "estatus")
    private Integer estatus;
    
}
