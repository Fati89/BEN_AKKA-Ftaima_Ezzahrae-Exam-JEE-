package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.services;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos.*;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.exceptions.ClientNotFoundException;

import java.util.List;

public interface AssuarceService {


    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id) throws ClientNotFoundException;
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long clientId);
    List<ClientDTO> listClients();
    List<ClientDTO> searchClient(String keyword);


    ContratAutomobileDTO saveContratAutomobile(double montant, double tauxCouvrement, int dureeContrat, Long clientId) throws Exception;
    ContratHabitationDTO saveContratHabitation(double montant, double tauxCouvrement, int dureeContrat, Long clientId) throws Exception;
    ContratSanteDTO saveContratSante(double montant, double tauxCouvrement, int dureeContrat, Long clientId) throws Exception;

    PaiementDTO savePaiement(double montant, String contratId) throws Exception;
}
