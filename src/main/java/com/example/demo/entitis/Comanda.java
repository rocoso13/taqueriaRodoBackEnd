package com.example.demo.entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comanda")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyx")
    private Integer keyx;

    @Column(name = "numeromesa")
    private int numeroMesa;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechacreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechacierre")
    private LocalDateTime fechaCierre;

    @Column(name = "numero_orden")
    private Integer numeroOrden;
}
