package com.example.demo.repository;

import com.example.demo.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarroRepository extends JpaRepository<Carro, Long> {
    boolean existsByAnoFabricacaoAndModeloAndPreco(int anoFabricacao, String modelo, double preco);
}
