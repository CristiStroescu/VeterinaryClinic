# VeterinaryClinic

You will need an editor (I used IntelliJ IDEA), you will need to install PostgreSQL and a driver from the site https://jdbc.postgresql.org/download/ that connects the app to the database. You should keep the driver in a place you will remember, because you will update the project with the .jar file manually.

To add the .jar file in IntelliJ, right click to the project name -> "Open Module Settings" -> "Libraries" -> click on "+" button -> "Java" -> search and add the .jar file you downloaded -> "Ok" -> "Ok" -> "Apply" -> "Ok".

For creating the database:
1. If you have the backup of my database, open pgAdmin -> right-click on "PostgreSQL" -> "Create..." -> "Database" -> "Save" -> right-click on the new database you created -> "Restore..." -> search for the backup file -> "Restore".
2. If you don't have the backup, you must create the database manually, using exactly the same names of the tables and their columns I used (if you don't want to modify anything in the Java code).

After this, in the Main class, in the line where is called the "connectToDb" method, modify the parameters with the name of your database, your PostgreSql username and your PostgreSql password.

The versions I used:
SDK: openjdk-19
Driver: postgresql-42.6.0.jar
PostgreSQL: PostgreSQL 15
IntelliJ: IntelliJ IDEA 2022.2.3 (Ultimate Edition)
