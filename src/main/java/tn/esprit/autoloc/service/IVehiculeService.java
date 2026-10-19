package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;
import java.util.Optional;

public interface IVehiculeService {
    Vehicule save(Vehicule entity);
    List<Vehicule> findAll();
    Optional<Vehicule> findById(Long id);
    void deleteById(Long id);
}
