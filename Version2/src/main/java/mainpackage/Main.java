package mainpackage;

import mainpackage.Lecteur;
import mainpackage.Livre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialisation des listes
        ArrayList<Livre> livres = new ArrayList<Livre>();
        ArrayList<Lecteur> lecteurs = new ArrayList<Lecteur>();

        // Initialisation de la connexion à la BDD
        Connection maConnexion = null;

        String nomDuDriverJDBC = "com.mysql.cj.jdbc.Driver";
        String urlBD = "jdbc:mysql://localhost:3306/madb";

        System.out.println("Connexion en cours..");

        try {
            Class.forName(nomDuDriverJDBC);
            System.out.println("Le Driver JDBC a été trouvé.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            maConnexion = DriverManager.getConnection(urlBD, "root", "root");
            System.out.println("Connexion réussie.");
        } catch (
                SQLException ex) {
            throw new RuntimeException(ex);
        }




    }

    }
