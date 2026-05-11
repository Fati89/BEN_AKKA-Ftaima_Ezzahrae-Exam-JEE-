package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.Client;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}