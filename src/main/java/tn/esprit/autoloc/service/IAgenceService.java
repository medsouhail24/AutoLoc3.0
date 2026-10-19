package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import java.util.List;
import java.util.Optional;

public interface IAgenceService {
    Agence save(Agence entity);
    List<Agence> findAll();
    Optional<Agence> findById(Long id);
    void deleteById(Long id);
}
