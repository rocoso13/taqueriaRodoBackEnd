package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entitis.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    Comanda findByKeyx(Integer keyx);

    Comanda findByNumeroMesaAndEstatus(int numeroMesa, String estatus);

    @Query(value = "SELECT * FROM comanda WHERE numeromesa = :numeroMesa AND estatus = :estatus", nativeQuery = true)
    Comanda findByNombreCustomQuery(@Param("numeroMesa") int numeroMesa, @Param("estatus") String estatus);
}