package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.ComandaDTO;

public interface ComandaService {
    public  Map<String, Object> obtenerComanda(ComandaDTO comandaDTO);
}
