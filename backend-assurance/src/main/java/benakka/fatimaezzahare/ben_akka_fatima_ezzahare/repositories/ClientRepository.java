package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.Client;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.ContratAssurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    List<ContratAssurance> getCleintByNameContains(String keyword);
}