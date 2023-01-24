package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.CityDto;
import com.bms.emergencycallcenter.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/cities")
public class CityController {
    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createCity(@RequestParam @NotNull String name,
                                           @RequestParam @NotNull String countryId) {
        service.createCity(name, countryId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCityName(@PathVariable @NotNull String id,
                                               @RequestParam @NotNull String name) {
        service.updateCityName(id, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable @NotNull String id) {
        service.deleteCity(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<CityDto> findCityByName(@PathVariable @NotNull String name) {
        return ResponseEntity.ok(service.findCityByName(name));
    }

    @GetMapping
    public ResponseEntity<Set<CityDto>> findAllCities() {
        return ResponseEntity.ok(service.findAllCities());
    }
}
