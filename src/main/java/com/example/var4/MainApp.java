package com.example.var4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main_view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Генератор персонажей RPG");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}