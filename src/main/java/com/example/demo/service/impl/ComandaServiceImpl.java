package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ComandaDTO;
import com.example.demo.dto.PedidoDTO;
import com.example.demo.dto.PlatilloDTO;
import com.example.demo.entitis.Comanda;
import com.example.demo.entitis.PlatilloComanda;
import com.example.demo.repository.ComandaRepository;
import com.example.demo.repository.PlatilloComandaRepository;
import com.example.demo.repository.PlatilloRepository;
import com.example.demo.service.ComandaService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ComandaServiceImpl implements ComandaService {

  private ObjectMapper objectMapper = new ObjectMapper();

  private static final Logger LOGGER = LogManager.getLogger(PlatilloServiceImpl.class.getName());

  @Autowired
  ComandaRepository comandaRepository;

  @Autowired
  PlatilloRepository platilloRepository;

  @Autowired
  PlatilloComandaRepository platilloComandaRepository;

  @Override
  public Map<String, Object> obtenerComanda(ComandaDTO comandaDTO) {
    LOGGER.info("entro al service de obtener comanda {}", comandaDTO);
    Map<String, Object> hashMap = new HashMap<>();

    try {
      Comanda comanda = comandaRepository.findByNombreCustomQuery(comandaDTO.getNumeroMesa(), "enviar");
      List<PlatilloComanda> platillosComanda = platilloComandaRepository.findByIdComanda(comandaDTO.getKeyx().toString());
      LOGGER.info("esto trae la consulta de comanda", comanda);
      hashMap.put("comanda", comanda);
      hashMap.put("platillos", platillosComanda);
      return hashMap;
    } catch (Exception e) {
      LOGGER.error("Error al consultar la comanda y platillos", e);
      return null;
    }

  }

  @Override
  public Map<String, Object> agregarComanda(PedidoDTO pedidoDTO) {
    Map<String, Object> hashMap = new HashMap<>();
    Comanda comanda = new Comanda();
    List<PlatilloComanda> platillosComanda = new ArrayList<PlatilloComanda>();

    LOGGER.info("esto se guardara en la comanda {}",pedidoDTO);
    try {
      try {
        comanda = objectMapper.convertValue(pedidoDTO.getComandaDTO(), Comanda.class);
        // platillosComanda = List.of(objectMapper.convertValue(pedidoDTO.getPlatillosComanda(), PlatilloComanda[].class));
        //seteo de valores platilloscomanda
        for (PlatilloDTO platillo : pedidoDTO.getPlatillosComanda()) {
          PlatilloComanda platilloComanda = new PlatilloComanda();
          if (comanda.getEstatus().equals("enviar")) {
            LOGGER.info(platillo.getKeyx().intValue());
            platilloComanda.setKeyx(platillo.getKeyx().intValue());
          }
          platilloComanda.setCantidad(platillo.getCantidad());
          platilloComanda.setCarreta(platillo.getCarreta());
          platilloComanda.setDescripcion(platillo.getDescripcion());
          platilloComanda.setEstatus(pedidoDTO.getComandaDTO().getEstatus());
          platilloComanda.setIdComanda(pedidoDTO.getComandaDTO().getKeyx().toString());
          platilloComanda.setNombre(platillo.getNombre());
          platilloComanda.setPrecio(platillo.getPrecio());
          platillosComanda.add(platilloComanda);
        }

        platilloComandaRepository.saveAll(platillosComanda);
        LOGGER.info("se va aguardar la comanda {}", comanda);
        comandaRepository.save(comanda);
      } catch (Exception e) {
        LOGGER.error("Error al mapear la comanda", e);
      }
    } catch (Exception e) {
      LOGGER.error("Error al grabar la comanda", e);
    }
    
    return null;
  }
}
