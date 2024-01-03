package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlatillosController {

    @GetMapping("/saludo")
    @ResponseBody
    public String saludar() {
        return "Hola, ¡esta es una respuesta desde el controlador!";
    }
}