package mainpackage;

import mainpackage.Lecteur;
import mainpackage.Livre;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Livre> books = new ArrayList<Livre>();
    ArrayList<Lecteur> readers = new ArrayList<Lecteur>();

    public static void main(String[] args) {
        // Initialisation des listes
        ArrayList<Livre> books = new ArrayList<Livre>();
        ArrayList<Lecteur> readers = new ArrayList<Lecteur>();

        // Saisie des livres
        System.out.println("Saisie des livres : ");
        Scanner scanner = new Scanner(System.in);
        String titre = scanner.nextLine();
        while (!titre.equals("")) {
            System.out.println("Entrer l'auteur : ");
            String auteur = scanner.nextLine();
            books.add(new Livre(titre, auteur));
            System.out.println("Entrer le titre : ");
            titre = scanner.nextLine();
        }

        // Saisie des lecteurs
        System.out.println("Saisie des lecteurs : ");
        System.out.println("Entrer le nom : ");
        String nom = scanner.nextLine();
        while (!nom.equals("")) {
            System.out.println("Entrer le prenom : ");
            String prenom = scanner.nextLine();
            readers.add(new Lecteur(nom, prenom));
            System.out.println("Entrer le nom : ");
            nom = scanner.nextLine();
        }

        // Affichage des listes
        System.out.println("Livres : " + books);
        System.out.println("Lecteurs : " + readers);
    }

    }
