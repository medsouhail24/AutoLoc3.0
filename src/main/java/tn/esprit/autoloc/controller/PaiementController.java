package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        return ResponseEntity.ok(paiementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        return paiementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement entity) {
        Paiement created = paiementService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(
            @PathVariable Long id,
            @RequestBody Paiement entity) {
        return paiementService.findById(id)
                .map(existing -> {
                    entity.setIdPaiement(id);
                    return ResponseEntity.ok(paiementService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        if (paiementService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        paiementService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
