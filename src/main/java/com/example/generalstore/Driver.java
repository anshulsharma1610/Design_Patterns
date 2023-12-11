package com.example.generalstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final String ITEM_FILE = "src/main/java/com/example/generalstore/output/items.csv";
        FileUtil.newFile(ITEM_FILE);
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}