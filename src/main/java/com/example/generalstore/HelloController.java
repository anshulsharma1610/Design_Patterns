package com.example.generalstore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.util.List;

public class HelloController {
    @FXML
    private TextField myTextField; // The TextField you want to update
    @FXML
    private TextArea myTextArea;

    private ItemStore itemStore; // Instance of ItemStore

    public HelloController() {
        // Initialize the ItemStore when the controller is created
        itemStore = new ItemStore("Best Buy");
    }

    @FXML
    private void onAdapterPatternClick() {
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateAdapterPattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }


    @FXML
    private void onBuilderClick() {
//        itemStore.demo("Builder");
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateBuilderPattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }

    @FXML
    private void onCommandClick() {
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateCommandPattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }

    @FXML
    private void onDecoratorClick() {
//        itemStore.demo("Decorator");

    }

    @FXML
    private void onFacadeClick() {
//        itemStore.demo("Facade");
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateFacadePattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }

    @FXML
    private void onFactoryClick() {
//        itemStore.demo("Factory");
        myTextArea.setText("Factory Pattern Information");
    }

    @FXML
    private void onObserverClick() {
//        itemStore.demo("Observer");
        myTextArea.setText("Observer Pattern Information");
    }

    @FXML
    private void onPrototypeClick() {
//        itemStore.demo("Prototype");
        myTextArea.setText("Prototype Pattern Information");
    }

    @FXML
    private void onStateClick() {
//        itemStore.demo("State");
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateStatePattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }
}