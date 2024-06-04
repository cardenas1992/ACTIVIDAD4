package com.api.crud.models;

import jakarta.persistence.*;

@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombreCLiente;
  private String apellidoCliente;
  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombreCLiente() {
    return nombreCLiente;
  }

  public void setNombreCLiente(String nombreCLiente) {
    this.nombreCLiente = nombreCLiente;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getApellidoCliente() {
    return apellidoCliente;
  }

  public void setApellidoCliente(String apellidoCliente) {
    this.apellidoCliente = apellidoCliente;
  }

}
