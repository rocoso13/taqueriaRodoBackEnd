package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitis.AgregarMesas;


@Repository
public interface AgregarMesasRepository extends JpaRepository<AgregarMesas, Long> {
    
    List<AgregarMesas> findAll();

    AgregarMesas findByKeyx(Integer keyx);
}
