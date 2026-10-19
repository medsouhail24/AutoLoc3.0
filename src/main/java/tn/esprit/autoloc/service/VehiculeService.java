package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class VehiculeService implements IVehiculeService {
    private final VehiculeRepository repository;

    @Override
    public Vehicule save(Vehicule entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicule> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vehicule> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
