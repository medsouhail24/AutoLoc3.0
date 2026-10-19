package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import java.util.List;
import java.util.Optional;

public interface IEquipementService {
    Equipement save(Equipement entity);
    List<Equipement> findAll();
    Optional<Equipement> findById(Long id);
    void deleteById(Long id);
}
