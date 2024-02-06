package ru.kosti.lr_2.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import ru.kosti.lr_2.filter.ConfigFilter
import ru.kosti.lr_2.model.Request
import java.sql.Timestamp

class HelloController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    fun onHelloButtonClick() {
        val request = Request(
            "secret key",
            "admin",
            "admin",
            Timestamp(System.currentTimeMillis())
        )
        val filter = ConfigFilter()
        filter.doFilter(null, request)
        welcomeText.text = "Welcome to JavaFX Application!"
    }
}