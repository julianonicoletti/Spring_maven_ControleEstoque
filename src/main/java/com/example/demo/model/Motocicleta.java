package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Motocicleta extends Veiculo{
   @NotNull
   @Column(nullable = false)
   @Min(value=1)
   private int quantRodas;

   public Motocicleta(Long id, int anoFabricacao, String fabricante, String modelo, double preco, int quantRodas) {
      super(id, anoFabricacao, fabricante, modelo, preco);
      this.quantRodas = quantRodas;
   }

   public Motocicleta(int quantRodas) {
      this.quantRodas = quantRodas;
   }

   public Motocicleta() {
   }

   public int getQuantRodas() {
      return quantRodas;
   }

   public void setQuantRodas(int quantRodas) {
      this.quantRodas = quantRodas;
   }
}
