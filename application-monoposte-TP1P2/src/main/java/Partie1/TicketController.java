package Partie1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired TicketRepository ticketRepository;

    @GetMapping("/Tickets")
    Iterable<Ticket> obtenirTousLesTickets() {
        return ticketRepository.findAll();
    }
}
