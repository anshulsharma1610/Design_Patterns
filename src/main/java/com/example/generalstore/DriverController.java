package com.example.generalstore;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.util.List;

public class DriverController {
    @FXML
    private TextField myTextField; // The TextField you want to update
    @FXML
    private TextArea myTextArea;

    private ItemStore itemStore; // Instance of ItemStore

    public DriverController() {
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
    }

    @FXML
    private void onFacadeClick() {
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
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateFactoryPattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }

    @FXML
    private void onObserverClick() {
        myTextArea.setText("Observer Pattern Information");
    }

    @FXML
    private void onPrototypeClick() {
        myTextArea.setText("Prototype Pattern Information");
    }

    @FXML
    private void onStateClick() {
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateStatePattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }

    @FXML
    private void onStrategyClick() {
        myTextArea.clear();
        List<String> outputList = itemStore.demonstrateStrategyPattern();
        StringBuilder formattedData = new StringBuilder();
        for (String line : outputList) {
            formattedData.append(line).append("\n");
        }
        myTextArea.setText(formattedData.toString());
    }
}