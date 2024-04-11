package com.neds.otachallenge.data.enums

enum class LevelState(
    val value: String
) {
    Available("AVAILABLE"),
    Locked("LOCKED");

    companion object {

        operator fun get(value: String): LevelState? = values().firstOrNull { it.value == value }
    }
}