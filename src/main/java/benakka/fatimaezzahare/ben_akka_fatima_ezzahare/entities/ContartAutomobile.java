package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CA")
@Data @NoArgsConstructor @AllArgsConstructor
public class ContartAutomobile extends ContratAssurance{
    private String numeroImmatriculation;
    private String marque;
    private String model;
}

