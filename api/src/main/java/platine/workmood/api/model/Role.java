package platine.workmood.api.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    private int id;
    private String intitule;
    private String couleur;

    public Role() {
    }

    public Role(int id, String intitule, String couleur) {
        this.id = id;
        this.intitule = intitule;
        this.couleur = couleur;
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

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
