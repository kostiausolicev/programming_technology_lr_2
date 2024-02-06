package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request

class RoleCheckFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory?
        get() = null

    override fun doFilter(config: Map<String, String>, request: Request) {
        next?.doFilter(config, request)
    }
}