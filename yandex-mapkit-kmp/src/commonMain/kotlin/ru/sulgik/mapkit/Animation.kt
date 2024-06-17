package ru.sulgik.mapkit

import kotlin.time.Duration

data class Animation(
    val type: Type,
    val duration: Duration,
) {
    enum class Type {
        SMOOTH, LINEAR
    }
}