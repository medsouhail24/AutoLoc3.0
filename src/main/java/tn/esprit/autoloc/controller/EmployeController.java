package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;
import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmployes() {
        return ResponseEntity.ok(employeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        return employeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe entity) {
        Employe created = employeService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(
            @PathVariable Long id,
            @RequestBody Employe entity) {
        return employeService.findById(id)
                .map(existing -> {
                    entity.setIdEmploye(id);
                    return ResponseEntity.ok(employeService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        if (employeService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        employeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
