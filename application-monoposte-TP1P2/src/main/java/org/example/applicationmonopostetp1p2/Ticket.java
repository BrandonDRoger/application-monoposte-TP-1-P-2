package org.example.applicationmonopostetp1p2;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@EntityListeners(TicketListener.class)
public class Ticket {

    public enum Statut {
        NOUVEAU,
        EN_COURS,
        FERME
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeFermeture;

    @Transient
    private Long dureeOuverture; // en jours, calculé en runtime

    // Getters et setters (à générer ou écrire)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public Date getDateDeFermeture() {
        return dateDeFermeture;
    }

    public void setDateDeFermeture(Date dateDeFermeture) {
        this.dateDeFermeture = dateDeFermeture;
    }

    public Long getDureeOuverture() {
        return dureeOuverture;
    }

    public void setDureeOuverture(Long dureeOuverture) {
        this.dureeOuverture = dureeOuverture;
    }

}
