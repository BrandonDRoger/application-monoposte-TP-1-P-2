package org.example.applicationmonopostetp1p2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    /**
     * Récupère tous les tickets en base de données
     * @return liste de tous les tickets
     */
    public List<Ticket> obtenirTousLesTickets() {
        return ticketRepository.findAll();
    }
}
