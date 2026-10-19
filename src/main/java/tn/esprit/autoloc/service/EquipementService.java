package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EquipementService implements IEquipementService {
    private final EquipementRepository repository;

    @Override
    public Equipement save(Equipement entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipement> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Equipement> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
