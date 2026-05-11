package benakka.fatimaezzahare.ben_akka_fatima_ezzahare.web;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.dtos.ClientDTO;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.exceptions.ClientNotFoundException;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.services.AssuarceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ClientController {

    private AssuarceService assuarceService;

    @GetMapping("/clients")
    public List<ClientDTO> clients(){
        return assuarceService.listClients();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable(name = "id") Long idClient) throws ClientNotFoundException {
        return assuarceService.getClient(idClient);
    }

    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO){
        return assuarceService.saveClient(clientDTO);
    }

    @PutMapping("/clients/{idClient}")
    public ClientDTO updateClient(@PathVariable Long idClient, @RequestBody ClientDTO clientDTO){
        clientDTO.setId(idClient);
        return assuarceService.updateClient(clientDTO);
    }

    @GetMapping("/clients/search")
    public List<ClientDTO> searchClients(@RequestParam(name = "keyword", defaultValue = "") String keyword ){
        return assuarceService.searchClient(keyword);
    }

    @DeleteMapping("/clients/{idClient}")
    public void deleteClient(@PathVariable Long idClient){
        assuarceService.deleteClient(idClient);
    }
}
