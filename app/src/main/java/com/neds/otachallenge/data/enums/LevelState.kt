package com.neds.otachallenge.data.enums

enum class LevelState(
    val value: String
) {
    Available("AVAILABLE"), Locked("LOCKED"), Unknown("UNKNOWN");

    companion object {

        operator fun get(value: String): LevelState =
            values().firstOrNull { it.value == value } ?: Unknown
    }
}