package platine.workmood.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "probleme")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Probleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Categorie categorie;
    private String titre;
    private String description;
    private boolean anonyme;
    private String portee; //le probleme est public ou prive
    private Personne auteur;
    private Set<Personne> destinataires;
    private String dateHeure;
    private Statut statut;

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

    @ManyToOne
    @JoinColumn(name="categorie_id")
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @ManyToOne
    @JoinColumn(name="personne_id")
    public Personne getAuteur() {
        return auteur;
    }

    public void setAuteur(Personne auteur) {
        this.auteur = auteur;
    }

    @ManyToMany
    @JoinTable(name = "probleme_personne",
            joinColumns = @JoinColumn(name = "probleme_id"),
            inverseJoinColumns = @JoinColumn(name = "personne_id"))
    public Set<Personne> getDestinataires() {
        return destinataires;
    }

    public void setDestinataires(Set<Personne> destinataires) {
        this.destinataires = destinataires;
    }
    
    @ManyToOne
    @JoinColumn(name="statut_id")
    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}
