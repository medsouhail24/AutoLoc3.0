package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;
import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EquipementController {

    private final IEquipementService equipementService;

    @GetMapping
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        return ResponseEntity.ok(equipementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        return equipementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipement> createEquipement(@RequestBody Equipement entity) {
        Equipement created = equipementService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(
            @PathVariable Long id,
            @RequestBody Equipement entity) {
        return equipementService.findById(id)
                .map(existing -> {
                    entity.setIdEquipement(id);
                    return ResponseEntity.ok(equipementService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        if (equipementService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        equipementService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
