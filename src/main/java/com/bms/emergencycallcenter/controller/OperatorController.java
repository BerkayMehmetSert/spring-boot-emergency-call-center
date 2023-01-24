package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.OperatorDto;
import com.bms.emergencycallcenter.request.operator.CreateOperatorRequest;
import com.bms.emergencycallcenter.request.operator.UpdateOperatorRequest;
import com.bms.emergencycallcenter.service.OperatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/operators")
public class OperatorController {
    private final OperatorService service;

    public OperatorController(OperatorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createOperator(@RequestBody @Valid CreateOperatorRequest request) {
        service.createOperator(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOperator(@PathVariable String id,
                                               @RequestBody @Valid UpdateOperatorRequest request) {
        service.updateOperator(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperator(@PathVariable String id) {
        service.deleteOperator(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<OperatorDto> findOperatorByName(@RequestParam @NotNull String firstName,
                                                          @RequestParam @NotNull String lastName) {
        return ResponseEntity.ok(service.findOperatorByName(firstName, lastName));
    }

    @GetMapping
    public ResponseEntity<Set<OperatorDto>> findAllOperators() {
        return ResponseEntity.ok(service.findAllOperators());
    }
}
