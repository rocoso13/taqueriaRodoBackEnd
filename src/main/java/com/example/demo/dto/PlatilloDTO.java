package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlatilloDTO {
    private Long keyx;
    private int carreta;
    private String descripcion;
    private String nombre;
    private double precio;
}
