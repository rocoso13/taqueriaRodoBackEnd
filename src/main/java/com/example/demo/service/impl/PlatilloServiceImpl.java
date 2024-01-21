package com.example.demo.service.impl;

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
        // PlatilloDTO[].class);
        List<PlatilloDTO> platilloDTO = List.of(objectMapper.convertValue(platillo, PlatilloDTO[].class));
        LOGGER.info(platilloDTO);
        return platilloDTO;
    }

    @Override
    public List<PlatilloDTO> agregarPlatillos(PlatilloDTO platilloDTO) {
        LOGGER.info("esto trae del front {}", platilloDTO);
        try {
            Platillo platillo = new Platillo();
            if (platilloDTO.getKeyx() != null) {
                // creo que esta consulta es inecesaria, pero la dejo aqui por si acaso
                platillo = platilloRepository.findByKeyx(platilloDTO.getKeyx());
            }

            platillo.setCarreta(platilloDTO.getCarreta());
            platillo.setDescripcion(platilloDTO.getDescripcion());
            platillo.setNombre(platilloDTO.getNombre());
            platillo.setPrecio(platilloDTO.getPrecio());

            platilloRepository.save(platillo);

            List<Platillo> platillos = platilloRepository.findAll();

            List<PlatilloDTO> platillosDTO = List.of(objectMapper.convertValue(platillos, PlatilloDTO[].class));
            return platillosDTO;
        } catch (Exception e) {
            LOGGER.error("Error al guardar el registro", e);
        }
        return null;
    }

    @Override
    public List<PlatilloDTO> eliminarPlatillo(Long keyx) {
        LOGGER.info("esto trae del front {}", keyx);
        try {
            Platillo platillo = new Platillo();

            platillo = platilloRepository.findByKeyx(keyx);

            platilloRepository.delete(platillo);

            List<Platillo> platillos = platilloRepository.findAll();
            List<PlatilloDTO> platillosDTO = List.of(objectMapper.convertValue(platillos, PlatilloDTO[].class));
            return platillosDTO;
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el registro", e);
        }
        return null;
    }
}
