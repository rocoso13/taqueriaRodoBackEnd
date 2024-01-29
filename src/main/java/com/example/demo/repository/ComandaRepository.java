package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitis.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    Comanda findByKeyx(Integer keyx);
}