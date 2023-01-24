package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AlertRepository extends JpaRepository<Alert, String> {
    Set<Alert> findByCatalog_Id(String id);
    Set<Alert> findByEmergency_Id(String id);
}