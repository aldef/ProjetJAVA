package mainpackage;

import java.io.Serializable;

public class Livre implements Serializable {

    private String titre;
    private String auteur;

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Titre : " + titre + ", Auteur : " + auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }
}