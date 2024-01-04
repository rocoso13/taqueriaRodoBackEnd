package com.example.demo.controller;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponseDTO;
import com.example.demo.service.PlatilloService;
import com.example.demo.util.Meta;

@RequestMapping("platillos")
@RestController
public class PlatillosController {

    @Autowired
	private PlatilloService service;

    private final Meta meta = new Meta(UUID.randomUUID().toString(), "OK", 200);

    @GetMapping("/saludo")
    public String saludar() {
        return "Hola, ¡esta es una respuesta desde el controlador!";
    }

    @GetMapping("/obtenerPlatillos")
	public ApiResponseDTO consultarProductos() {
		return new ApiResponseDTO(meta, service.obtenerPlatillos());
	}
}