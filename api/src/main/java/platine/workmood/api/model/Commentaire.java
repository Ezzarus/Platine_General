package platine.workmood.api.model;

import javax.persistence.*;

@Entity
@Table(name = "commentaire")
public class Commentaire {

    private int id;
    private String dateHeure;
    private boolean anonyme;
    private Probleme probleme;
    private Personne auteur;

    public Commentaire() {
    }

    public Commentaire(int id, String dateHeure, boolean anonyme) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.anonyme = anonyme;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public boolean isAnonyme() {
        return anonyme;
    }

    public void setAnonyme(boolean anonyme) {
        this.anonyme = anonyme;
    }

    @ManyToOne
    @JoinColumn(name="probleme_id")
    public Probleme getProbleme() {
        return probleme;
    }

    public void setProbleme(Probleme probleme) {
        this.probleme = probleme;
    }

    @ManyToOne
    @JoinColumn(name="personne_id")
    public Personne getAuteur() {
        return auteur;
    }

    public void setAuteur(Personne auteur) {
        this.auteur = auteur;
    }
}
