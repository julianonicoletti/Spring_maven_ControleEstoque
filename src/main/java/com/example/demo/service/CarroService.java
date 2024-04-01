package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService implements VeiculoService <Carro>{
   @Autowired
   CarroRepository carroRepository;

   @Override
   public List<Carro> listar() {
      return carroRepository.findAll();
   }

   @Override
   public Carro criar(Carro carro) {
      boolean carroExiste = carroRepository.existsByAnoFabricacaoAndModeloAndPreco(carro.getAnoFabricacao(),
                              carro.getModelo(), carro.getPreco());
      if(carroExiste){
         return null;
      } else {
         return carroRepository.save(carro);
      }
   }
   @Override
   public Carro atualizar(Carro carro, Long id) {
      if(carroRepository.existsById(id)){
         carro.setId(id);
         return carroRepository.save(carro);
      } else {
         return null;
      }
   }
   @Override
   public boolean deletar(Long id) {
      if(carroRepository.existsById(id)) {
         carroRepository.deleteById(id);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public List<Carro> listarPorPreco() {
      return carroRepository.findAll().stream()
              .sorted(Comparator.comparingDouble(Carro::getPreco))
              .collect(Collectors.toList());
   }

   @Override
   public String retornaIpva(Long id) {
      return carroRepository.findById(id)
              .map(carro -> String.format("IPVA do Veículo: R$ %.2f", carro.getPreco() * 0.035))
              .orElse(null);
   }

   @Override
   public List<Carro> aplicarBlackFriday() {
      List<Carro> carros = carroRepository.findAll();
      for (Carro carro: carros){
         carro.setPreco(carro.getPreco() - (carro.getPreco()*0.15) );
      }
      return carroRepository.findAll();
   }
}
