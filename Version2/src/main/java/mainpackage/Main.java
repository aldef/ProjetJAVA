package mainpackage;

import mainpackage.Lecteur;
import mainpackage.Livre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void recupererDonnees(Connection connexion, ArrayList<Livre> livres, ArrayList<Lecteur> lecteurs)
    {
        ResultSet resultSetLivres = null;
        ResultSet resultSetLecteurs = null;

        Statement statementLivres = null;
        Statement statementLecteurs = null;

        try {
            statementLivres = connexion.createStatement();
            statementLecteurs = connexion.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSetLivres = statementLivres.executeQuery("SELECT * FROM livre;");

            while (resultSetLivres.next()) {
                livres.add(new Livre(resultSetLivres.getString("titre"), resultSetLivres.getString("auteur")));
            }

            resultSetLecteurs = statementLecteurs.executeQuery("SELECT * FROM lecteur;");

            while (resultSetLecteurs.next()) {
                lecteurs.add(new Lecteur(resultSetLecteurs.getString("prenom"), resultSetLecteurs.getString("nom")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Affichage des données
        System.out.println("Données récupérées:");
        System.out.println("Livres : " + livres);
        System.out.println("Lecteurs : " + lecteurs);

    }


    public static void main(String[] args) {
        // Initialisation des listes pour la récupération depuis la BDD
        ArrayList<Livre> livres = new ArrayList<Livre>();
        ArrayList<Lecteur> lecteurs = new ArrayList<Lecteur>();

        // Initialisation de la connexion à la BDD
        Connection maConnexion = null;

        String nomDuDriverJDBC = "com.mysql.cj.jdbc.Driver";
        String urlBD = "jdbc:mysql://localhost:3306/madb";

        try {
            Class.forName(nomDuDriverJDBC);
            System.out.println("Le Driver JDBC a été trouvé.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connexion en cours..");

        try {
            maConnexion = DriverManager.getConnection(urlBD, "root", "root");
            System.out.println("Connexion réussie.");
        } catch (
                SQLException ex) {
            throw new RuntimeException(ex);
        }

        //Récupération et affichage des données existantes
        System.out.println("Récupération des données..");
        recupererDonnees(maConnexion, livres, lecteurs);

        System.out.println();

        //Réinitialisation des listes
        lecteurs.clear();
        livres.clear();

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


        Statement monStatement = null;

        try {
            monStatement = maConnexion.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for(Lecteur lecteur : lecteurs)
        {
            String requete = "INSERT INTO lecteur(nom,prenom) VALUES (" +
                    "'"+ lecteur.getNom() + "'," +
                    "'" + lecteur.getPrenom() + "'" +
                    ");";

            try {
                int res = monStatement.executeUpdate(requete);
                System.out.println("Ajout d'un lecteur : " + lecteur.getNom() + ' ' + lecteur.getPrenom());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        for(Livre livre : livres)
        {
            String requete = "INSERT INTO livre(titre,auteur) VALUES (" +
                    "'"+ livre.getTitre() + "'," +
                    "'" + livre.getAuteur() + "'" +
                    ");";

            try {
                int res = monStatement.executeUpdate(requete);
                System.out.println("Ajout d'un livre : " + livre.getTitre() + ' ' + livre.getAuteur());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //Récupération et affichage des données enregistrées en base de données
        System.out.println("Récupération des données..");
        recupererDonnees(maConnexion, livres, lecteurs);

    }

    }
