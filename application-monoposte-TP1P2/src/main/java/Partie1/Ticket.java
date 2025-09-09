package Partie1;

import java.util.Date;


public class Ticket {

    public enum  Statut {
        NOUVEAU,
        EN_COURS,
        FERME
    }

    private String titre;
    private String description;
    private Statut statut;
    private Date dateDeCreation;
    private Date dateDeFermeture;
    private Date dureeOuverture; //En jours, champs calculé n’est pas sauvegardé en BD

}
