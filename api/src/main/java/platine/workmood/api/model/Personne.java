package platine.workmood.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personne")
public class Personne {
    private int id;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "personne")
    private List<Probleme> probleme;

    public Personne() {
    }

    public Personne(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Probleme> getProbleme() {
        return probleme;
    }

    public void setProbleme(List<Probleme> probleme) {
        this.probleme = probleme;
    }
}
