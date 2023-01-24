package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmergencyRepository extends JpaRepository<Emergency, String> {
    boolean existsByNameIgnoreCase(String name);

    Optional<Emergency> findByNameIgnoreCase(String name);
}