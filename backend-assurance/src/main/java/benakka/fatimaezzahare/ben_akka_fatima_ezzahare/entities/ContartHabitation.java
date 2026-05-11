package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.TypeLogement;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CH")
@Data @NoArgsConstructor @AllArgsConstructor
public class ContartHabitation extends ContratAssurance{
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
