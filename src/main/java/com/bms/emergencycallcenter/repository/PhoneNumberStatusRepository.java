package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.PhoneNumberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneNumberStatusRepository extends JpaRepository<PhoneNumberStatus, String> {
    Optional<PhoneNumberStatus> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}