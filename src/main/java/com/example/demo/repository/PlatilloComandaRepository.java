package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entitis.PlatilloComanda;

@Repository
public interface PlatilloComandaRepository extends JpaRepository<PlatilloComanda, Long> {
    List<PlatilloComanda> findByIdComanda(String idComanda);

    List<PlatilloComanda> findByNumeroOrden(Integer numeroOrden);
}