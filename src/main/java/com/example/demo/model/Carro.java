package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Carro extends Veiculo{

  private double capPortaMalas;

  public Carro(Long id, int anoFabricacao, String fabricante, String modelo, double preco, double capPortaMalas) {
    super(id, anoFabricacao, fabricante, modelo, preco);
    this.capPortaMalas = capPortaMalas;
  }
  public Carro(double capPortaMalas) {
    this.capPortaMalas = capPortaMalas;
  }

  public Carro() {
  }

  public double getCapPortaMalas() {
    return capPortaMalas;
  }

  public void setCapPortaMalas(double capPortaMalas) {
    this.capPortaMalas = capPortaMalas;
  }


}
