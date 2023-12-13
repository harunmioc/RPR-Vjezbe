package com.example.tutorijal6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 240, 320);
        stage.setTitle("Kalkulator");
        stage.setScene(scene);
        stage.setMinHeight(320);
        stage.setMinWidth(240);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}