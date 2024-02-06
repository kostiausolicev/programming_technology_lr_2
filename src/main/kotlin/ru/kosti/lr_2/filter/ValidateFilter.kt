package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request

class ValidateFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory
        get() = AuthFilter()

    override fun doFilter(request: Request) {
        next.doFilter(request)
    }
}