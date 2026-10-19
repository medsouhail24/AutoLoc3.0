package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;
import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAllMaintenances() {
        return ResponseEntity.ok(maintenanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Maintenance> createMaintenance(@RequestBody Maintenance entity) {
        Maintenance created = maintenanceService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(
            @PathVariable Long id,
            @RequestBody Maintenance entity) {
        return maintenanceService.findById(id)
                .map(existing -> {
                    entity.setIdMaintenance(id);
                    return ResponseEntity.ok(maintenanceService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        if (maintenanceService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        maintenanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
