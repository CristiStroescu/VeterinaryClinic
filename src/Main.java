import com.project.DbConnection;
import com.project.DbInsertions;
import com.project.DbReading;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbConnection db = new DbConnection();
        DbInsertions dbInsert = new DbInsertions();
        DbReading dbReading = new DbReading();
        Connection connection= db.connectToDb("VeterinaryClinic","postgres","password");
        //dbInsert.insertRowEmployee(connection, "Mike", "Oliver", "driver");
        //dbInsert.insertRowClient(connection,"Emily","Brown","(789) 234-5678");
        dbReading.readDataFromEmployee(connection);
        dbReading.readDataFromClient(connection);
    }
}