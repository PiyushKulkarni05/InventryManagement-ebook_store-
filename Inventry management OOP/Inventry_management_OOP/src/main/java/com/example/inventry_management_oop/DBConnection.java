
package com.example.inventry_management_oop;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private final String dburl = "jdbc:mysql://localhost:3307/inventry";
//    private final String dburl = "jdbc:mysql://localhost:YOUR_PORT/inventry";

    private final String userName = "root";
    private final String password = "W7301@jqir#";
private Statement getStatement() throws SQLException {
    Connection connection = DriverManager.getConnection(dburl, userName, password);
    return connection.createStatement();
}


    public ResultSet getQueryTable(String query) {
        try {
            Statement statement = getStatement();
            if (statement != null) {
                return statement.executeQuery(query);
            } else {
                System.out.println("Statement creation failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int updateDatabase(String query){
    try{
        Statement statement = getStatement();
        return statement.executeUpdate(query);
    }catch (Exception e){
        e.printStackTrace();
    }
    return 0;
    }

    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        ResultSet rs = conn.getQueryTable("SELECT * FROM customer1");

        if (rs != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Connection failed");
        }
    }
}

//import java.sql.*;
//
//public class DBConnection {
//    private final String dburl = "jdbc:mysql://localhost:3307/inventry_management";
//    private final String userName = "root";
//    private final String password = "W7301@jqir#";
//
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private Statement getStatement() throws SQLException {
//        Connection connection = DriverManager.getConnection(dburl, userName, password);
//        return connection.createStatement();
//    }
//
//    public ResultSet getQueryTable(String query) {
//        try {
//            Statement statement = getStatement();
//            if (statement != null) {
//                return statement.executeQuery(query);
//            } else {
//                System.out.println("Statement creation failed.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public int updateDatabase(String query) {
//        try {
//            Statement statement = getStatement();
//            return statement.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        DBConnection conn = new DBConnection();
//        ResultSet rs = conn.getQueryTable("SELECT * FROM customer1");
//        if (rs != null) {
//            try {
//                while (rs.next()) {
//                    System.out.println("Customer Name: " + rs.getString("name"));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Connection failed");
//        }
//    }
//}


