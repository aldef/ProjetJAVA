package mainpackage;

import mainpackage.Lecteur;
import mainpackage.Livre;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialisation des listes
        ArrayList<Livre> livres = new ArrayList<Livre>();
        ArrayList<Lecteur> lecteurs = new ArrayList<Lecteur>();

        // Saisie des livres
        System.out.println("Saisie des livres : ");
        System.out.print("Entrer le titre : ");
        Scanner scanner = new Scanner(System.in);
        String titre = scanner.nextLine();
        while (!titre.equals("")) {
            System.out.print("Entrer l'auteur : ");
            String auteur = scanner.nextLine();
            livres.add(new Livre(titre, auteur));
            System.out.print("Entrer le titre : ");
            titre = scanner.nextLine();
        }

        // Saisie des lecteurs
        System.out.println("Saisie des lecteurs : ");
        System.out.print("Entrer le nom : ");
        String nom = scanner.nextLine();
        while (!nom.equals("")) {
            System.out.print("Entrer le prenom : ");
            String prenom = scanner.nextLine();
            lecteurs.add(new Lecteur(nom, prenom));
            System.out.print("Entrer le nom : ");
            nom = scanner.nextLine();
        }

        // Affichage des listes
        System.out.println("Livres : " + livres);
        System.out.println("Lecteurs : " + lecteurs);
    }

    }
