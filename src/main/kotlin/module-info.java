module ru.kosti.lr_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;
    requires com.fasterxml.jackson.module.kotlin;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens ru.kosti.lr_2.controller to javafx.fxml;
    exports ru.kosti.lr_2;
}
