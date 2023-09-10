# VeterinaryClinic

You will need an editor (I used IntelliJ IDEA), and you will need to install PostgreSQL.

The project should already have a .jar file, a JDBC driver that connects the app to the database.

To verify if there is the file, right click to the project name -> "Open Module Settings" -> "Libraries", and you should see the .jar file named "postgresql-42.6.0.jar".

If the .jar file is missing, go to https://jdbc.postgresql.org/download/, download the Java 8 version(keep the file in a place you will remember, because you will update the project with this file manually), then right click to the project name -> "Open Module Settings" -> "Libraries" -> click on "+" button -> "Java" -> search and add the .jar file you downloaded -> "Ok" -> "Ok" -> "Apply" -> "Ok".

For creating the database:
1. If you have the backup of my database, open pgAdmin -> right-click on "PostgreSQL" -> "Create..." -> "Database" -> "Save" -> right-click on the new database you created -> "Restore..." -> search for the backup file -> "Restore".
2. If you don't have the backup, you must create the database manually, using exactly the same names of the tables and their columns I used (if you don't want to modify anything in the Java code).
IMPORTANT: If you create the database manually, make all the fields where you see the name "id" to be autoincrement, because if you insert a row in one of those tables, you cannot assign a value to the id field in my app.

After this, in the Main class, at the line where is called the "connectToDb" method, modify the arguments with the name of your database, your PostgreSql username and your PostgreSql password.

The versions I used:

SDK: openjdk-19

Driver: postgresql-42.6.0.jar

PostgreSQL: PostgreSQL 15

IntelliJ: IntelliJ IDEA 2022.2.3 (Ultimate Edition)
