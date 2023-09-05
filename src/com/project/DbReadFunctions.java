package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbReadFunctions {
    public void readDataFromEmployee(Connection connection){
        Statement statement;
        ResultSet resultSet = null;
        try{
            String query = String.format("select * from employee");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("[INFO] Data from \"employee\" table (id, first_name, last_name, job_type):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("first_name")+" ");
                System.out.print(resultSet.getString("last_name")+" [");
                System.out.println(resultSet.getString("job_type")+"]");
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readDataFromClient(Connection connection){
        Statement statement;
        ResultSet resultSet = null;
        try{
            String query = String.format("select * from client");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("[INFO] Data from \"client\" table (id, first_name, last_name, phone_number):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("first_name")+" ");
                System.out.print(resultSet.getString("last_name")+" [");
                System.out.println(resultSet.getString("phone_number")+"]");
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readDataFromAppointments(Connection connection){
        Statement statement;
        ResultSet resultSet = null;
        try{
            String query = String.format("select * from appointments");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("[INFO] Data from \"appointments\" table (id_employee, id_pet," +
                    " appointment_time, data, total_cost):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id_employee")+" ");
                System.out.print(resultSet.getString("id_pet")+" ");
                System.out.print(resultSet.getString("appointment_time")+" [");
                System.out.print(resultSet.getString("data")+"] $");
                System.out.println(resultSet.getString("total_cost"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readDataFromIntervention(Connection connection){
        Statement statement;
        ResultSet resultSet = null;
        try{
            String query = String.format("select * from intervention");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("[INFO] Data from \"intervention\" table (id, name, cost):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" [");
                System.out.print(resultSet.getString("name")+"] $");
                System.out.println(resultSet.getString("cost"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readDataFromInterventionProgramming(Connection connection){
        Statement statement;
        ResultSet resultSet = null;
        try{
            String query = String.format("select * from intervention_programming");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("[INFO] Data from \"intervention_programming\" table (id_employee," +
                    " id_intervention):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id_employee")+" ");
                System.out.println(resultSet.getString("id_intervention"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readDataFromPet(Connection connection){
        Statement statement;
        ResultSet resultSet = null;
        try{
            String query = String.format("select * from pet");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("[INFO] Data from \"pet\" table (id, id_client, type):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("id_client")+" [");
                System.out.println(resultSet.getString("type")+"]");
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readDataFromTimetable(Connection connection){
        Statement statement;
        ResultSet resultSet = null;
        try{
            String query = String.format("select * from timetable");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("[INFO] Data from \"timetable\" table (id, day, start_time, end_time," +
                    " id_employee):");
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("day")+" [");
                System.out.print(resultSet.getString("start_time")+"] [");
                System.out.print(resultSet.getString("end_time")+"] ");
                System.out.println(resultSet.getString("id_employee"));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
