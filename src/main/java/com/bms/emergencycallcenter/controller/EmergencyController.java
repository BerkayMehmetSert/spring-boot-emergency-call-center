package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.EmergencyDto;
import com.bms.emergencycallcenter.request.emergency.CreateEmergencyRequest;
import com.bms.emergencycallcenter.service.EmergencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/emergencies")
public class EmergencyController {
    private final EmergencyService service;

    public EmergencyController(EmergencyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createEmergency(@RequestBody @Valid CreateEmergencyRequest request) {
        service.createEmergency(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Void> updateEmergencyName(@PathVariable String id,
                                                    @NotNull @RequestBody String name) {
        service.updateEmergencyName(id, name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/details")
    public ResponseEntity<Void> updateEmergencyDetails(@PathVariable String id,
                                                       @NotNull @RequestBody String details) {
        service.updateEmergencyDetails(id, details);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergency(@PathVariable String id) {
        service.deleteEmergency(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<EmergencyDto> findEmergencyByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findEmergencyByName(name));
    }

    @GetMapping
    public ResponseEntity<Set<EmergencyDto>> findAllEmergencies() {
        return ResponseEntity.ok(service.findAllEmergencies());
    }
}
