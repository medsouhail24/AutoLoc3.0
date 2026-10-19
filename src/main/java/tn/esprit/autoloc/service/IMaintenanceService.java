package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import java.util.List;
import java.util.Optional;

public interface IMaintenanceService {
    Maintenance save(Maintenance entity);
    List<Maintenance> findAll();
    Optional<Maintenance> findById(Long id);
    void deleteById(Long id);
}
