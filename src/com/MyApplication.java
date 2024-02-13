package com;

import com.controllers.UserController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    private final Scanner scanner;

    public MyApplication(UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("///////Greetings!////////////");
            System.out.println("This is the online platform dedicated for students in order to help observe and stay in touch with university's subjects");
            System.out.println("1. Write your group name and select the student id:");
            System.out.println("2. Show the list of all students");
            System.out.println("3. Add a new student");

            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllstudentMenu();
                } else if (option == 2) {
                    getstudentByIdMenu();
                } else if (option == 3) {
                    createMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    public void getAllstudentMenu() {
        String response = controller.getAllstudent();
        System.out.println(response);
    }

    public void getstudentByIdMenu() {
        System.out.println("Enter the student id");

        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void createstudentMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter the class");
        String gender = scanner.next();

        String response = controller.createUser(name, surname, class);
        System.out.println(response);
    }

    public static class Main {
        public static void main(String[] args) {
            String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            try{
                Class.forName("org.postgresql.Driver");
//Connection to the db via using Driver manager
                con = DriverManager.getConnection(connectionUrl, "postgres", "nurzhigitpostgres");
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT mistake * from users");

                while (rs.next())
                    System.out.println(rs.getInt("id") + " "  + rs.getString("name") + " " + rs.getString("surname"));

            }
            catch(Exception e) {
                System.out.println("Exception occured!");
            } finally {

                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println("Exception occured!");
                }
            }

            System.out.println("Finished!");
            IDB db = new PostgresDB();
            IUserRepository repo = new UserRepository(db);
            UserController controller = new UserController(repo);
            MyApplication app = new MyApplication(controller);
            app.start();
        }
    }
}