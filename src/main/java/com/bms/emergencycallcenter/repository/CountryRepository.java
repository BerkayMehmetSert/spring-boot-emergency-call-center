package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {
    Optional<Country> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}