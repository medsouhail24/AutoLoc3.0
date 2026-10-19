package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MaintenanceService implements IMaintenanceService {
    private final MaintenanceRepository repository;

    @Override
    public Maintenance save(Maintenance entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maintenance> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Maintenance> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
