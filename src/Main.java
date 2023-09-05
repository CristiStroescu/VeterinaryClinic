import com.project.*;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbConnectionFunction db = new DbConnectionFunction();
        DbInsertFunctions dbInsertFunctions = new DbInsertFunctions();
        DbReadFunctions dbReadFunctions = new DbReadFunctions();
        DbUpdateFunctions dbUpdateFunctions = new DbUpdateFunctions();
        DbSearchFunctions dbSearchFunctions = new DbSearchFunctions();
        DbDeleteFunctions dbDeleteFunctions = new DbDeleteFunctions();
        Connection connection= db.connectToDb("VeterinaryClinic","postgres","password");

        Scanner scanner = new Scanner(System.in);
        int option;

        do{
            do {
                displayMenu();
                System.out.print("Your option: ");
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> displayReadMenu();
                    case 2 -> displayInsertMenu();
                    case 3 -> displaySearchMenu();
                    case 4 -> displayUpdateMenu();
                    case 5 -> displayDeleteMenu();
                    case 6 -> {
                        System.out.println("[INFO] You have exited the program.");
                        scanner.close();
                    }
                    default -> System.out.println("[WARNING] Please enter a valid option.");
                }
            }while (option<1 || option>6);

            if(option!=6) {
                System.out.print("Your option: ");
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 10:
                        dbReadFunctions.readDataFromEmployee(connection);
                        break;
                    case 11:
                        dbReadFunctions.readDataFromClient(connection);
                        break;
                    case 12:
                        dbReadFunctions.readDataFromPet(connection);
                        break;
                    case 13:
                        dbReadFunctions.readDataFromAppointments(connection);
                        break;
                    case 14:
                        dbReadFunctions.readDataFromIntervention(connection);
                        break;
                    case 15:
                        dbReadFunctions.readDataFromInterventionProgramming(connection);
                        break;
                    case 16:
                        dbReadFunctions.readDataFromTimetable(connection);
                        break;
                    case 20:
                        String firstNameEmployee, lastNameEmployee, jobType;
                        System.out.println("[INFO] Inserting into 'employee' table.");
                        System.out.print("first_name: ");
                        firstNameEmployee = scanner.nextLine();
                        System.out.print("last_name: ");
                        lastNameEmployee = scanner.nextLine();
                        System.out.print("jobType: ");
                        jobType = scanner.nextLine();
                        dbInsertFunctions.insertRowEmployee(connection,firstNameEmployee,lastNameEmployee,
                                jobType);
                        break;
                    case 21:
                        String firstNameClient, lastNameClient, phoneNumber;
                        System.out.println("[INFO] Inserting into 'client' table.");
                        System.out.print("first_name: ");
                        firstNameClient = scanner.nextLine();
                        System.out.print("last_name: ");
                        lastNameClient = scanner.nextLine();
                        System.out.print("phone_number: ");
                        phoneNumber = scanner.nextLine();
                        dbInsertFunctions.insertRowClient(connection,firstNameClient,lastNameClient,
                                phoneNumber);
                        break;
                    case 22:
                        int idClient;
                        String type;
                        System.out.println("[INFO] Inserting into 'pet' table.");
                        System.out.print("id_client: ");
                        idClient = Integer.parseInt(scanner.nextLine());
                        System.out.print("type: ");
                        type = scanner.nextLine();
                        dbInsertFunctions.insertRowPet(connection,idClient,type);
                        break;
                    case 23:
                        int idEmployee,idPet, totalCost;
                        String appointmentTime, data;
                        System.out.println("[INFO] Inserting into 'appointments' table.");
                        System.out.print("id_employee: ");
                        idEmployee = Integer.parseInt(scanner.nextLine());
                        System.out.print("id_pet: ");
                        idPet = Integer.parseInt(scanner.nextLine());
                        System.out.print("appointment_time: ");
                        appointmentTime = scanner.nextLine();
                        System.out.print("data: ");
                        data = scanner.nextLine();
                        System.out.print("total_cost: ");
                        totalCost = Integer.parseInt(scanner.nextLine());
                        dbInsertFunctions.insertRowAppointments(connection,idEmployee, idPet, appointmentTime,
                                data, totalCost);
                        break;
                    case 24:
                        String name;
                        int cost;
                        System.out.println("[INFO] Inserting into 'intervention' table.");
                        System.out.print("name: ");
                        name = scanner.nextLine();
                        System.out.print("cost: ");
                        cost = Integer.parseInt(scanner.nextLine());
                        dbInsertFunctions.insertRowIntervention(connection,name, cost);
                        break;
                    case 25:
                        int idEmployeeIntervention,idIntervention;
                        System.out.println("[INFO] Inserting into 'intervention_programming' table.");
                        System.out.print("id_employee: ");
                        idEmployeeIntervention = Integer.parseInt(scanner.nextLine());
                        System.out.print("id_intervention: ");
                        idIntervention = Integer.parseInt(scanner.nextLine());
                        dbInsertFunctions.insertRowInterventionProgramming(connection,idEmployeeIntervention,
                                idIntervention);
                        break;
                    case 26:
                        int idEmployeeTimetable;
                        String day, startTime, endTime;
                        System.out.println("[INFO] Inserting into 'timetable' table.");
                        System.out.print("day: ");
                        day = scanner.nextLine();
                        System.out.print("start_time: ");
                        startTime = scanner.nextLine();
                        System.out.print("end_time: ");
                        endTime = scanner.nextLine();
                        System.out.print("id_employee: ");
                        idEmployeeTimetable = Integer.parseInt(scanner.nextLine());
                        dbInsertFunctions.insertRowTimetable(connection,day,startTime,endTime,
                                idEmployeeTimetable);
                        break;
                    case 30:
                        String typeEmployee, valueEmployeeString;
                        int valueEmployeeInt;
                        System.out.print("Name of the column you want to search for (id, first_name, " +
                                "last_name, job_type): ");
                        typeEmployee = scanner.nextLine();
                        System.out.print("The value you are searching for: ");
                        if(!typeEmployee.equals("id")){
                            valueEmployeeString = scanner.nextLine();
                            dbSearchFunctions.SearchInEmployeeByString(connection,typeEmployee,
                                    valueEmployeeString);
                        }else {
                            valueEmployeeInt = Integer.parseInt(scanner.nextLine());
                            dbSearchFunctions.SearchInEmployeeByInteger(connection,typeEmployee,
                                    valueEmployeeInt);
                        }
                        break;
                    case 31:
                        String typeClient, valueClientString;
                        int valueClientInt;
                        System.out.print("Name of the column you want to search for (id, first_name, " +
                                "last_name, phone_number):");
                        typeClient = scanner.nextLine();
                        System.out.print("The value you are searching for: ");
                        if(!typeClient.equals("id")){
                            valueClientString = scanner.nextLine();
                            dbSearchFunctions.SearchInClientByString(connection,typeClient,
                                    valueClientString);
                        }else {
                            valueClientInt = Integer.parseInt(scanner.nextLine());
                            dbSearchFunctions.SearchInClientByInteger(connection,typeClient,
                                    valueClientInt);
                        }
                        break;
                    case 32:
                        String typePet, valuePetString;
                        int valuePetInt;
                        System.out.print("Name of the column you want to search for (id, id_client, " +
                                "type):");
                        typePet = scanner.nextLine();
                        System.out.print("The value you are searching for: ");
                        if(!typePet.equals("type")){
                            valuePetInt = Integer.parseInt(scanner.nextLine());
                            dbSearchFunctions.SearchInPetByInteger(connection,typePet,
                                    valuePetInt);
                        }else {
                            valuePetString = scanner.nextLine();
                            dbSearchFunctions.SearchInPetByString(connection,typePet,
                                    valuePetString);
                        }
                        break;
                    case 33:
                        String typeAppointments, valueAppointmentsString;
                        int valueAppointmentsInt;
                        System.out.print("Name of the column you want to search for (id_employee, id_pet, " +
                                "appointment_time, data, total_cost):");
                        typeAppointments = scanner.nextLine();
                        System.out.print("The value you are searching for: ");
                        if(!typeAppointments.equals("id_employee") && !typeAppointments.equals("id_pet") &&
                        !typeAppointments.equals("total_cost")){
                            valueAppointmentsString = scanner.nextLine();
                            dbSearchFunctions.SearchInAppointmentsByString(connection,typeAppointments,
                                    valueAppointmentsString);
                        }else {
                            valueAppointmentsInt = Integer.parseInt(scanner.nextLine());
                            dbSearchFunctions.SearchInAppointmentsByInteger(connection,typeAppointments,
                                    valueAppointmentsInt);
                        }
                        break;
                    case 34:
                        String typeIntervention, valueInterventionString;
                        int valueInterventionInt;
                        System.out.print("Name of the column you want to search for (id, name, " +
                                "cost): ");
                        typeIntervention = scanner.nextLine();
                        System.out.print("The value you are searching for: ");
                        if(!typeIntervention.equals("id") && !typeIntervention.equals("cost")){
                            valueInterventionString = scanner.nextLine();
                            dbSearchFunctions.SearchInInterventionByString(connection,typeIntervention,
                                    valueInterventionString);
                        }else {
                            valueInterventionInt = Integer.parseInt(scanner.nextLine());
                            dbSearchFunctions.SearchInInterventionByInteger(connection,typeIntervention,
                                    valueInterventionInt);
                        }
                        break;
                    case 35:
                        String typeInterventionProgramming;
                        int valueInterventionProgramming;
                        System.out.print("Name of the column you want to search for (id_employee, " +
                                "id_intervention): ");
                        typeInterventionProgramming = scanner.nextLine();
                        System.out.print("The value you are searching for: ");
                        valueInterventionProgramming = Integer.parseInt(scanner.nextLine());
                        dbSearchFunctions.SearchInInterventionProgramming(connection,
                                typeInterventionProgramming, valueInterventionProgramming);
                        break;
                    case 36:
                        String typeTimetable, valueTimetableString;
                        int valueTimetableInt;
                        System.out.print("Name of the column you want to search for (id, day, " +
                                "start_time, end_time, id_employee): ");
                        typeTimetable = scanner.nextLine();
                        System.out.print("The value you are searching for: ");
                        if(!typeTimetable.equals("id") && !typeTimetable.equals("id_employee")){
                            valueTimetableString = scanner.nextLine();
                            dbSearchFunctions.SearchInTimetableByString(connection,typeTimetable,
                                    valueTimetableString);
                        }else {
                            valueTimetableInt = Integer.parseInt(scanner.nextLine());
                            dbSearchFunctions.SearchInTimetableByInteger(connection,typeTimetable,
                                    valueTimetableInt);
                        }
                        break;
                    case 40:
                        String fieldUpdateEmployee, newDataEmployee, oldDataEmployee;
                        System.out.print("The field you want to update (first_name, last_name, job_type): ");
                        fieldUpdateEmployee = scanner.nextLine();
                        System.out.print("The data you want to replace: ");
                        oldDataEmployee = scanner.nextLine();
                        System.out.print("The data you want to replace with: ");
                        newDataEmployee = scanner.nextLine();
                        dbUpdateFunctions.UpdateString(connection,"employee",fieldUpdateEmployee,
                                oldDataEmployee, newDataEmployee);
                        break;
                    case 41:
                        String fieldUpdateClient, newDataClient, oldDataClient;
                        System.out.print("The field you want to update (first_name, last_name, phone_number): ");
                        fieldUpdateClient = scanner.nextLine();
                        System.out.print("The data you want to replace: ");
                        oldDataClient = scanner.nextLine();
                        System.out.print("The data you want to replace with: ");
                        newDataClient = scanner.nextLine();
                        dbUpdateFunctions.UpdateString(connection,"client",fieldUpdateClient,
                                oldDataClient, newDataClient);
                        break;
                    case 42:
                        String fieldUpdatePet, newStringDataPet, oldStringDataPet;
                        int newIntDataPet, oldIntDataPet;
                        System.out.print("The field you want to update (id_client, type): ");
                        fieldUpdatePet = scanner.nextLine();
                        System.out.print("The data you want to replace: ");
                        if(fieldUpdatePet.equals("type")){
                            oldStringDataPet = scanner.nextLine();
                            System.out.print("The data you want to replace with: ");
                            newStringDataPet = scanner.nextLine();
                            dbUpdateFunctions.UpdateString(connection,"pet",fieldUpdatePet,
                                    oldStringDataPet, newStringDataPet);
                        }else{
                            oldIntDataPet = Integer.parseInt(scanner.nextLine());
                            System.out.print("The data you want to replace with: ");
                            newIntDataPet = Integer.parseInt(scanner.nextLine());
                            dbUpdateFunctions.UpdateInteger(connection,"pet",fieldUpdatePet,
                                    oldIntDataPet, newIntDataPet);
                        }
                        break;
                    case 43:
                        String fieldUpdateAppointments, newStringDataAppointments, oldStringDataAppointments;
                        int newIntDataAppointments, oldIntDataAppointments;
                        System.out.print("The field you want to update (id_employee, id_pet, " +
                                "appointment_time, data, total_cost): ");
                        fieldUpdateAppointments = scanner.nextLine();
                        System.out.print("The data you want to replace: ");
                        if(!fieldUpdateAppointments.equals("id_employee") &&
                                !fieldUpdateAppointments.equals("id_pet") &&
                        !fieldUpdateAppointments.equals("total_cost")){
                            oldStringDataAppointments = scanner.nextLine();
                            System.out.print("The data you want to replace with: ");
                            newStringDataAppointments = scanner.nextLine();
                            dbUpdateFunctions.UpdateString(connection,"appointments",
                                    fieldUpdateAppointments, oldStringDataAppointments, newStringDataAppointments);
                        }else{
                            oldIntDataAppointments = Integer.parseInt(scanner.nextLine());
                            System.out.print("The data you want to replace with: ");
                            newIntDataAppointments = Integer.parseInt(scanner.nextLine());
                            dbUpdateFunctions.UpdateInteger(connection,"appointments",
                                    fieldUpdateAppointments, oldIntDataAppointments, newIntDataAppointments);
                        }
                        break;
                    case 44:
                        String fieldUpdateIntervention, newStringDataIntervention, oldStringDataIntervention;
                        int newIntDataIntervention, oldIntDataIntervention;
                        System.out.print("The field you want to update (name, cost): ");
                        fieldUpdateIntervention = scanner.nextLine();
                        System.out.print("The data you want to replace: ");
                        if(!fieldUpdateIntervention.equals("id") &&
                                !fieldUpdateIntervention.equals("cost")){
                            oldStringDataIntervention = scanner.nextLine();
                            System.out.print("The data you want to replace with: ");
                            newStringDataIntervention = scanner.nextLine();
                            dbUpdateFunctions.UpdateString(connection,"intervention",
                                    fieldUpdateIntervention, oldStringDataIntervention, newStringDataIntervention);
                        }else{
                            oldIntDataIntervention = Integer.parseInt(scanner.nextLine());
                            System.out.print("The data you want to replace with: ");
                            newIntDataIntervention= Integer.parseInt(scanner.nextLine());
                            dbUpdateFunctions.UpdateInteger(connection,"intervention",
                                    fieldUpdateIntervention, oldIntDataIntervention, newIntDataIntervention);
                        }
                        break;
                    case 45:
                        String fieldUpdateInterventionProgramming;
                        int newDataInterventionProgramming, oldDataInterventionProgramming;
                        System.out.print("The field you want to update (id_employee, id_intervention): ");
                        fieldUpdateInterventionProgramming = scanner.nextLine();
                        System.out.print("The data you want to replace: ");
                        oldDataInterventionProgramming = Integer.parseInt(scanner.nextLine());
                        System.out.print("The data you want to replace with: ");
                        newDataInterventionProgramming = Integer.parseInt(scanner.nextLine());
                        dbUpdateFunctions.UpdateInteger(connection,"intervention_programming",
                                fieldUpdateInterventionProgramming, oldDataInterventionProgramming,
                                newDataInterventionProgramming);
                        break;
                    case 46:
                        String fieldUpdateTimetable, newStringDataTimetable, oldStringDataTimetable;
                        int newIntDataTimetable, oldIntDataTimetable;
                        System.out.print("The field you want to update (day, start_time, end_time, id_employee): ");
                        fieldUpdateTimetable = scanner.nextLine();
                        System.out.print("The data you want to replace: ");
                        if(!fieldUpdateTimetable.equals("id_employee")){
                            oldStringDataTimetable = scanner.nextLine();
                            System.out.print("The data you want to replace with: ");
                            newStringDataTimetable = scanner.nextLine();
                            dbUpdateFunctions.UpdateString(connection,"timetable",
                                    fieldUpdateTimetable, oldStringDataTimetable, newStringDataTimetable);
                        }else{
                            oldIntDataTimetable = Integer.parseInt(scanner.nextLine());
                            System.out.print("The data you want to replace with: ");
                            newIntDataTimetable = Integer.parseInt(scanner.nextLine());
                            dbUpdateFunctions.UpdateInteger(connection,"timetable",
                                    fieldUpdateTimetable, oldIntDataTimetable, newIntDataTimetable);
                        }
                        break;
                    case 50:
                        String fieldDeleteEmployee, valueStringEmployee;
                        int valueIntEmployee;
                        System.out.print("The field you want to delete (id, first_name, last_name, job_type): ");
                        fieldDeleteEmployee = scanner.nextLine();
                        System.out.print("The value the field has: ");
                        if(!fieldDeleteEmployee.equals("id")){
                            valueStringEmployee = scanner.nextLine();
                            dbDeleteFunctions.deleteRowByStringValue(connection,"employee",fieldDeleteEmployee,
                                    valueStringEmployee);
                        }else{
                            valueIntEmployee = Integer.parseInt(scanner.nextLine());
                            dbDeleteFunctions.deleteRowByIntegerValue(connection,"employee",fieldDeleteEmployee,
                                    valueIntEmployee);
                        }
                        break;
                    case 51:
                        String fieldDeleteClient, valueStringClient;
                        int valueIntClient;
                        System.out.print("The field you want to delete (id, first_name, last_name, phone_number): ");
                        fieldDeleteClient = scanner.nextLine();
                        System.out.print("The value the field has: ");
                        if(!fieldDeleteClient.equals("id")){
                            valueStringClient = scanner.nextLine();
                            dbDeleteFunctions.deleteRowByStringValue(connection,"client",fieldDeleteClient,
                                    valueStringClient);
                        }else{
                            valueIntClient = Integer.parseInt(scanner.nextLine());
                            dbDeleteFunctions.deleteRowByIntegerValue(connection,"client",fieldDeleteClient,
                                    valueIntClient);
                        }
                        break;
                    case 52:
                        String fieldDeletePet, valueStringPet;
                        int valueIntPet;
                        System.out.print("The field you want to update (id, id_client, type): ");
                        fieldDeletePet = scanner.nextLine();
                        System.out.print("The data with the row you want to delete : ");
                        if(fieldDeletePet.equals("type")){
                            valueStringPet = scanner.nextLine();
                            dbDeleteFunctions.deleteRowByStringValue(connection,"pet",fieldDeletePet,
                                    valueStringPet);
                        }else{
                            valueIntPet = Integer.parseInt(scanner.nextLine());
                            dbDeleteFunctions.deleteRowByIntegerValue(connection,"pet",fieldDeletePet,
                                    valueIntPet);
                        }
                        break;
                    case 53:
                        String fieldDeleteAppointments, stringDataAppointments;
                        int intDataAppointments;
                        System.out.print("The field you want to delete (id_employee, id_pet, " +
                                "appointment_time, data, total_cost): ");
                        fieldDeleteAppointments = scanner.nextLine();
                        System.out.print("The data with the row you want to delete : ");
                        if(!fieldDeleteAppointments.equals("appointment_time")
                        && !fieldDeleteAppointments.equals("data")){
                            intDataAppointments = Integer.parseInt(scanner.nextLine());
                            dbDeleteFunctions.deleteRowByIntegerValue(connection,"appointments",fieldDeleteAppointments,
                                    intDataAppointments);
                        }else{
                            stringDataAppointments = scanner.nextLine();
                            dbDeleteFunctions.deleteRowByStringValue(connection,"appointments",fieldDeleteAppointments,
                                    stringDataAppointments);
                        }
                        break;
                    case 54:
                        String fieldDeleteIntervention, stringDataIntervention;
                        int intDataIntervention;
                        System.out.print("The field you want to delete (id, name, cost): ");
                        fieldDeleteIntervention = scanner.nextLine();
                        System.out.print("The data with the row you want to delete : ");
                        if(!fieldDeleteIntervention.equals("id") && !fieldDeleteIntervention.equals("cost")){
                            stringDataIntervention = scanner.nextLine();
                            dbDeleteFunctions.deleteRowByStringValue(connection,"intervention",fieldDeleteIntervention,
                                    stringDataIntervention);
                        }else{
                            intDataIntervention = Integer.parseInt(scanner.nextLine());
                            dbDeleteFunctions.deleteRowByIntegerValue(connection,"intervention",fieldDeleteIntervention,
                                    intDataIntervention);
                        }
                        break;
                    case 55:
                        String fieldDeleteInterventionProgramming;
                        int intDataInterventionProgramming;
                        System.out.print("The field you want to delete (id_employee, id_intervention): ");
                        fieldDeleteInterventionProgramming = scanner.nextLine();
                        System.out.print("The data with the row you want to delete : ");
                        intDataInterventionProgramming = Integer.parseInt(scanner.nextLine());
                        dbDeleteFunctions.deleteRowByIntegerValue(connection,"intervention_programming",
                                    fieldDeleteInterventionProgramming, intDataInterventionProgramming);
                        break;
                    case 56:
                        String fieldDeleteTimetable, valueStringTimetable;
                        int valueIntTimetable;
                        System.out.print("The field you want to delete (id, day, start_time, end_time, id_employee): ");
                        fieldDeleteTimetable = scanner.nextLine();
                        System.out.print("The value the field has: ");
                        if(!fieldDeleteTimetable.equals("id") && !fieldDeleteTimetable.equals("id_employee")){
                            valueStringTimetable = scanner.nextLine();
                            dbDeleteFunctions.deleteRowByStringValue(connection,"timetable",fieldDeleteTimetable,
                                    valueStringTimetable);
                        }else{
                            valueIntTimetable = Integer.parseInt(scanner.nextLine());
                            dbDeleteFunctions.deleteRowByIntegerValue(connection,"timetable",fieldDeleteTimetable,
                                    valueIntTimetable);
                        }
                        break;
                    default:
                        System.out.println("[WARNING] Please enter a valid option.");
                        break;
                }
            }
        }while(option != 6);
    }
    private static void displayMenu()
    {
        System.out.println("----- MENU -----");
        System.out.println("1. Read from a table");
        System.out.println("2. Insert a row in a table");
        System.out.println("3. Search in a table");
        System.out.println("4. Update a row in a table");
        System.out.println("5. Delete a row in a table");
        System.out.println("6. Exit");
        System.out.println("----------------");
    }
    private static void displayReadMenu()
    {
        System.out.println("----- READ -----");
        System.out.println("10. Read 'employee' table");
        System.out.println("11. Read 'client' table");
        System.out.println("12. Read 'pet' table");
        System.out.println("13. Read 'appointments' table");
        System.out.println("14. Read 'intervention' table");
        System.out.println("15. Read 'intervention_programming' table");
        System.out.println("16. Read 'timetable' table");
        System.out.println("----------------");
    }

    private static void displayInsertMenu()
    {
        System.out.println("----- INSERT -----");
        System.out.println("20. Insert a row in 'employee' table");
        System.out.println("21. Insert a row in 'client' table");
        System.out.println("22. Insert a row in 'pet' table");
        System.out.println("23. Insert a row in 'appointments' table");
        System.out.println("24. Insert a row in 'intervention' table");
        System.out.println("25. Insert a row in 'intervention_programming' table");
        System.out.println("26. Insert a row in 'timetable' table");
        System.out.println("------------------");
    }

    private static void displaySearchMenu()
    {
        System.out.println("----- SEARCH -----");
        System.out.println("30. Search in 'employee' table");
        System.out.println("31. Search in 'client' table");
        System.out.println("32. Search in 'pet' table");
        System.out.println("33. Search in 'appointments' table");
        System.out.println("34. Search in 'intervention' table");
        System.out.println("35. Search in 'intervention_programming' table");
        System.out.println("36. Search in 'timetable' table");
        System.out.println("------------------");
    }

    private static void displayUpdateMenu()
    {
        System.out.println("----- UPDATE -----");
        System.out.println("40. Update a row in 'employee' table");
        System.out.println("41. Update a row in 'client' table");
        System.out.println("42. Update a row in 'pet' table");
        System.out.println("43. Update a row in 'appointments' table");
        System.out.println("44. Update a row in 'intervention' table");
        System.out.println("45. Update a row in 'intervention_programming' table");
        System.out.println("46. Update a row in 'timetable' table");
        System.out.println("------------------");
    }

    private static void displayDeleteMenu()
    {
        System.out.println("----- DELETE -----");
        System.out.println("50. Delete a row in 'employee' table");
        System.out.println("51. Delete a row in 'client' table");
        System.out.println("52. Delete a row in 'pet' table");
        System.out.println("53. Delete a row in 'appointments' table");
        System.out.println("54. Delete a row in 'intervention' table");
        System.out.println("55. Delete a row in 'intervention_programming' table");
        System.out.println("56. Delete a row in 'timetable' table");
        System.out.println("------------------");
    }
}