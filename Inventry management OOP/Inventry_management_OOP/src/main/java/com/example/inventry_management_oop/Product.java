package com.example.inventry_management_oop;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Product {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty author;
    private SimpleDoubleProperty price;

    public Product(int id, String name,String author, Double price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.author = new SimpleStringProperty(author);
        this.price = new SimpleDoubleProperty(price);
    }
    public static ObservableList<Product> getAllProducts(){
        String selectAllProducts = "SELECT id,name,author,price FROM product;";

        return fetchProductData(selectAllProducts);
    }
    public static ObservableList<Product> fetchProductData(String query){
        ObservableList<Product> data = FXCollections.observableArrayList();
        DBConnection dbconnection = new DBConnection();
        try {
            ResultSet rs = dbconnection.getQueryTable(query);
            while (rs.next()){
                Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("author"),rs.getDouble("price"));
                data.add(product);
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int getId() {
        return id.get();
    }
    public String getName() {
        return name.get();
    }
    public String getAuthor() {
        return author.get();
    }
    public double getPrice() {
        return price.get();
    }

}
