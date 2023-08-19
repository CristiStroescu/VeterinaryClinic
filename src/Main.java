import com.project.DbConnection;
import com.project.DbInsertions;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbConnection db = new DbConnection();
        DbInsertions dbInsert = new DbInsertions();
        Connection connection= db.connectToDb("VeterinaryClinic","postgres","password");
        //dbInsert.insertRowEmployee(connection, "Mike", "Oliver", "driver");
        //dbInsert.insertRowClient(connection,"Emily","Brown","(789) 234-5678");
    }
}