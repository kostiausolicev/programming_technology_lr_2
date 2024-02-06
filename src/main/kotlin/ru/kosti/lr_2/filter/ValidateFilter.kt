package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request

class ValidateFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory
        get() = AuthFilter()

    override fun doFilter(config: Map<String, String>, request: Request) {
        next.doFilter(config, request)
    }
}