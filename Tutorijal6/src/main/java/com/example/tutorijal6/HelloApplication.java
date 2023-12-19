package com.example.tutorijal6;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 240, 320);

        stage.setTitle("Kalkulator");
        stage.setScene(scene);
        stage.setMinHeight(320);
        stage.setMinWidth(240);
        stage.show();

        HelloController controller = fxmlLoader.getController();
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controller.numFromKeyboard(event.getCode().toString());
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}