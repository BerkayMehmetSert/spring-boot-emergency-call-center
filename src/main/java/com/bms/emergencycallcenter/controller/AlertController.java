package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.AlertDto;
import com.bms.emergencycallcenter.request.alert.CreateAlertRequest;
import com.bms.emergencycallcenter.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/alerts")
public class AlertController {
    private final AlertService service;

    public AlertController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createAlert(@RequestBody @Valid CreateAlertRequest request) {
        service.createAlert(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/alwaysAlert")
    public ResponseEntity<Void> updateAlert(@PathVariable String id,
                                            @RequestParam @NotNull Boolean alwaysAlert) {
        service.updateAlert(id, alwaysAlert);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/emergency")
    public ResponseEntity<Void> updateAlertEmergency(@PathVariable String id,
                                                     @RequestParam @NotNull String emergencyId) {
        service.updateAlertEmergency(id, emergencyId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/catalog")
    public ResponseEntity<Void> updateAlertCatalog(@PathVariable String id,
                                                   @RequestParam @NotNull String catalogId) {
        service.updateAlertCatalog(id, catalogId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable String id) {
        service.deleteAlert(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertDto> findAlertById(@PathVariable String id) {
        return ResponseEntity.ok(service.findAlertById(id));
    }

    @GetMapping("/emergency")
    public ResponseEntity<Set<AlertDto>> findAlertsByEmergencyId(@RequestParam @NotNull String emergencyId) {
        return ResponseEntity.ok(service.findAlertsByEmergencyId(emergencyId));
    }

    @GetMapping("/catalog")
    public ResponseEntity<Set<AlertDto>> findAlertsByCatalogId(@RequestParam @NotNull String catalogId) {
        return ResponseEntity.ok(service.findAlertsByCatalogId(catalogId));
    }

    @GetMapping
    public ResponseEntity<Set<AlertDto>> findAllAlerts() {
        return ResponseEntity.ok(service.findAllAlerts());
    }
}
