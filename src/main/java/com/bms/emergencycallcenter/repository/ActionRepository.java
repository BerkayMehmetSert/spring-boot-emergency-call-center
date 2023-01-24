package com.bms.emergencycallcenter.repository;

import com.bms.emergencycallcenter.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ActionRepository extends JpaRepository<Action, String> {
    Set<Action> findByCatalog_Id(String catalogId);

    Set<Action> findByCall_Id(String callId);
}