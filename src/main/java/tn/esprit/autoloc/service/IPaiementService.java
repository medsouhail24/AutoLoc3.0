package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import java.util.List;
import java.util.Optional;

public interface IPaiementService {
    Paiement save(Paiement entity);
    List<Paiement> findAll();
    Optional<Paiement> findById(Long id);
    void deleteById(Long id);
}
