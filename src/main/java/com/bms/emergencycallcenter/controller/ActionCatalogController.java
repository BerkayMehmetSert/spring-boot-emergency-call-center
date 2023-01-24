package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.ActionCatalogDto;
import com.bms.emergencycallcenter.service.ActionCatalogService;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1/action-catalogs")
public class ActionCatalogController {
    private final ActionCatalogService service;

    public ActionCatalogController(ActionCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createActionCatalog(@RequestParam @NotNull String name) {
        service.createActionCatalog(name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateActionCatalog(@PathVariable @NotNull String id,
                                                    @RequestParam @NotNull String name) {
        service.updateActionCatalog(id, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActionCatalog(@PathVariable @NotNull String id) {
        service.deleteActionCatalog(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<ActionCatalogDto> findActionCatalogByName(@PathVariable @NotNull String name) {
        return ResponseEntity.ok(service.findActionCatalogByName(name));
    }

    @GetMapping
    public ResponseEntity<Set<ActionCatalogDto>> findAllActionCatalogs() {
        return ResponseEntity.ok(service.findAllActionCatalogs());
    }
}
