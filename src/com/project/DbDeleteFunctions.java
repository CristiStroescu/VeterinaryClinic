package com.project;

import java.sql.Connection;
import java.sql.Statement;

public class DbDeleteFunctions {
    public void deleteRowByStringValue(Connection connection, String tableName, String type, String value){
        Statement statement;
        try{
            String query=String.format("delete from "+tableName+" where "+type+"='%s'", value);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] The row with "+type+" = '"+value+"' was deleted from '"+tableName+
                    "' table.");
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteRowByIntegerValue(Connection connection, String tableName, String type, int value){
        Statement statement;
        try{
            String query=String.format("delete from "+tableName+" where "+type+"=%s", value);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] The row with "+type+" = '"+value+"' was deleted from '"+tableName+
                    "' table.");
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
