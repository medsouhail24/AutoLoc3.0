package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PaiementService implements IPaiementService {
    private final PaiementRepository repository;

    @Override
    public Paiement save(Paiement entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paiement> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Paiement> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
