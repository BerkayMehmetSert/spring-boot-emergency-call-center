package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CallRepository extends JpaRepository<Call, String> {
    Set<Call> findByStatus_Name(String name);
    Set<Call> findByPhoneNumber_Number(String number);
    Set<Call> findByOperator_Id(String id);
    Set<Call> findByCity_Name(String cityName);
}