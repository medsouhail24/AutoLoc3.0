package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.domain.enums.ModePaiement;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;
    private BigDecimal montant;
    private LocalDate datePaiement;
    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrat_id", nullable = false)
    private Contrat contrat;
}
