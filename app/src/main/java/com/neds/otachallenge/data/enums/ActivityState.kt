package com.neds.otachallenge.data.enums

enum class ActivityState(val value: String) {
    Practice("PRACTICE"), Commit("COMMIT");

    companion object {
        operator fun get(value: String): ActivityState? = values().firstOrNull { it.value == value }
    }
}