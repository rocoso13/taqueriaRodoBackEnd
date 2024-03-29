package com.example.demo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComandaDTO {
    private Integer keyx = 0;
    private int numeroMesa;
    private String estatus;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCierre;
    private Integer numeroOrden = 0;
}
