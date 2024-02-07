package ru.kosti.lr_2.filter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ru.kosti.lr_2.abstractfactory.AbstractFilterFactory
import ru.kosti.lr_2.exception.ConfigException
import ru.kosti.lr_2.model.Request
import java.io.InputStream
import java.util.*

class ConfigFilter : AbstractFilterFactory {
    private val mapper = jacksonObjectMapper()
    private val inputStream: InputStream? = object {}.javaClass.getResourceAsStream("/config.json")
    private val configMap = inputStream?.use { stream ->
        Scanner(stream)
            .useDelimiter("\\A")
            .next()
            .let { mapper.readValue<Map<String, String>>(it) }
    } ?: mapOf(
        "user" to "user"
    )

    override val next: AbstractFilterFactory
        get() = ValidateFilter()

    override fun doFilter(config: Map<String, String>?, request: Request) {
        val path = request.path
        val role = configMap[path] ?: throw ConfigException("Path not found in config file")
        next.doFilter(
            mapOf(
                "role" to role
            ), request
        )
    }
}