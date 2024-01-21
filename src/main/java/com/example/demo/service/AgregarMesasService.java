package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AgregarMesasDTO;


public interface AgregarMesasService {
    public List<AgregarMesasDTO> obtenerAgregarMesas();

    public List<AgregarMesasDTO> agregarMesa(AgregarMesasDTO agregarMesasDTO);

    public List<AgregarMesasDTO> eliminarAgregarMesa(Integer keyx);
}
