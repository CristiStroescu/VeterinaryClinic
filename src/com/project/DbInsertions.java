package com.project;

import java.sql.Connection;
import java.sql.Statement;

public class DbInsertions {
    public void insertRowEmployee(Connection connection, String firstName, String lastName, String jobType){ //...
        Statement statement;
        try{
            String query=String.format("insert into %s(first_name, last_name, job_type) values('%s','%s','%s');"
                    ,"employee",firstName,lastName,jobType);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] Row inserted in \"employee\" table.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRowClient(Connection connection, String firstName, String lastName, String phoneNumber){
        Statement statement;
        try{
            String query=String.format("insert into %s(first_name, last_name, phone_number) values('%s','%s','%s');"
                    ,"client",firstName,lastName,phoneNumber);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] Row inserted in \"client\" table.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRowAppointments(Connection connection, int idEmployee, int idPet, String appointmentTime,
                                      String data, String totalCost){
        Statement statement;
        try{
            String query=String.format("insert into %s(id_employee, id_pet, appointment_time, data, total_cost)" +
                            " values('%d','%d','%s',%s, %s);"
                    ,"appointments",idEmployee,idPet,appointmentTime,data, totalCost);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] Row inserted in \"appointments\" table.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRowPet(Connection connection, int idClient, String type){
        Statement statement;
        try{
            String query=String.format("insert into %s(id_client, type) values('%d','%s');"
                    ,"pet",idClient, type);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] Row inserted in \"pet\" table.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRowTimetable(Connection connection, String day, String startTime, String endTime,
                                   int idEmployee){
        Statement statement;
        try{
            String query=String.format("insert into %s(day, start_time, end_time, id_employee) " +
                    "values('%s','%s','%s','%d');","timetable",day, startTime,endTime, idEmployee);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] Row inserted in \"timetable\" table.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRowIntervention(Connection connection, String name, String cost){
        Statement statement;
        try{
            String query=String.format("insert into %s(name, cost) values('%s','%s');"
                    ,"intervention",name, cost);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] Row inserted in \"intervention\" table.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRowInterventionProgramming(Connection connection, int idEmployee, int idIntervention){
        Statement statement;
        try{
            String query=String.format("insert into %s(id_employee, id_intervention) values('%d','%d');"
                    ,"intervention_programming",idEmployee, idIntervention);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("[INFO] Row inserted in \"intervention_programming\" table.");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
