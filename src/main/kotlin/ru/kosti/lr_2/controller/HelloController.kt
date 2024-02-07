package ru.kosti.lr_2.controller

import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import ru.kosti.lr_2.enumeration.Roles
import ru.kosti.lr_2.filter.ConfigFilter
import ru.kosti.lr_2.model.Request
import java.sql.Timestamp

class HelloController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private lateinit var path: TextField

    @FXML
    private lateinit var secretKey: PasswordField

    @FXML
    private lateinit var roleCombobox: ComboBox<String>

    @FXML
    fun onHelloButtonClick() =
        try {
            val request = Request(
                secretKey.text,
                path.text,
                Roles.findByValue(roleCombobox.value)?.permission ?: -1,
                Timestamp(System.currentTimeMillis())
            )
            ConfigFilter().doFilter(null, request)
            welcomeText.text = "Welcome to JavaFX Application!"
        } catch (e: NullPointerException) {
            welcomeText.style = "-fx-text-fill: red;"
            welcomeText.text = "The form was filled in incorrectly"
        } catch (e: Exception) {
            welcomeText.style = "-fx-text-fill: red;"
            welcomeText.text = e.message
        }
}
