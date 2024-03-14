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
import com.example.demo.entitis.AgregarMesas;
import com.example.demo.entitis.Comanda;
import com.example.demo.entitis.PlatilloComanda;
import com.example.demo.repository.AgregarMesasRepository;
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

  @Autowired
  AgregarMesasRepository agregarMesasRepository;

  @Override
  public Map<String, Object> obtenerComanda(ComandaDTO comandaDTO) {
    LOGGER.info("entro al service de obtener comanda {}", comandaDTO);
    Map<String, Object> hashMap = new HashMap<>();
    AgregarMesas agregarMesas = new AgregarMesas();
    try {
      LOGGER.info("paso 1");
      agregarMesas = agregarMesasRepository.findByNumeroMesa(comandaDTO.getNumeroMesa());
      LOGGER.info("paso 2 {}", agregarMesas);
      // Comanda comanda = comandaRepository.findByNombreCustomQuery(comandaDTO.getNumeroMesa(), "enviar");
      Comanda comanda = comandaRepository.findByNumeroOrden(agregarMesas.getNumeroOrden());
      LOGGER.info("paso 3");
      List<PlatilloComanda> platillosComanda = platilloComandaRepository.findByNumeroOrden(agregarMesas.getNumeroOrden());
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
    AgregarMesas agregarMesas = new AgregarMesas();
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
            if (comanda.getNumeroOrden() == 0 || comanda.getNumeroOrden() == null) {
              comanda.setNumeroOrden(comandaRepository.obtenerNumeroOrden() == null ? 0 : comandaRepository.obtenerNumeroOrden());
              agregarMesas = agregarMesasRepository.findByNumeroMesa(pedidoDTO.getComandaDTO().getNumeroMesa());
              agregarMesas.setNumeroOrden(comanda.getNumeroOrden());
              agregarMesasRepository.save(agregarMesas);
            }
            LOGGER.info(platillo.getKeyx().intValue());
            platilloComanda.setKeyx(platillo.getKeyx().intValue());
            LOGGER.info("paso 1");
            LOGGER.info("consulta {}", comandaRepository.obtenerNumeroOrden());
            platilloComanda.setNumeroOrden(comanda.getNumeroOrden());
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
        LOGGER.info("aquii trono");
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
