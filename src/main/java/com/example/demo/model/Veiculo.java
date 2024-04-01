package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotNull
   @Column(nullable = false)
   @Size(min = 4, max = 4)
   private int anoFabricacao;
   @NotNull
   @Column(nullable = false)
   private String modelo;

   @NotNull
   @Column(nullable = false)
   private double preco;


   public Veiculo(Long id, int anoFabricacao, String fabricante, String modelo, double preco) {
      this.id = id;
      this.anoFabricacao = anoFabricacao;
      this.modelo = modelo;
      this.preco  = preco;
   }

   public Veiculo() {
   }

   public double getPreco() {
      return preco;
   }

   public void setPreco(double preco) {
      this.preco = preco;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public int getAnoFabricacao() {
      return anoFabricacao;
   }

   public void setAnoFabricacao(int anoFabricacao) {
      this.anoFabricacao = anoFabricacao;
   }

   public String getModelo() {
      return modelo;
   }

   public void setModelo(String modelo) {
      this.modelo = modelo;
   }
}
