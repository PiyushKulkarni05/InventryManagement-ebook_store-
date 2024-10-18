package com.example.inventry_management_oop;

import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    public static boolean placeorder(Customer customer,Product product){
    String grouporderID = "SELECT max(group_order_id) +1 id FROM orders";
        //String placeOrder="INSERT INTO orders(customer_id,product_id) VALUES("+customer.getId()+ ",+product.getId()+")";
    DBConnection dbConnection = new DBConnection();
    try{
        ResultSet rs = dbConnection.getQueryTable(grouporderID);
        if(rs.next()){
         String placeOrder="INSERT INTO orders(group_order_id,customer_id,product_id) VALUES("+rs.getInt("id")+","+customer.getId()+","+ product.getId()+");";
         return dbConnection.updateDatabase(placeOrder)!=0;
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return false;
    }
    public static int placeMultipleorder(Customer customer, ObservableList<Product>productlist){
        String grouporderID = "SELECT max(group_order_id) +1 id FROM orders";
        //String placeOrder="INSERT INTO orders(customer_id,product_id) VALUES("+customer.getId()+ ",+product.getId()+")";
        DBConnection dbConnection = new DBConnection();
        try{
            ResultSet rs = dbConnection.getQueryTable(grouporderID);
            int count = 0;
            if(rs.next()){
                for(Product product:productlist){
                    String placeOrder="INSERT INTO orders(group_order_id,customer_id,product_id) VALUES("+rs.getInt("id")+","+customer.getId()+","+ product.getId()+");";
                    count=dbConnection.updateDatabase(placeOrder);
                }
                return count;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
