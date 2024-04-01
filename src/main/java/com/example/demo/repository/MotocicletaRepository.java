package com.example.demo.repository;

import com.example.demo.model.Motocicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MotocicletaRepository extends JpaRepository<Motocicleta, Long> {
    boolean existsByAnoFabricacaoAndModeloAndPreco(int anoFabricacao, String modelo, double preco);
}
