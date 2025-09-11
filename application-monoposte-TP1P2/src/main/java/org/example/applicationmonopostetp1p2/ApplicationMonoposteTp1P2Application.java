package org.example.applicationmonopostetp1p2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApplicationMonoposteTp1P2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMonoposteTp1P2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(TicketRepository ticketRepository) {
        return args -> {
            System.out.println("\n=== DÉMARRAGE TEST CALLBACKS ===");

            // 1. Créer trois tickets
            Ticket t1 = new Ticket();
            t1.setTitre("Problème imprimante");
            t1.setStatut(Ticket.Statut.NOUVEAU);

            Ticket t2 = new Ticket();
            t2.setTitre("Erreur système");
            t2.setStatut(Ticket.Statut.FERME);

            Ticket t3 = new Ticket();
            t3.setTitre("Problème réseau");
            t3.setStatut(Ticket.Statut.EN_COURS);

            ticketRepository.save(t1);
            ticketRepository.save(t2);
            ticketRepository.save(t3);

            System.out.println(">>> Trois tickets créés.");

            // 2. Modifier la date de création du ticket #2 pour la mettre à une semaine avant aujourd’hui
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -7);
            t2.setDateDeCreation(cal.getTime());
            ticketRepository.save(t2);
            System.out.println(">>> Date de création du ticket #2 modifiée à : " + t2.getDateDeCreation());

            // 3. Modifier le statut du ticket #2 pour "NOUVEAU" -> Déclenche @PreUpdate
            t2.setStatut(Ticket.Statut.NOUVEAU);
            ticketRepository.save(t2);

            // 4. Récupérer et afficher la durée du ticket #2 -> Déclenche @PostLoad
            Optional<Ticket> ticket2FromDB = ticketRepository.findById(t2.getId());
            if (ticket2FromDB.isPresent()) {
                Ticket loadedTicket = ticket2FromDB.get();
                System.out.println("Durée ouverte du ticket #2 : " + loadedTicket.getDureeOuverture() + " jours.");
            }

            // 5. Supprimer le ticket #1 -> Déclenche @PreRemove
            ticketRepository.deleteById(t1.getId());
            System.out.println(">>> Ticket #1 supprimé.");

            System.out.println("=== FIN TEST CALLBACKS ===");

            /**
             * Partie 2 – CallBack et Lambda
             */

            List<String> items = List.of("Item1", "Item2", "Item3", "Item4");
            AfficheListe afficheListe = new AfficheListe();
            afficheListe.afficherItem(items, item -> System.out.println("Elément : " + item));
        };
    }
}
