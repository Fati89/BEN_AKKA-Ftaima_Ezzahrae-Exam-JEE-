package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.mapper;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos.*;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    public PaiementDTO fromPaiement(Paiement paiement) {
        PaiementDTO paiementDTO = new PaiementDTO();
        BeanUtils.copyProperties(paiement, paiementDTO);
        ContratDTO contratDTO = new ContratDTO();
        contratDTO.setType(paiement.getContrat().getClass().getSimpleName());
        paiementDTO.setContrat(contratDTO);
        return paiementDTO;
    }

    public Paiement fromPaiementDTO(PaiementDTO paiementDTO) {
        Paiement paiement = new Paiement();
        BeanUtils.copyProperties(paiementDTO, paiement);
        return paiement;
    }


    public ContratAutomobileDTO fromContartAutomobile(ContartAutomobile contartAutomobile) {
        ContratAutomobileDTO dto = new ContratAutomobileDTO();
        BeanUtils.copyProperties(contartAutomobile, dto);
        dto.setClient(fromClient(contartAutomobile.getClient()));
        return dto;
    }

    public ContartAutomobile fromContratAutomobileDTO(ContratAutomobileDTO dto) {
        ContartAutomobile contartAutomobile = new ContartAutomobile();
        BeanUtils.copyProperties(dto, contartAutomobile);
        contartAutomobile.setClient(fromClientDTO(dto.getClient()));
        return contartAutomobile;
    }


    public ContratHabitationDTO fromContartHabitation(ContartHabitation contartHabitation) {
        ContratHabitationDTO dto = new ContratHabitationDTO();
        BeanUtils.copyProperties(contartHabitation, dto);
        dto.setClient(fromClient(contartHabitation.getClient()));
        return dto;
    }

    public ContartHabitation fromContratHabitationDTO(ContratHabitationDTO dto) {
        ContartHabitation contartHabitation = new ContartHabitation();
        BeanUtils.copyProperties(dto, contartHabitation);
        contartHabitation.setClient(fromClientDTO(dto.getClient()));
        return contartHabitation;
    }


    public ContratSanteDTO fromContartSante(ContartSante contartSante) {
        ContratSanteDTO dto = new ContratSanteDTO();
        BeanUtils.copyProperties(contartSante, dto);
        dto.setClient(fromClient(contartSante.getClient()));
        return dto;
    }

    public ContartSante fromContratSanteDTO(ContratSanteDTO dto) {
        ContartSante contartSante = new ContartSante();
        BeanUtils.copyProperties(dto, contartSante);
        contartSante.setClient(fromClientDTO(dto.getClient()));
        return contartSante;
    }
}
