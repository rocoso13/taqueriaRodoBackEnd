package com.example.demo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.service.PlatilloService;

@Service
public class PlatilloServiceImpl implements PlatilloService {

    private static final Logger LOGGER = LogManager.getLogger(PlatilloServiceImpl.class.getName());
    
    @Override
    public String obtenerPlatillos() {
        LOGGER.info("entro al implement");
        return "hola putillla";
    }
}
