package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request

class AuthFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory
        get() = RoleCheckFilter()

    override fun doFilter(config: Map<String, String>, request: Request) {

        next.doFilter(config, request)
    }
}