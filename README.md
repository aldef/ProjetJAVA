
# Projet JAVA

Alexandre Defrène - Licence RGI - Formation initiale

# Version 1

- Lancer le projet sous IntelliJ et compiler le programme.

# Version 2

- Importer le fichier madb.sql dans la base de données au moyen de PhpMyAdmin ou Adminer.
- Lancer le projet sous IntelliJ et compiler le programme.

Commandes utilisées pour la création des conteneurs Docker : 

```console
docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=madb -p 3306:3306 -d mysql:latest
docker run --name phpmyadmin --link mysql:db -p 8080:80 -d phpmyadmin/phpmyadmin
```

# Version 3