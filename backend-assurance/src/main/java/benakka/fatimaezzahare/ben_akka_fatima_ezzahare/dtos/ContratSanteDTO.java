package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.Client;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.Paiement;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.ContratStatus;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.NiveauCouverture;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ContratSanteDTO {
    private String id;
    private double montant;
    private double tauxCouvrement;
    private Date dateSouscription;
    private Date dateValidation;
    private int dureeContrat;
    private ContratStatus status;
    private ClientDTO client;

    private NiveauCouverture niveauCouverture;
    private int nombrePersonnes;
}
