package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.ActionCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActionCatalogRepository extends JpaRepository<ActionCatalog, String> {
    Optional<ActionCatalog> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}