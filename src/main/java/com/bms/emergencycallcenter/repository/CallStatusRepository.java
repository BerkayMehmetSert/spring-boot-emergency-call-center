package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.CallStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CallStatusRepository extends JpaRepository<CallStatus, String> {
    boolean existsByNameIgnoreCase(String name);

    Optional<CallStatus> findByNameIgnoreCase(String name);
}