package com.bms.emergencycallcenter.controller;

import com.bms.emergencycallcenter.dto.ActionDto;
import com.bms.emergencycallcenter.request.action.CreateActionRequest;
import com.bms.emergencycallcenter.request.action.UpdateActionRequest;
import com.bms.emergencycallcenter.service.ActionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/v1/actions")
public class ActionController {
    private final ActionService service;

    public ActionController(ActionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createAction(@RequestBody @Valid CreateActionRequest request) {
        service.createAction(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAction(@PathVariable String id,
                                             @RequestBody @Valid UpdateActionRequest request) {
        service.updateAction(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable String id) {
        service.deleteAction(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/catalog")
    public ResponseEntity<Set<ActionDto>> findActionsByCatalogId(@RequestParam @NotNull String catalogId) {
        return ResponseEntity.ok(service.findActionsByCatalogId(catalogId));
    }

    @GetMapping("/call")
    public ResponseEntity<Set<ActionDto>> findActionsByCallId(@RequestParam @NotNull String callId) {
        return ResponseEntity.ok(service.findActionsByCallId(callId));
    }

    @GetMapping
    public ResponseEntity<Set<ActionDto>> findAllActions() {
        return ResponseEntity.ok(service.findAllActions());
    }
}
