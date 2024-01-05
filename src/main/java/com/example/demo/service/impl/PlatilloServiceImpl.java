package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PlatilloDTO;
import com.example.demo.entitis.Platillo;
import com.example.demo.repository.PlatilloRepository;
import com.example.demo.service.PlatilloService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlatilloServiceImpl implements PlatilloService {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = LogManager.getLogger(PlatilloServiceImpl.class.getName());

    @Autowired
    PlatilloRepository platilloRepository;
    
    @Override
    public List<PlatilloDTO> obtenerPlatillos() {
        // List<PlatilloDTO> platilloDTO = new ArrayList<PlatilloDTO>();
        LOGGER.info("entró al implement");
        List<Platillo> platillo = platilloRepository.findAll();
        // platilloDTO
        // List<PlatilloDTO> platilloDTO = objectMapper.readValue(platillo,
        //             PlatilloDTO[].class);
        List<PlatilloDTO> platilloDTO = List.of(objectMapper.convertValue(platillo, PlatilloDTO[].class));
        LOGGER.info(platilloDTO);
        return platilloDTO;
    }

     @Override
    public PlatilloDTO agregarPlatillos(PlatilloDTO platilloDTO) {
        LOGGER.info("entro al service");
        LOGGER.info("este es el dto {}", platilloDTO);
        return null;
    }
}
