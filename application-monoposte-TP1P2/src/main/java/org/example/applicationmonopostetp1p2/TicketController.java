package org.example.applicationmonopostetp1p2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping ("/tickets")
    public List<Ticket> obtenirTousLesTickets() {
        return ticketService.obtenirTousLesTickets();
    }
}
