package mainpackage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static final String IP_SERVEUR = "localhost";
    private static final int NUMERO_PORT = 1234;

    public static void main(String[] args) {
        Socket clientSocket = null;

        try {
            clientSocket = new Socket(IP_SERVEUR, NUMERO_PORT);
            System.out.println("Connexion établie avec le serveur.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Saisie des livres : ");
        System.out.print("Entrer le titre : ");
        Scanner scanner = new Scanner(System.in);
        String titre = scanner.nextLine();
        while (!titre.equals("")) {
            System.out.print("Entrer l'auteur : ");
            String auteur = scanner.nextLine();

            //Envoi du livre au serveur
            Livre livre = new Livre(titre, auteur);
            try {
                oos.writeObject(livre);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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

            //Envoi du lecteur au serveur
            Lecteur lecteur = new Lecteur(nom, prenom);
            try {
                oos.writeObject(lecteur);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.print("Entrer le nom : ");
            nom = scanner.nextLine();
        }

        //Fermeture de la connexion avec le serveur
        try {
            clientSocket.close();
            System.out.println("COnnexion fermée avec " + clientSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
