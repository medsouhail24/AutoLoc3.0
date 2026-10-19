
package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AgenceController {

    private final IAgenceService agenceService;

    // Récupérer toutes les agences
    @GetMapping
    public ResponseEntity<List<Agence>> getAllAgences() {
        return ResponseEntity.ok(agenceService.findAll());
    }

    // Récupérer une agence par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable Long id) {
        return agenceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ajouter une agence
    @PostMapping
    public ResponseEntity<Agence> createAgence(@RequestBody Agence agence) {
        Agence nouvelleAgence = agenceService.save(agence);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleAgence);
    }

    // Modifier une agence
    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgence(
            @PathVariable Long id,
            @RequestBody Agence agence) {

        return agenceService.findById(id)
                .map(agenceExistante -> {
                    agence.setIdAgence(id);
                    Agence agenceModifiee = agenceService.save(agence);
                    return ResponseEntity.ok(agenceModifiee);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer une agence
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        if (agenceService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        agenceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
