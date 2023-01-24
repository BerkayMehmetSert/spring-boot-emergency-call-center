package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.AlertedServiceDto;
import com.bms.emergencycallcenter.request.alertedservice.CreateAlertedServiceRequest;
import com.bms.emergencycallcenter.service.AlertedServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/v1/alerted-services")
public class AlertedServiceController {
    private final AlertedServiceService service;

    public AlertedServiceController(AlertedServiceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createAlertedService(@RequestBody @Valid CreateAlertedServiceRequest request) {
        service.createAlertedService(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlertedService(@PathVariable String id) {
        service.deleteAlertedService(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/emergency")
    public ResponseEntity<Set<AlertedServiceDto>> findAlertedServicesByEmergencyId(@RequestParam String emergencyId) {
        return ResponseEntity.ok(service.findAlertedServicesByEmergencyId(emergencyId));
    }

    @GetMapping("/action")
    public ResponseEntity<Set<AlertedServiceDto>> findAlertedServicesByActionId(@RequestParam String actionId) {
        return ResponseEntity.ok(service.findAlertedServicesByActionId(actionId));
    }

    @GetMapping
    public ResponseEntity<Set<AlertedServiceDto>> findAllAlertedServices() {
        return ResponseEntity.ok(service.findAllAlertedServices());
    }
}
