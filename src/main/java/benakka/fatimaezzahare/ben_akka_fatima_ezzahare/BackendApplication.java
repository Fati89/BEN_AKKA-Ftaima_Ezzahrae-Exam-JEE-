package benakka.fatimaezzahare.ben_akka_fatima_ezzahare;

import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.entities.*;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.ContratStatus;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.NiveauCouverture;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.PaiementType;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.enums.TypeLogement;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories.ClientRepository;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories.ContratRepository;
import benakka.fatimaezzahare.ben_akka_fatima_ezzahare.repositories.PaiementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;
import java.util.UUID;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start (ClientRepository clientRepository,
                             ContratRepository contratRepository,
                             PaiementRepository paiementRepository) {
        return args -> {

            Stream.of("Mohammed", "Youssef", "Farid").forEach(name->{
                Client customer = new Client();
                customer.setNom(name);
                customer.setEmail(name+"@gmail.com");
                clientRepository.save(customer);
            });

            clientRepository.findAll().forEach(cli->{
                ContartSante contratSante = new ContartSante();
                contratSante.setId (UUID.randomUUID().toString());
                contratSante.setDateSouscription(new Date());
                contratSante.setDateValidation(new Date());
                contratSante.setDureeContrat(5);
                contratSante.setMontant (Math.random()*90000);
                contratSante.setTauxCouvrement (0.3);
                contratSante.setStatus (ContratStatus.Valide);
                contratSante.setNiveauCouverture (NiveauCouverture.Basique);
                contratSante.setNombrePersonnes (3);
                contratSante.setClient (cli);
                contratRepository.save(contratSante);

                ContartHabitation contartHabitation = new ContartHabitation();
                contartHabitation.setId (UUID.randomUUID().toString());
                contartHabitation.setDateSouscription(new Date());
                contartHabitation.setDateValidation(new Date());
                contartHabitation.setDureeContrat(5);
                contartHabitation.setMontant (Math.random()*90000);
                contartHabitation.setTauxCouvrement (0.3);
                contartHabitation.setStatus (ContratStatus.Valide);
                contartHabitation.setTypeLogement (TypeLogement.Appartement);
                contartHabitation.setAdresse ("Maroc-meohammedia");
                contartHabitation.setSuperficie (20);
                contartHabitation.setClient (cli);
                contratRepository.save(contartHabitation);

                ContartAutomobile contartAutomobile = new ContartAutomobile();
                contartAutomobile.setId (UUID.randomUUID().toString());
                contartAutomobile.setDateSouscription(new Date());
                contartAutomobile.setDateValidation(new Date());
                contartAutomobile.setDureeContrat(5);
                contartAutomobile.setMontant (Math.random()*90000);
                contartAutomobile.setTauxCouvrement (0.3);
                contartAutomobile.setStatus (ContratStatus.Valide);
                contartAutomobile.setNumeroImmatriculation ("12345-A-23");
                contartAutomobile.setMarque ("MarqueX");
                contartAutomobile.setModel ("modelX");
                contartAutomobile.setClient (cli);
                contratRepository.save(contartAutomobile);
            });

            contratRepository.findAll().forEach( contart->{
                for(int i=0; i<5; i++){
                    Paiement p = new Paiement();
                    p.setDatePaiement(new Date());
                    p.setMontant(Math.random()*120000);
                    p.setPaiementType(PaiementType.Paiement_annuel);
                    p.setContrat(contart);
                    paiementRepository.save(p);
                }
            });

        };
    }

}
