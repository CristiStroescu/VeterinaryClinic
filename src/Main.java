import com.project.DbFunctions;

public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        db.connect_to_db("VeterinaryClinic","postgres","password");
    }
}