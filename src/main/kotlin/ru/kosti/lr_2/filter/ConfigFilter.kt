package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request

class ConfigFilter: AbstractFilterFactory {
    private val configMap = mapOf(
        "user" to "user",
        "admin" to "admin"
    )

    override val next: AbstractFilterFactory
        get() = ValidateFilter()

    override fun doFilter(config: Map<String, String>, request: Request) {
        val path = request.path
        val role = configMap[path] ?: throw Exception()
        next.doFilter(mapOf(
            "role" to role
        ), request)
    }
}