package mainpackage;

public class Lecteur {

    private int identifiant;
    private String nom;
    private String prenom;

    public Lecteur(int identifiant, String nom, String prenom) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Identifiant : " + identifiant + ", Nom : " + nom + ", Prénom : " + prenom;
    }
}
