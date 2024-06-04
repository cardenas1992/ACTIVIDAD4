package com.api.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.api.crud.models.Caramelo;
import com.api.crud.repositories.CarameloRepository;

@RestController
@RequestMapping("/api/v1/caramelos")
public class CarameloController {
    @Autowired
    private CarameloRepository carameloRepository;

    @GetMapping
    public List<Caramelo> obtenerTodosLosCaramelos() {
        return carameloRepository.findAll();
    }

    @GetMapping("/{id}")
    public Caramelo obtenerCarameloPorId(@PathVariable Long id) {
        return carameloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el caramelo con id: " + id));
    }

    @PostMapping
    public Caramelo crearCaramelo(@RequestBody Caramelo caramelo) {
        return carameloRepository.save(caramelo);
    }

    @PutMapping("/{id}")
    public Caramelo actualizarCaramelo(@PathVariable Long id, @RequestBody Caramelo carameloActualizado) {
        return carameloRepository.findById(id).map(caramelo -> {
            caramelo.setNombreCaramelo(carameloActualizado.getNombreCaramelo());
            caramelo.setSabor(carameloActualizado.getSabor());
            caramelo.setPrecio(carameloActualizado.getPrecio());
            return carameloRepository.save(caramelo);
        }).orElseThrow(() -> new RuntimeException("No se encontró el caramelo con id: " + id));
    }

    @DeleteMapping("/{id}")
    public void eliminarCaramelo(@PathVariable Long id) {
        carameloRepository.deleteById(id);
    }
}
