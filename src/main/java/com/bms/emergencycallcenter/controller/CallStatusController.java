package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.CallStatusDto;
import com.bms.emergencycallcenter.service.CallStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/call-statuses")
public class CallStatusController {
    private final CallStatusService service;

    public CallStatusController(CallStatusService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createCallStatus(@RequestParam @NotNull String name) {
        service.createCallStatus(name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCallStatus(@PathVariable @NotNull String id,
                                                 @RequestParam @NotNull String name) {
        service.updateCallStatus(id, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCallStatus(@PathVariable @NotNull String id) {
        service.deleteCallStatus(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<CallStatusDto> findCallStatusByName(@PathVariable @NotNull String name) {
        return ResponseEntity.ok(service.findCallStatusByName(name));
    }

    @GetMapping
    public ResponseEntity<Set<CallStatusDto>> findAllCallStatuses() {
        return ResponseEntity.ok(service.findAllCallStatuses());
    }
}
