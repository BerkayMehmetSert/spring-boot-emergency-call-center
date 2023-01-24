package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.CallDto;
import com.bms.emergencycallcenter.request.call.CreateCallRequest;
import com.bms.emergencycallcenter.service.CallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/v1/calls")
public class CallController {
    private final CallService service;

    public CallController(CallService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createCall(@RequestBody @Valid CreateCallRequest request) {
        service.createCall(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCall(@PathVariable String id) {
        service.deleteCall(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/operator")
    public ResponseEntity<Set<CallDto>> findCallsByOperatorId(@RequestParam String id) {
        return ResponseEntity.ok(service.findCallsByOperatorId(id));
    }

    @GetMapping("/phone-number")
    public ResponseEntity<Set<CallDto>> findCallsByPhoneNumber(@RequestParam String number) {
        return ResponseEntity.ok(service.findCallsByPhoneNumber(number));
    }

    @GetMapping("/status")
    public ResponseEntity<Set<CallDto>> findCallsByStatus(@RequestParam String name) {
        return ResponseEntity.ok(service.findCallsByStatus(name));
    }

    @GetMapping("/city")
    public ResponseEntity<Set<CallDto>> findCallsByCity(@RequestParam String name) {
        return ResponseEntity.ok(service.findCallsByCity(name));
    }

    @GetMapping
    public ResponseEntity<Set<CallDto>> findAllCalls() {
        return ResponseEntity.ok(service.findAllCalls());
    }
}
