package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client entity) {
        Client created = clientService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable Long id,
            @RequestBody Client entity) {
        return clientService.findById(id)
                .map(existing -> {
                    entity.setIdClient(id);
                    return ResponseEntity.ok(clientService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
