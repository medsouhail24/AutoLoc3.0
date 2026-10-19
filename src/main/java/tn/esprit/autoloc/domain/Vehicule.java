package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.domain.enums.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;
    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vehicule_equipement",
        joinColumns = @JoinColumn(name = "vehicule_id"),
        inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    private Set<Equipement> equipements = new HashSet<>();

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Maintenance> maintenances = new ArrayList<>();
}
