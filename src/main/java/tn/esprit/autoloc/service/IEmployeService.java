package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import java.util.List;
import java.util.Optional;

public interface IEmployeService {
    Employe save(Employe entity);
    List<Employe> findAll();
    Optional<Employe> findById(Long id);
    void deleteById(Long id);
}
