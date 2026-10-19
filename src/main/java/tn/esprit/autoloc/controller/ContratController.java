package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContratController {

    private final IContratService contratService;

    @GetMapping
    public ResponseEntity<List<Contrat>> getAllContrats() {
        return ResponseEntity.ok(contratService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable Long id) {
        return contratService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contrat> createContrat(@RequestBody Contrat entity) {
        Contrat created = contratService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> updateContrat(
            @PathVariable Long id,
            @RequestBody Contrat entity) {
        return contratService.findById(id)
                .map(existing -> {
                    entity.setIdContrat(id);
                    return ResponseEntity.ok(contratService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        if (contratService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        contratService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
