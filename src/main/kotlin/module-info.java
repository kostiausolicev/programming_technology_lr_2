module ru.kosti.lr_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;


    opens ru.kosti.lr_2.controller to javafx.fxml;
    exports ru.kosti.lr_2;
}