package ru.kosti.lr_2.enumeration

enum class Roles(
    val value: String,
    val permission: Int,
) {
    USER("user", 0),
    ADMIN("admin", Int.MAX_VALUE);

    companion object {
        fun findByValue(value: String): Roles? {
            return values().find { it.value == value }
        }
    }
}