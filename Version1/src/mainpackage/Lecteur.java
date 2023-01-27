package mainpackage;

public class Lecteur {
    private String nom;
    private String prenom;

    public Lecteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", Prénom : " + prenom;
    }
}
