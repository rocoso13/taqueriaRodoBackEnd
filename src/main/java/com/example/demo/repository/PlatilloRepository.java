package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitis.Platillo;

@Repository
public interface PlatilloRepository extends JpaRepository<Platillo, Long> {
    List<Platillo> findAll();
}
