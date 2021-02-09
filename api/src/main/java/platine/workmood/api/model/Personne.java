package platine.workmood.api.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "personne")
public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private Role role;
    private Set<Probleme> problemesCrees;
    private Set<Probleme> probleme;

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

    @ManyToOne
    @JoinColumn(name="role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @JsonIgnoreProperties({"auteur", "destinataires"})
    @OneToMany(mappedBy = "auteur")
    public Set<Probleme> getProblemesCrees() {
        return problemesCrees;
    }

    public void setProblemesCrees(Set<Probleme> problemesCrees) {
        this.problemesCrees = problemesCrees;
    }

    @JsonIgnoreProperties({"auteur", "destinataires"})
    @ManyToMany(mappedBy="destinataires")
    public Set<Probleme> getProbleme() {
        return probleme;
    }

    public void setProbleme(Set<Probleme> probleme) {
        this.probleme = probleme;
    }
}
