package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.model.Motocicleta;
import com.example.demo.repository.MotocicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotocicletaService implements VeiculoService<Motocicleta> {

   @Autowired
   MotocicletaRepository motocicletaRepository;
   @Override
   public List<Motocicleta> listar() {
      return motocicletaRepository.findAll();
   }

   @Override
   public Motocicleta criar(Motocicleta motocicleta) {
      boolean carroExiste = motocicletaRepository.existsByAnoFabricacaoAndModeloAndPreco(motocicleta.getAnoFabricacao(),
              motocicleta.getModelo(), motocicleta.getPreco());
      if(carroExiste){
         return null;
      } else {
         return motocicletaRepository.save(motocicleta);
      }
   }
   @Override
   public Motocicleta atualizar(Motocicleta motocicleta, Long id) {
      if(motocicletaRepository.existsById(id)){
         motocicleta.setId(id);
         return motocicletaRepository.save(motocicleta);
      } else {
         return null;
      }
   }

   @Override
   public boolean deletar(Long id) {
      if (motocicletaRepository.existsById(id)) {
         motocicletaRepository.deleteById(id);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public List<Motocicleta> listarPorPreco() {
      return motocicletaRepository.findAll().stream()
              .sorted(Comparator.comparingDouble(Motocicleta::getPreco))
              .collect(Collectors.toList());
   }

   @Override
   public String retornaIpva(Long id) {
      return motocicletaRepository.findById(id)
              .map(motocicleta -> String.format("IPVA do Veículo: R$ %.2f", motocicleta.getPreco() * 0.035))
              .orElse(null);
   }

   @Override
   public List<Motocicleta> aplicarBlackFriday() {
      List<Motocicleta> motos = motocicletaRepository.findAll();
      for (Motocicleta moto: motos){
         moto.setPreco(moto.getPreco() - (moto.getPreco()*0.15) );
      }
      return motocicletaRepository.findAll();
   }
}
