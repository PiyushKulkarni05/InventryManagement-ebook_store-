package com.example.inventry_management_oop;

import java.sql.ResultSet;
import java.sql.SQLOutput;

public class Login {
    public Customer customerLogin(String username,String password){
        String query = "SELECT * FROM customer1 WHERE email ='"+username+ "' AND password = '" +password+"'";
        DBConnection connection = new DBConnection();
        try{
            ResultSet rs =connection.getQueryTable(query);
            if(rs.next()) {
                return new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("mobile"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Login login = new Login();
        Customer customer = login.customerLogin("piyushvjkulkarni2005@gmail.com","abc123");
        System.out.println("Welcome:"+customer.getName());
        //System.out.println(login.customerLogin("piyushvjkulkarni2005@gmail.com","abc123"));
    }
}
