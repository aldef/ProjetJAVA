package mainpackage;

public class Livre {

    private int identifiant;
    private String titre;
    private String auteur;

    public Livre(int identifiant, String titre, String auteur) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Identifiant : " + identifiant + ", Titre : " + titre + ", Auteur : " + auteur;
    }
}