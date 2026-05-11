package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.ContratStatus;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.TypeLogement;
import lombok.Data;

import java.util.Date;

@Data
public class ContratAutomobileDTO {
    private String id;
    private double montant;
    private double tauxCouvrement;
    private Date dateSouscription;
    private Date dateValidation;
    private int dureeContrat;
    private ContratStatus status;
    private ClientDTO client;

    private String numeroImmatriculation;
    private String marque;
    private String model;
}
