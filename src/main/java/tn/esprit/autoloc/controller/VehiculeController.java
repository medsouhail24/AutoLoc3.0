package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        return ResponseEntity.ok(vehiculeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        return vehiculeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vehicule> createVehicule(@RequestBody Vehicule entity) {
        Vehicule created = vehiculeService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(
            @PathVariable Long id,
            @RequestBody Vehicule entity) {
        return vehiculeService.findById(id)
                .map(existing -> {
                    entity.setIdVehicule(id);
                    return ResponseEntity.ok(vehiculeService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        if (vehiculeService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
