package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    Reservation save(Reservation entity);
    List<Reservation> findAll();
    Optional<Reservation> findById(Long id);
    void deleteById(Long id);
}
