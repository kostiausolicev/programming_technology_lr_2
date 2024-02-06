package ru.kosti.lr_2.abstractfactory

import ru.kosti.lr_2.model.Request

interface AbstractFilterFactory {
    val next: AbstractFilterFactory?

    fun doFilter(config: Map<String, String>, request: Request)
}