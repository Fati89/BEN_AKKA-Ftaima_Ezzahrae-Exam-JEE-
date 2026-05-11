package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.ContratStatus;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.NiveauCouverture;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.TypeLogement;
import lombok.Data;

import java.util.Date;

@Data
public class ContratHabitationDTO {
    private String id;
    private double montant;
    private double tauxCouvrement;
    private Date dateSouscription;
    private Date dateValidation;
    private int dureeContrat;
    private ContratStatus status;
    private ClientDTO client;

    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
