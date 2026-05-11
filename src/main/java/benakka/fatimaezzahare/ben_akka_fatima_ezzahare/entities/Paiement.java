package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.PaiementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public Date datePaiement;
    private double montant;
    @Enumerated(EnumType.STRING)
    private PaiementType paiementType;
    @ManyToOne
    private ContratAssurance contrat;
}
