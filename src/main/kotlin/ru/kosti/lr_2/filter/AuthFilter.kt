package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request
import ru.kosti.lr_2.service.AuthService

class AuthFilter(
    private val authService: AuthService = AuthService()
): AbstractFilterFactory {

    override fun doFilter(config: Map<String, String>?, request: Request) {
        authService.auth(request.key)
        next?.doFilter(config, request)
    }
}