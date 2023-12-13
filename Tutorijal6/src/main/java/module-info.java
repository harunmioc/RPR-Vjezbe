module com.example.tutorijal6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tutorijal6 to javafx.fxml;
    exports com.example.tutorijal6;
}