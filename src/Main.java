import com.project.DbConnectionFunction;
import com.project.DbInsertFunctions;
import com.project.DbReadFunctions;
import com.project.DbUpdateFunctions;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbConnectionFunction db = new DbConnectionFunction();
        DbInsertFunctions dbInsert = new DbInsertFunctions();
        DbReadFunctions dbReadFunctions = new DbReadFunctions();
        DbUpdateFunctions dbUpdateFunctions = new DbUpdateFunctions();
        Connection connection= db.connectToDb("VeterinaryClinic","postgres","password");
        //dbInsertFunctions.insertRowEmployee(connection, "Mike", "Oliver", "driver");
        //dbInsertFunctions.insertRowClient(connection,"Emily","Brown","(789) 234-5678");
        //dbReadFunctions.readDataFromEmployee(connection);
        dbReadFunctions.readDataFromClient(connection);
        dbUpdateFunctions.UpdateString(connection, "last_name", "client", "Dominguez",
                "Swan");
        dbReadFunctions.readDataFromClient(connection);

    }
}