package com.example.demo.service.impl;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ComandaDTO;
import com.example.demo.service.ComandaService;
// import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ComandaServiceImpl implements ComandaService {

    // private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = LogManager.getLogger(PlatilloServiceImpl.class.getName());
    
    @Override
    public Map<String, Object> obtenerComanda(ComandaDTO comandaDTO) {
        // List<PlatilloDTO> platilloDTO = new ArrayList<PlatilloDTO>();
      LOGGER.info("entro al service de obtener comanda {}", comandaDTO);
        return null;
    }
}
