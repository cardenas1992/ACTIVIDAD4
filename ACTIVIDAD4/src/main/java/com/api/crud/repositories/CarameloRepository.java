package com.api.crud.repositories;

import com.api.crud.models.Caramelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarameloRepository extends JpaRepository<Caramelo, Long> {
}
