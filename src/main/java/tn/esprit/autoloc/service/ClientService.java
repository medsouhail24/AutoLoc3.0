package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService implements IClientService {
    private final ClientRepository repository;

    @Override
    public Client save(Client entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
