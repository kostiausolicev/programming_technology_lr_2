package ru.kosti.lr_2.abstractfactory

import ru.kosti.lr_2.model.Request

interface AbstractFilterFactory {
    val next: AbstractFilterFactory?
        get() = null

    fun doFilter(config: Map<String, Int>?, request: Request)
}