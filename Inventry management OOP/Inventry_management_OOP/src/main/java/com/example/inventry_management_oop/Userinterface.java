
package com.example.inventry_management_oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Userinterface {
    GridPane loginpage;
    HBox Headerbar;
    Button signInButton;
    Label welcomelabel;
    Customer loggedInCustomer;
    ProductList productList = new ProductList();
    VBox productpage;
    VBox body;
    HBox footerbar;
    ObservableList<Product> itemsincart = FXCollections.observableArrayList();
    Button placeorderbutton = new Button("Place Order");
    Button CartButton;
    Button homeButton;

    public BorderPane createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 600);
        root.setTop(Headerbar);
        body = new VBox();
        body.setPadding(new Insets(10));
        body.setAlignment(Pos.CENTER);
        root.setCenter(body);
        productpage = productList.getDummyTable();
        body.getChildren().add(productpage);
        root.setBottom(footerbar);
        return root;
    }

    public Userinterface() {
        createloginPage();
        createheaderbar();
        createFooterBar();
    }

    private void createloginPage() {
        Text usernameText = new Text("User name:");
        Text passwordText = new Text("Password :");
        TextField username = new TextField();
        username.setPromptText("Type your user name here");
        PasswordField password = new PasswordField();
        password.setPromptText("Type your password here");
        Label messageLabel = new Label("Hello..");
        Button loginButton = new Button("Login");
        loginpage = new GridPane();
        loginpage.setAlignment(Pos.CENTER);
        loginpage.setPadding(new Insets(10, 10, 10, 10));
        loginpage.setVgap(10);
        loginpage.setHgap(10);
        loginpage.add(usernameText, 0, 0);
        loginpage.add(username, 1, 0);
        loginpage.add(passwordText, 0, 1);
        loginpage.add(password, 1, 1);
        loginpage.add(messageLabel, 0, 2);
        loginpage.add(loginButton, 1, 2);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = username.getText();
                String pass = password.getText();
                Login login = new Login();
                loggedInCustomer = login.customerLogin(name, pass);
                if (loggedInCustomer != null) {
                    messageLabel.setText("Welcome: " + loggedInCustomer.getName());
                    welcomelabel.setText("Welcome:" + loggedInCustomer.getName());
                    Headerbar.getChildren().add(welcomelabel);
                    body.getChildren().clear();
                    body.getChildren().add(productpage);
                } else {
                    messageLabel.setText("Login Failed ");
                }
            }
        });
    }

    private void createheaderbar() {
        homeButton = new Button();
        Image image = new Image("file:///E:/Inventry management OOP/Inventry_management_OOP/src/homeicon.jpg");

        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(30);
        homeButton.setGraphic(imageView);


        TextField searchbar = new TextField();
        searchbar.setPromptText("Search here..");
        searchbar.setPrefWidth(300);
        Button searchButton = new Button("Search");
        signInButton = new Button("Sign-In");
        welcomelabel = new Label();
        CartButton = new Button("Cart");
        Headerbar = new HBox(20);
        Headerbar.setPadding(new Insets(10));
        Headerbar.setSpacing(10);
        Headerbar.setAlignment(Pos.CENTER);
        Headerbar.getChildren().addAll(homeButton,searchbar, searchButton, signInButton, CartButton);
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                body.getChildren().add(loginpage);
                Headerbar.getChildren().remove(signInButton);
            }
        });
    }

    private void createFooterBar() {
        Button BuyNow = new Button("Add to Cart");
        footerbar = new HBox();
        footerbar.setPadding(new Insets(10));
        footerbar.setSpacing(10);
        footerbar.setAlignment(Pos.CENTER);
        footerbar.getChildren().addAll(BuyNow);
        BuyNow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product product = productList.getSelectedProduct();
                if (product == null) {
                    showDialog("Please select a product first");
                    return;
                }
                if (loggedInCustomer == null) {
                    showDialog("Please log in first");
                    return;
                }
                itemsincart.add(product); // Add the selected product to the cart
                showDialog("Selected item added to cart successfully");
            }
        });
        CartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                VBox prodpage = productList.getProductsInCart(itemsincart);
                prodpage.setAlignment(Pos.CENTER);
                prodpage.setSpacing(10);
                prodpage.getChildren().add(placeorderbutton);
                body.getChildren().add(prodpage);
                footerbar.setVisible(false);//footer gets off
            }
        });

        placeorderbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (itemsincart == null) {
                    showDialog("Please select a product first");
                    return;
                }
                if (loggedInCustomer == null) {
                    showDialog("Please log in first");
                    return;
                }
                int count =Order.placeMultipleorder(loggedInCustomer,itemsincart);
                if(count!=0){
                    showDialog("Order for "+(count+1)+" products placed Successfully");
            }
                else{
                    showDialog("Order Failed..");
                }
            }
        });
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                body.getChildren().add(productpage);
                footerbar.setVisible(true);
                if(loggedInCustomer==null && Headerbar.getChildren().indexOf(signInButton)==-1){

                        Headerbar.getChildren().add(signInButton);

                }
            }
        });

    }

    private void showDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setTitle("Message");
        alert.showAndWait();
    }
}


