package ru.kosti.lr_2.filter

import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.model.Request

class ConfigFilter: AbstractFilterFactory {
    override val next: AbstractFilterFactory
        get() = ValidateFilter()

    override fun doFilter(config: Map<String, String>, request: Request) {

        next.doFilter(config, request)
    }
}