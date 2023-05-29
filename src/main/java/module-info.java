module com.example.mainproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.mainproject to javafx.fxml;
    exports com.example.mainproject;
}