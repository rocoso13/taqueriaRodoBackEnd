package com.example.demo.controller;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AgregarMesasDTO;
import com.example.demo.dto.ApiResponseDTO;
import com.example.demo.dto.PlatilloDTO;
import com.example.demo.service.AgregarMesasService;
import com.example.demo.util.Meta;

@RequestMapping("agregarMesas")
@RestController
public class AgregarMesasController {

    @Autowired
	private AgregarMesasService service;
    
    private final Meta meta = new Meta(UUID.randomUUID().toString(), "OK", 200);

    private static final Logger LOGGER = LogManager.getLogger(AgregarMesasController.class.getName());

    @GetMapping("/obtenerAgregarMesas")
    public ApiResponseDTO consultarAgregarMesas() {
        LOGGER.info("entro a consultar agregarmesas");
        return new ApiResponseDTO(meta, service.obtenerAgregarMesas());
    }

    @PostMapping("/agregarMesa")
    public ApiResponseDTO agregarMesa(@RequestBody AgregarMesasDTO agregarMesasDTO) {
        LOGGER.info("entro al controlador");
        return new ApiResponseDTO(meta, service.agregarMesa(agregarMesasDTO));
    }

    @PostMapping("/eliminarAgregarMesa")
    public ApiResponseDTO eliminarAgregarMesa(@RequestBody Integer keyx) {
        LOGGER.info("entro al controlador {}",keyx);
        return new ApiResponseDTO(meta, service.eliminarAgregarMesa(keyx));
    }
}
