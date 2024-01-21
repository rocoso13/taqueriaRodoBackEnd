package com.example.demo.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AgregarMesasDTO;
import com.example.demo.dto.PlatilloDTO;
import com.example.demo.entitis.AgregarMesas;
import com.example.demo.entitis.Platillo;
import com.example.demo.repository.AgregarMesasRepository;
import com.example.demo.service.AgregarMesasService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AgregarMesasServiceImpl implements AgregarMesasService {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = LogManager.getLogger(AgregarMesasServiceImpl.class.getName());

    @Autowired
    AgregarMesasRepository agregarMesasRepository;

    @Override
    public List<AgregarMesasDTO> obtenerAgregarMesas() {
        try {
            LOGGER.info("entró al implement");
            List<AgregarMesas> agregarMesas = agregarMesasRepository.findAll();
            List<AgregarMesasDTO> agregarMesasDTO = List
                    .of(objectMapper.convertValue(agregarMesas, AgregarMesasDTO[].class));
            LOGGER.info(agregarMesasDTO);
            return agregarMesasDTO;
        } catch (Exception e) {
            LOGGER.error("Error al consultar agregarmesas", e);
        }
        return null;
    }

    @Override
    public List<AgregarMesasDTO> agregarMesa(AgregarMesasDTO agregarMesaDTO) {
        LOGGER.info("esto trae del front {}", agregarMesaDTO);
        try {
            AgregarMesas agregarMesa = new AgregarMesas();
            if (agregarMesaDTO.getKeyx() != null) {
                // creo que esta consulta es inecesaria, pero la dejo aqui por si acaso
                agregarMesa = agregarMesasRepository.findByKeyx(agregarMesaDTO.getKeyx());
            }

            agregarMesa.setEstatus(agregarMesaDTO.getEstatus());
            agregarMesa.setHabilitada(agregarMesaDTO.getHabilitada());
            agregarMesa.setNumeroMesa(agregarMesaDTO.getNumeroMesa());


            agregarMesasRepository.save(agregarMesa);

            List<AgregarMesas> agregarMesas = agregarMesasRepository.findAll();

            List<AgregarMesasDTO> agregarMesasDTO = List.of(objectMapper.convertValue(agregarMesas, AgregarMesasDTO[].class));
            return agregarMesasDTO;
        } catch (Exception e) {
            LOGGER.error("Error al guardar el registro", e);
        }
        return null;
    }

    @Override
    public List<AgregarMesasDTO> eliminarAgregarMesa(Integer keyx) {
        LOGGER.info("esto trae del front {}", keyx);
        try {
            AgregarMesas agregarMesa = new AgregarMesas();

            agregarMesa = agregarMesasRepository.findByKeyx(keyx);

            agregarMesasRepository.delete(agregarMesa);

            List<AgregarMesas> agregarMesas = agregarMesasRepository.findAll();
            List<AgregarMesasDTO> agregarMesasDTO = List.of(objectMapper.convertValue(agregarMesas, AgregarMesasDTO[].class));
            return agregarMesasDTO;
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el registro", e);
        }
        return null;
    }
}
