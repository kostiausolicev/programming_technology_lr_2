package ru.kosti.lr_2.service

class AuthService {
    fun auth(key: String) {
        if (key != "secret key")
            throw Exception()
    }
}