package ru.kosti.lr_2

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.ComboBox
import javafx.stage.Stage
import ru.kosti.lr_2.enumeration.Roles

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 340.0, 340.0)
        val comboBox = scene.lookup("#roleCombobox") as ComboBox<String>
        comboBox.items.addAll(listOf(Roles.ADMIN.value, Roles.USER.value))
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}