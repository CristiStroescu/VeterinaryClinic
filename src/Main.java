import com.project.*;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbConnectionFunction db = new DbConnectionFunction();
        DbInsertFunctions dbInsert = new DbInsertFunctions();
        DbReadFunctions dbReadFunctions = new DbReadFunctions();
        DbUpdateFunctions dbUpdateFunctions = new DbUpdateFunctions();
        DbSearchFunctions dbSearchFunctions = new DbSearchFunctions();
        Connection connection= db.connectToDb("VeterinaryClinic","postgres","password");
        //dbInsertFunctions.insertRowEmployee(connection, "Mike", "Oliver", "driver");
        //dbInsertFunctions.insertRowClient(connection,"Emily","Brown","(789) 234-5678");
        dbReadFunctions.readDataFromEmployee(connection);
        //dbReadFunctions.readDataFromClient(connection);
        //dbUpdateFunctions.UpdateString(connection, "last_name", "client", "Brown", "Swan");
        //dbReadFunctions.readDataFromClient(connection);
        //dbSearchFunctions.SearchInEmployeeByInteger(connection,"id",1);
        //dbSearchFunctions.SearchInEmployeeByString(connection,"first_name","Mike");

    }
}