package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReservationController {

    private final IReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation entity) {
        Reservation created = reservationService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(
            @PathVariable Long id,
            @RequestBody Reservation entity) {
        return reservationService.findById(id)
                .map(existing -> {
                    entity.setIdReservation(id);
                    return ResponseEntity.ok(reservationService.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        if (reservationService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
