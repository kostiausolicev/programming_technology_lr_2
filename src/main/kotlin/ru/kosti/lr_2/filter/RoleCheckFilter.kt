package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.exception.RoleCheckException
import ru.kosti.lr_2.model.Request

class RoleCheckFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory
        get() = AuthFilter()

    override fun doFilter(config: Map<String, Int>?, request: Request) {
        config ?: throw Exception()
        if (config["role"]!! > request.role)
            throw RoleCheckException()
        next.doFilter(config, request)
    }
}