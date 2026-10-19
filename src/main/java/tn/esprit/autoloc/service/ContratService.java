package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ContratService implements IContratService {
    private final ContratRepository repository;

    @Override
    public Contrat save(Contrat entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contrat> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contrat> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
