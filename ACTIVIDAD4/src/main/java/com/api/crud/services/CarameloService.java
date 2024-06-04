package com.api.crud.services;

import com.api.crud.models.Caramelo;
import com.api.crud.repositories.CarameloRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarameloService {

  @Autowired
  private CarameloRepository carameloRepository;

  public List<Caramelo> getAllCaramelos() {
    return carameloRepository.findAll();
  }

  public Caramelo getCarameloById(Long id) {
    return carameloRepository.findById(id).orElse(null);
  }

  public Caramelo saveCaramelo(Caramelo caramelo) {
    return carameloRepository.save(caramelo);
  }

  public void deleteCaramelo(Long id) {
    carameloRepository.deleteById(id);
  }
}