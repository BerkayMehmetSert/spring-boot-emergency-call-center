package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.CountryDto;
import com.bms.emergencycallcenter.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/countries")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createCountry(@RequestParam @NotNull String name) {
        service.createCountry(name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCountry(@PathVariable @NotNull String id,
                                              @RequestParam @NotNull String name) {
        service.updateCountry(id, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable @NotNull String id) {
        service.deleteCountry(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<CountryDto> findCountryByName(@PathVariable @NotNull String name) {
        return ResponseEntity.ok(service.findCountryByName(name));
    }

    @GetMapping
    public ResponseEntity<Set<CountryDto>> findAllCountries() {
        return ResponseEntity.ok(service.findAllCountries());
    }
}
