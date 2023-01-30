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

        Statement monStatement = null;

        try {
            monStatement = connexion.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSetLivres = monStatement.executeQuery("SELECT * FROM livre;");

            while (resultSetLivres.next()) {
                livres.add(new Livre(resultSetLivres.getInt("id"), resultSetLivres.getString("titre"), resultSetLivres.getString("auteur")));
            }

            resultSetLecteurs = monStatement.executeQuery("SELECT * FROM lecteur;");

            while (resultSetLecteurs.next()) {
                lecteurs.add(new Lecteur(resultSetLecteurs.getInt("id"), resultSetLivres.getString("prenom"), resultSetLivres.getString("nom")));
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
        // Initialisation des listes
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


    }

    }
