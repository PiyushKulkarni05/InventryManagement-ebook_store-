module com.example.inventry_management_oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.inventry_management_oop to javafx.fxml;
    exports com.example.inventry_management_oop;
}