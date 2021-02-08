package platine.workmood.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {
    private int id;
    private String intitule;

    @OneToMany(mappedBy = "categorie")
    private List<Probleme> probleme;

    public Categorie() {
    }

    public Categorie(int id, String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Probleme> getProbleme() {
        return probleme;
    }

    public void setProbleme(List<Probleme> probleme) {
        this.probleme = probleme;
    }
}
