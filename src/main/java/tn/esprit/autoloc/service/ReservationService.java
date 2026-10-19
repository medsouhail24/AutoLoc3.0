package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService implements IReservationService {
    private final ReservationRepository repository;

    @Override
    public Reservation save(Reservation entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reservation> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
