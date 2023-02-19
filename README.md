
# Projet JAVA

Alexandre Defrène - Licence RGI - Formation initiale

# Consignes générales

Pour arrêter la saisie des lecteurs ou des livres, simplement appuyer sur Entrée en laissant une chaine de caractères vide.

# Version 1

- Lancer le projet sous IntelliJ, compiler le programme puis l'exécuter.

# Version 2

- Importer le fichier madb.sql dans la base de données au moyen de PhpMyAdmin ou Adminer.
- Lancer le projet sous IntelliJ, compiler le programme puis l'exécuter.

Commandes utilisées pour la création des conteneurs Docker : 

```console
docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=madb -p 3306:3306 -d mysql:latest
docker run --name phpmyadmin --link mysql:db -p 8080:80 -d phpmyadmin/phpmyadmin
```

# Version 3

- Lancer le projet Serveur sous IntelliJ, compiler le programme puis l'exécuter
- Lancer le projet Client sous IntelliJ, compiler le programme puis l'exécuter