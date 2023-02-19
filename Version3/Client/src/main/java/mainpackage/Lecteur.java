package mainpackage;

import java.io.Serializable;

public class Lecteur implements Serializable {

    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Lecteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", Prénom : " + prenom;
    }
}
