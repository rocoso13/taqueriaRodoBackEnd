package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.ComandaDTO;
import com.example.demo.dto.PedidoDTO;
public interface ComandaService {
    public  Map<String, Object> obtenerComanda(ComandaDTO comandaDTO);

    public  Map<String, Object> agregarComanda(PedidoDTO pedidoDTO);
}
