module ru.kosti.lr_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens ru.kosti.lr_2 to javafx.fxml;
    exports ru.kosti.lr_2;
}