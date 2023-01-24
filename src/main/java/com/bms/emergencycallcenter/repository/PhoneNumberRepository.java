package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String> {
    Optional<PhoneNumber> findByNumber(String number);
    boolean existsByNumber(String number);
}