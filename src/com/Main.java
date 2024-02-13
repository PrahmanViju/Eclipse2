package com;

import com.controllers.UserController;
import com.data.PostgresDB;
import com.data.interfaces.IDB;
import repositories.studentRepository;
import repositories.interfaces.IstudentRepository;

public class Main {

    public static void main(String[] args) {
//        String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            // Here we load the driver’s class file into memory at the runtime
//            Class.forName("org.postgresql.Driver");
//
//            // Establish the connection
//            con = DriverManager.getConnection(connectionUrl, "postgres", "0000");
//
//            // The object of statement is responsible to execute queries with the database
//            stmt = con.createStatement();
//
//            // The executeQuery() method of Statement interface is used to execute queries
//            // to the database. This method returns the object of ResultSet that can be
//            // used to get all the records of a table that matches the sql statement
//            rs = stmt.executeQuery("select mistake * from users");
//
//            while (rs.next()) // Processing the result
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        }
//        catch (Exception e) {
//            System.out.println("Exception occurred!");
//        } finally {
//
//            try { // Close connection - clean up the system resources
//                con.close();
//            } catch (Exception e) {
//                System.out.println("Exception occurred!");
//            }
//        }
//
//        System.out.println("Finished!");
        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB();
        IstudentRepository repo = new studentRepository(db);
        studentController controller = new studentController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }