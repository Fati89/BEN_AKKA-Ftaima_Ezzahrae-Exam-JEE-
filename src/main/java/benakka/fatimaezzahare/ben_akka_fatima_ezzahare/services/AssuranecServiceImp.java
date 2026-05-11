package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.services;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos.*;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.*;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.ContratStatus;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.exceptions.ClientNotFoundException;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.mapper.Mapper;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories.ClientRepository;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories.ContratRepository;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories.PaiementRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AssuranecServiceImp implements AssuarceService {

    private ClientRepository clientRepository;
    private ContratRepository contratRepository;
    private PaiementRepository paiementRepository;
    private Mapper dtoMapper;


    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO getClient(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));
        return dtoMapper.fromClient(client);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(dtoMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> searchClient(String keyword) {
        return clientRepository.findAll().stream()
                .filter(c -> c.getNom().contains(keyword) || c.getEmail().contains(keyword))
                .map(dtoMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ContratAutomobileDTO saveContratAutomobile(double montant, double tauxCouvrement, int dureeContrat, Long clientId) throws Exception {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new Exception("Client not found with id: " + clientId));
        ContartAutomobile contrat = new ContartAutomobile();
        contrat.setId(UUID.randomUUID().toString());
        contrat.setMontant(montant);
        contrat.setTauxCouvrement(tauxCouvrement);
        contrat.setDureeContrat(dureeContrat);
        contrat.setDateSouscription(new Date());
        contrat.setStatus(ContratStatus.En_cours);
        contrat.setClient(client);
        ContartAutomobile saved = (ContartAutomobile) contratRepository.save(contrat);
        return dtoMapper.fromContartAutomobile(saved);
    }

    @Override
    public ContratHabitationDTO saveContratHabitation(double montant, double tauxCouvrement, int dureeContrat, Long clientId) throws Exception {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new Exception("Client not found with id: " + clientId));
        ContartHabitation contrat = new ContartHabitation();
        contrat.setId(UUID.randomUUID().toString());
        contrat.setMontant(montant);
        contrat.setTauxCouvrement(tauxCouvrement);
        contrat.setDureeContrat(dureeContrat);
        contrat.setDateSouscription(new Date());
        contrat.setStatus(ContratStatus.En_cours);
        contrat.setClient(client);
        ContartHabitation saved = (ContartHabitation) contratRepository.save(contrat);
        return dtoMapper.fromContartHabitation(saved);
    }

    @Override
    public ContratSanteDTO saveContratSante(double montant, double tauxCouvrement, int dureeContrat, Long clientId) throws Exception {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new Exception("Client not found with id: " + clientId));
        ContartSante contrat = new ContartSante();
        contrat.setId(UUID.randomUUID().toString());
        contrat.setMontant(montant);
        contrat.setTauxCouvrement(tauxCouvrement);
        contrat.setDureeContrat(dureeContrat);
        contrat.setDateSouscription(new Date());
        contrat.setStatus(ContratStatus.En_cours);
        contrat.setClient(client);
        ContartSante saved = (ContartSante) contratRepository.save(contrat);
        return dtoMapper.fromContartSante(saved);
    }

    @Override
    public PaiementDTO savePaiement(double montant, String contratId) throws Exception {
        ContratAssurance contrat = contratRepository.findById(contratId)
                .orElseThrow(() -> new Exception("Contrat not found with id: " + contratId));
        Paiement paiement = new Paiement();
        paiement.setDatePaiement(new Date());
        paiement.setMontant(montant);
        paiement.setContrat(contrat);
        Paiement saved = paiementRepository.save(paiement);
        return dtoMapper.fromPaiement(saved);
    }

}
