package com.example.demo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PlatilloRepository;
import com.example.demo.service.PlatilloService;

@Service
public class PlatilloServiceImpl implements PlatilloService {

    private static final Logger LOGGER = LogManager.getLogger(PlatilloServiceImpl.class.getName());

    @Autowired
    PlatilloRepository platilloRepository;
    
    @Override
    public String obtenerPlatillos() {
        LOGGER.info("entro al implement");
        LOGGER.info(platilloRepository.findAll());
        return "hola putillla";
    }
}
