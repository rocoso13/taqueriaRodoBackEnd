package com.example.demo.controller;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponseDTO;
import com.example.demo.dto.ComandaDTO;
import com.example.demo.service.ComandaService;
import com.example.demo.util.Meta;

@RequestMapping("comandas")
@RestController
public class ComandasController {

    private final Meta meta = new Meta(UUID.randomUUID().toString(), "OK", 200);

    private static final Logger LOGGER = LogManager.getLogger(PlatillosController.class.getName());

    @Autowired
	private ComandaService service;

    @PostMapping("/obtenerComanda")
    public ApiResponseDTO obtenerComanda(@RequestBody ComandaDTO comandaDTO) {
        LOGGER.info("entro a obtener comanda {}",comandaDTO);
        return new ApiResponseDTO(meta, service.obtenerComanda(comandaDTO));
    }
    
}
