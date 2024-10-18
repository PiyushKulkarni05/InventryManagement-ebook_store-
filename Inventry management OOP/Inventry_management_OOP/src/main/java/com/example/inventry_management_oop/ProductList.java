package com.example.inventry_management_oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductList {
    private TableView<Product> productTable;
    VBox createTable(ObservableList<Product> data){
        //column
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn author = new TableColumn("Author");
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Data

        productTable = new TableView<>();
        productTable.setItems(data);
        productTable.getColumns().addAll(id,name,author,price);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox vbox = new VBox();
        vbox.setPadding((new Insets(10)));
        vbox.getChildren().addAll(productTable);
        return vbox;
    }
    public VBox getDummyTable(){
        ObservableList<Product> data =FXCollections.observableArrayList();
        data.add(new Product(1,"To Kill a Mockingbird", "Harper Lee", 1200.0));
        data.add(new Product(2,"1984", "George Orwell", 1100.0));
        data.add(new Product(3,"The Great Gatsby", "F. Scott Fitzgerald", 1000.0));
        data.add(new Product(4,"Pride and Prejudice", "Jane Austen", 900.0));
        data.add(new Product(5,"The Catcher in the Rye", "J.D. Salinger", 1300.0));
        data.add(new Product(6,"The Silent Patient", "Herman Melville", 1400.0));
        data.add(new Product(7,"The Lord of the Rings", "J.R.R. Tolkien", 1900.0));
        data.add(new Product(8,"The Road", "Cormac McCarthy", 1200.0));
        data.add(new Product(9,"Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1600.0));
        data.add(new Product(10,"The Alchemist", "Paulo Coelho", 1400.0));
        data.add(new Product(11,"Brave New World", "Aldous Huxley", 1100.0));
        data.add(new Product(12,"The Hobbit", "J.R.R. Tolkien", 1300.0));
        data.add(new Product(13,"Fahrenheit 451", "Ray Bradbury", 1000.0));
        data.add(new Product(14,"The Book Thief", "Markus Zusak", 1700.0));
        data.add(new Product(15,"Dune", "Frank Herbert", 1800.0));
        return createTable(data);
    }
    public VBox getAllProducts(){
        ObservableList<Product> data = Product.getAllProducts();
        return createTable(data);
    }
    public Product getSelectedProduct() {
        return productTable.getSelectionModel().getSelectedItem(); // use getSelectedItem instead of getSelectedItems
    }
    public VBox getProductsInCart(ObservableList<Product> data){
        return createTable(data);
    }

}
