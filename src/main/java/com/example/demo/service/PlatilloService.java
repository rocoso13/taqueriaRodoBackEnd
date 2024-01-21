package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PlatilloDTO;

public interface PlatilloService {
    public List<PlatilloDTO> obtenerPlatillos();

    public List<PlatilloDTO> agregarPlatillos(PlatilloDTO platilloDTO);

    public List<PlatilloDTO> eliminarPlatillo(Long keyx);
}
