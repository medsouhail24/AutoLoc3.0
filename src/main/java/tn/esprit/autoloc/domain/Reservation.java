package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.domain.enums.StatutReservation;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;

    @OneToOne(mappedBy = "reservation", fetch = FetchType.LAZY)
    private Contrat contrat;
}
