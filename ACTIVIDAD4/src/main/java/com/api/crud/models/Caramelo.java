package com.api.crud.models;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity

public class Caramelo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String nombreCaramelo;
  private String sabor;
  private BigDecimal precio;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombreCaramelo() {
    return nombreCaramelo;
  }

  public void setNombreCaramelo(String nombreCaramelo) {
    this.nombreCaramelo = nombreCaramelo;
  }

  public String getSabor() {
    return sabor;
  }

  public void setSabor(String sabor) {
    this.sabor = sabor;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

}
