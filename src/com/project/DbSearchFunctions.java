package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbSearchFunctions {
    public void SearchInEmployeeByInteger(Connection connection, String type, int value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from employee where "+type+"=%s", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"employee\" table where "+ type+" = "+value+" " +
                    "(id, first_name, last_name):");
            while(resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("first_name")+" ");
                System.out.println(resultSet.getString("last_name"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInEmployeeByString(Connection connection, String type, String value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from employee where "+type+"='%s'", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"employee\" table where "+ type+" = "+value+" " +
                    "(id, first_name, last_name, job_type):");
            while(resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("first_name")+" ");
                System.out.print(resultSet.getString("last_name")+" ");
                System.out.println(resultSet.getString("job_type"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInClientByInteger(Connection connection, String type, int value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from client where "+type+"=%s", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"client\" table where "+ type+" = "+value+" " +
                    "(id, first_name, last_name, phone_number):");
            while(resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("first_name")+" ");
                System.out.print(resultSet.getString("last_name")+" ");
                System.out.println(resultSet.getString("phone_number"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInClientByString(Connection connection, String type, String value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from client where "+type+"='%s'", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"client\" table where "+ type+" = "+value+" " +
                    "(id, first_name, last_name, phone_number):");
            while(resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("first_name")+" ");
                System.out.print(resultSet.getString("last_name")+" ");
                System.out.println(resultSet.getString("phone_number"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInAppointmentsByInteger(Connection connection, String type, int value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from appointments where "+type+"=%s", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"appointments\" table where "+ type+" = "+value+" " +
                    "(id_employee, id_pet, appointment_time, data, total_cost):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id_employee")+" ");
                System.out.print(resultSet.getString("id_pet")+" ");
                System.out.print(resultSet.getString("appointment_time")+" ");
                System.out.print(resultSet.getString("data")+" ");
                System.out.println(resultSet.getString("total_cost"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInAppointmentsByString(Connection connection, String type, String value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from client where "+type+"='%s'", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"appointments\" table where "+ type +" = "+value+" " +
                    "(id_employee, id_pet, appointment_time, data, total_cost):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id_employee")+" ");
                System.out.print(resultSet.getString("id_pet")+" ");
                System.out.print(resultSet.getString("appointment_time")+" ");
                System.out.print(resultSet.getString("data")+" ");
                System.out.println(resultSet.getString("total_cost"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInInterventionByInteger(Connection connection, String type, int value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from intervention where "+type+"=%s", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"intervention\" table where "+ type+" = "+value+" " +
                    "(id, name, cost):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.println(resultSet.getString("cost"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInInterventionByString(Connection connection, String type, String value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from intervention where "+type+"='%s'", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"intervention\" table where "+ type+" = "+value+" " +
                    "(id, name, cost):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.println(resultSet.getString("cost"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInInterventionProgramming(Connection connection, String type, int value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from intervention_programming where "+type+"=%s", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"intervention_programming\" table where "+ type+" = "+value+" " +
                    "(id_employee, id_intervention):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id_employee")+" ");
                System.out.println(resultSet.getString("id_intervention"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInPetByInteger(Connection connection, String type, int value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from pet where "+type+"=%s", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"pet\" table where "+ type+" = "+value+" " +
                    "(id, id_client, type):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("id_client")+" ");
                System.out.println(resultSet.getString("type"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInPetByString(Connection connection, String type, String value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from pet where "+type+"='%s'", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"pet\" table where "+ type+" = "+value+" " +
                    "(id, id_client, type):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("id_client")+" ");
                System.out.println(resultSet.getString("type"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInTimetableByInteger(Connection connection, String type, int value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from timetable where "+type+"=%s", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"timetable\" table where "+ type+" = "+value+" " +
                    "(id, day, start_time, end_time, id_employee):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("day")+" ");
                System.out.print(resultSet.getString("start_time")+" ");
                System.out.print(resultSet.getString("end_time")+" ");
                System.out.println(resultSet.getString("id_employee"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchInTimetableByString(Connection connection, String type, String value){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select*from timetable where "+type+"='%s'", value);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("[INFO] Data from \"timetable\" table where "+ type+" = "+value+" " +
                    "(id, day, start_time, end_time, id_employee):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("day")+" ");
                System.out.print(resultSet.getString("start_time")+" ");
                System.out.print(resultSet.getString("end_time")+" ");
                System.out.println(resultSet.getString("id_employee"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
