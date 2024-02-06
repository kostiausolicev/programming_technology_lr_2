package ru.kosti.lr_2.model

import java.sql.Timestamp

data class Request(
    val key: String,
    val path: String,
    val role: String,
    val date: Timestamp
)