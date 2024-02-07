package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.exception.ValidateException
import ru.kosti.lr_2.model.Request
import java.time.Instant

class ValidateFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory
        get() = RoleCheckFilter()

    override fun doFilter(config: Map<String, Int>?, request: Request) {
        if ((request.date.time / 1000) > Instant.now().epochSecond)
            throw ValidateException()
        next.doFilter(config, request)
    }
}
