package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.PhoneNumberStatusDto;
import com.bms.emergencycallcenter.service.PhoneNumberStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/phone-number-statuses")
public class PhoneNumberStatusController {
    private final PhoneNumberStatusService service;

    public PhoneNumberStatusController(PhoneNumberStatusService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createPhoneNumberStatus(@RequestParam @NotNull String name) {
        service.createPhoneNumberStatus(name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePhoneNumberStatus(@PathVariable @NotNull String id,
                                                        @RequestParam @NotNull String name) {
        service.updatePhoneNumberStatus(id, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoneNumberStatus(@PathVariable @NotNull String id) {
        service.deletePhoneNumberStatus(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<PhoneNumberStatusDto> findPhoneNumberStatusByName(@PathVariable @NotNull String name) {
        return ResponseEntity.ok(service.findPhoneNumberStatusByName(name));
    }

    @GetMapping
    public ResponseEntity<Set<PhoneNumberStatusDto>> findAllPhoneNumberStatuses() {
        return ResponseEntity.ok(service.findAllPhoneNumberStatuses());
    }
}
