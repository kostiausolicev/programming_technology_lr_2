package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request
import java.time.Instant

class ValidateFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory
        get() = RoleCheckFilter()

    override fun doFilter(config: Map<String, String>, request: Request) {
        if (request.date.timestamp.time > Instant.now().epochSecond)
            throw Exception()
        next.doFilter(config, request)
    }
}