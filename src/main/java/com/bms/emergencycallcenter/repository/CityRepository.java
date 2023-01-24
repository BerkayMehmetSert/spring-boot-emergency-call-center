package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, String> {
    Optional<City> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}