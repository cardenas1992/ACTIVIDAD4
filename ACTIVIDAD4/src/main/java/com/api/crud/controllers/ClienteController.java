package com.api.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.api.crud.models.Cliente;
import com.api.crud.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping
  public List<Cliente> obtenerTodosLosClientes() {
    return clienteRepository.findAll();
  }

  @GetMapping("/{id}")
  public Cliente obtenerClientePorId(@PathVariable Long id) {
    return clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el cliente con id: " + id));
  }

  @PostMapping("/{id}")
  public Cliente crearCliente(@RequestBody Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @PutMapping("/{id}")
  public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
    return clienteRepository.findById(id).map(cliente -> {
      cliente.setNombreCLiente(clienteActualizado.getNombreCLiente());
      cliente.setApellidoCliente(clienteActualizado.getApellidoCliente());
      cliente.setEmail(clienteActualizado.getEmail());
      return clienteRepository.save(cliente);
    }).orElseThrow(() -> new RuntimeException("No se encontró el cliente con id: " + id));
  }

  @DeleteMapping("/{id}")
  public void eliminarCliente(@PathVariable Long id) {
    clienteRepository.deleteById(id);
  }
}
