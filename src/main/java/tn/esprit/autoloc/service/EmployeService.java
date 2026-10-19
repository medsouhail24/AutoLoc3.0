package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeService implements IEmployeService {
    private final EmployeRepository repository;

    @Override
    public Employe save(Employe entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employe> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employe> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
