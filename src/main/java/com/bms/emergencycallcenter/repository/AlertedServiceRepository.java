package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.AlertedService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AlertedServiceRepository extends JpaRepository<AlertedService, String> {
    Set<AlertedService> findByEmergency_Id(String emergencyId);

    Set<AlertedService> findByAction_Id(String actionId);
}