package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.PhoneNumberDto;
import com.bms.emergencycallcenter.request.phonenumber.CreatePhoneNumberRequest;
import com.bms.emergencycallcenter.request.phonenumber.UpdatePhoneNumberRequest;
import com.bms.emergencycallcenter.service.PhoneNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/v1/phone-numbers")
public class PhoneNumberController {
    private final PhoneNumberService service;

    public PhoneNumberController(PhoneNumberService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createPhoneNumber(@RequestBody @Valid CreatePhoneNumberRequest request) {
        service.createPhoneNumber(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePhoneNumber(@PathVariable String id,
                                                  @RequestBody @Valid UpdatePhoneNumberRequest request) {
        service.updatePhoneNumber(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoneNumber(@PathVariable String id) {
        service.deletePhoneNumber(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{number}")
    public ResponseEntity<PhoneNumberDto> findPhoneNumberByNumber(@PathVariable String number) {
        return ResponseEntity.ok(service.findPhoneNumberByNumber(number));
    }

    @GetMapping
    public ResponseEntity<Set<PhoneNumberDto>> findAllPhoneNumbers() {
        return ResponseEntity.ok(service.findAllPhoneNumbers());
    }
}
