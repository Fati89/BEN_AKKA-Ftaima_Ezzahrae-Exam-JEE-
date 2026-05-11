package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.NiveauCouverture;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.TypeLogement;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CS")
@Data @NoArgsConstructor @AllArgsConstructor
public class ContartSante extends ContratAssurance{
    private NiveauCouverture niveauCouverture;
    private int nombrePersonnes;
}
