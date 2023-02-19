package mainpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final int NUMERO_PORT = 1234;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

        try {
            maConnexion = DriverManager.getConnection(urlBD, "root", "root");
            System.out.println("Connexion à la base de données réussie.");
        } catch (
                SQLException ex) {
            throw new RuntimeException(ex);
        }

        Statement monStatement = null;

        try {
            monStatement = maConnexion.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ServerSocket serverSocket=null;

        //Initialiser le serveur
        try {
            serverSocket = new ServerSocket(NUMERO_PORT);
            System.out.println("Serveur établi. En attente de la connexion d'un client...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Socket maSocket = null;

        //Récupérer une connexion avec un client
        try {
            maSocket = serverSocket.accept();
            System.out.println("Connexion établie avec " + maSocket);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(maSocket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Object objet = null;

        //Tant que l'on reçoit des objets de la part du client
        while((objet = ois.readObject()) != null)
        {

            if(objet instanceof Livre) {
                Livre livre = (Livre)objet;
                System.out.println("Livre reçu : " + livre);

                String requete = "INSERT INTO livre(titre,auteur) VALUES (" +
                        "'"+ livre.getTitre() + "'," +
                        "'" + livre.getAuteur() + "'" +
                        ");";

                try {
                    int res = monStatement.executeUpdate(requete);
                    System.out.println("Ajout du livre à la base de données...");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (objet instanceof Lecteur) {
                Lecteur lecteur = (Lecteur)objet;
                System.out.println("Lecteur reçu : " + lecteur);

                String requete = "INSERT INTO lecteur(nom,prenom) VALUES (" +
                        "'"+ lecteur.getNom() + "'," +
                        "'" + lecteur.getPrenom() + "'" +
                        ");";

                try {
                    int res = monStatement.executeUpdate(requete);
                    System.out.println("Ajout du lecteur à la base de données...");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }

        maSocket.close();
        System.out.println("Connexion fermée avec " + maSocket);

    }
}
