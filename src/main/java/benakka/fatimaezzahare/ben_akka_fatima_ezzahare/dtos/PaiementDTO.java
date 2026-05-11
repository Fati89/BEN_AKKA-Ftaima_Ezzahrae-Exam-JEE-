package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.ContratAssurance;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.PaiementType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class PaiementDTO {

    public long id;
    public Date datePaiement;
    private double montant;
    private PaiementType paiementType;
    private ContratDTO contrat;
}