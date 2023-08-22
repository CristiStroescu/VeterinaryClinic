package com.project;

import java.sql.Connection;
import java.sql.Statement;

public class DbUpdateFunctions {
    public void UpdateString(Connection connection, String tableName, String type, String oldData,
                                String newData){
        Statement statement;
        try{
            String query = String.format("update %s set "+type+"='%s' where "+type+"='%s'",
                    tableName, newData, oldData);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] The '"+type+"' field '"+oldData+"' from the '"+tableName+
                    "' table was updated to '" +newData+"'.");
            System.out.println();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void UpdateInteger(Connection connection, String tableName, String type, int oldData,
                             int newData){
        Statement statement;
        try{
            String query = String.format("update %s set "+type+"='%s' where "+type+"=%s",
                    tableName, newData, oldData);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] The '"+type+"' field '"+oldData+"' from the '"+tableName+
                    "' table was updated to '" +newData+"'.");
            System.out.println();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
