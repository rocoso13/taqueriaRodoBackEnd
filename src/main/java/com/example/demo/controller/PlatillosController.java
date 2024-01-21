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

import com.example.demo.dto.ApiResponseDTO;
import com.example.demo.dto.PlatilloDTO;
import com.example.demo.service.PlatilloService;
import com.example.demo.service.impl.PlatilloServiceImpl;
import com.example.demo.util.Meta;

@RequestMapping("platillos")
@RestController
public class PlatillosController {

    @Autowired
	private PlatilloService service;

    private final Meta meta = new Meta(UUID.randomUUID().toString(), "OK", 200);

    private static final Logger LOGGER = LogManager.getLogger(PlatillosController.class.getName());

    @GetMapping("/saludo")
    public String saludar() {
        return "Hola, ¡esta es una respuesta desde el controlador!";
    }

    @GetMapping("/obtenerPlatillos")
    public ApiResponseDTO consultarProductos() {
        return new ApiResponseDTO(meta, service.obtenerPlatillos());
    }
    
    @PostMapping("/agregarPlatillos")
    public ApiResponseDTO actualizarTasas(@RequestBody PlatilloDTO platilloDTO,
            @RequestHeader(value = "numemp", required = false) Integer numEmp) {
        LOGGER.info("entro al controlador");
        return new ApiResponseDTO(meta, service.agregarPlatillos(platilloDTO));
    }

    @PostMapping("/eliminarPlatillo")
    public ApiResponseDTO eliminarPlatillo(@RequestBody Long keyx) {
        LOGGER.info("entro al controlador {}",keyx);
        return new ApiResponseDTO(meta, service.eliminarPlatillo(keyx));
    }
}