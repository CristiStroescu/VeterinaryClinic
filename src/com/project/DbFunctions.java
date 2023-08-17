package com.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbFunctions {
    public Connection connect_to_db(String dbname, String user, String password){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,password);
            if(connection!=null){
                System.out.println("[INFO] Connection established");
            }
            else{
                System.out.println("[WARNING] Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
