package platine.workmood.api.model;

import javax.persistence.*;

@Entity
@Table(name = "probleme")
public class Probleme {

    private int id;
    private String titre;
    private String description;
    private boolean anonyme;
    private String portee; //le probleme est public ou prive
    private String dateHeure;
    private int nbVues;
    private boolean moderation; //le probleme peut etre signale comme inaproprie ou irrespectueux

    public Probleme() {
    }

    public Probleme(int id, String titre, String description, boolean anonyme, String portee, String dateHeure, int nbVues, boolean moderation) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.anonyme = anonyme;
        this.portee = portee;
        this.dateHeure = dateHeure;
        this.nbVues = nbVues;
        this.moderation = moderation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isAnonyme() {
        return anonyme;
    }

    public void setAnonyme(boolean anonyme) {
        this.anonyme = anonyme;
    }

    public String getPortee() {
        return portee;
    }

    public void setPortee(String portee) {
        this.portee = portee;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public boolean isModeration() {
        return moderation;
    }

    public void setModeration(boolean moderation) {
        this.moderation = moderation;
    }
}
