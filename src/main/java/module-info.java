module com.example.generalstore {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.logging;

    opens com.example.generalstore to javafx.fxml;
    exports com.example.generalstore;
}