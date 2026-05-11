package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.ContratStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
public class ContratAssurance {
    @Id
    private String id;
    private double montant;
    private double tauxCouvrement;
    private Date dateSouscription;
    private Date dateValidation;
    private int dureeContrat;
    @Enumerated(EnumType.STRING)
    private ContratStatus status;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "contrat", fetch = FetchType.EAGER)
    private List<Paiement> paiements;
}