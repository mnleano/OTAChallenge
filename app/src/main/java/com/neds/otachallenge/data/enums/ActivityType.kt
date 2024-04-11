package com.neds.otachallenge.data.enums

enum class ActivityType(val value: String) {
    Practice("PRACTICE"), Commit("COMMIT"), Unknown("UNKNOWN");

    companion object {
        operator fun get(value: String): ActivityType =
            values().firstOrNull { it.value == value } ?: Unknown
    }
}