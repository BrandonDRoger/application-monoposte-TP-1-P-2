package org.example.applicationmonopostetp1p2;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PreRemove;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TicketListener {

    /**
     * Callback exécuté avant l'insertion en base (persist).
     */
    @PrePersist
    public void preInsertion(Ticket ticket) {
        ticket.setDateDeCreation(new Date());
        System.out.println("CALLBACK @PrePersist: dateCréation fixée à "
                + ticket.getDateDeCreation() + " pour le nouveau ticket.");
    }

    /**
     * Callback exécuté avant la mise à jour en base (update).
     */
    @PreUpdate
    public void preMise_A_Jour(Ticket ticket) {
        if (ticket.getStatut() == Ticket.Statut.FERME && ticket.getDateDeFermeture() == null) {
            ticket.setDateDeFermeture(new Date());
            System.out.println("CALLBACK @PreUpdate: dateFermeture fixée à "
                    + ticket.getDateDeFermeture() + " pour ticket id=" + ticket.getId());
        }
    }

    /**
     * Callback exécuté après le chargement d'un ticket depuis la base.
     * Permet de calculer la durée ouverte en jours.
     */
    @PostLoad
    public void postChargement(Ticket ticket) {
        Date fin = (ticket.getDateDeFermeture() != null) ? ticket.getDateDeFermeture() : new Date();
        long diffInMillis = fin.getTime() - ticket.getDateDeCreation().getTime();
        long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillis);

        ticket.setDureeOuverture(diffInDays);

        System.out.println("CALLBACK @PostLoad: dureeOuverte calculée à "
                + diffInDays + " jours pour ticket id=" + ticket.getId());
    }

    /**
     * Callback exécuté avant la suppression d'un ticket.
     */
    @PreRemove
    public void preSuppresion(Ticket ticket) {
        System.out.println("CALLBACK @PreRemove: suppression du ticket id="
                + ticket.getId() + " avec le titre=" + ticket.getTitre());
    }
}
