package ru.sulgik.mapkit.geometry

import kotlin.jvm.JvmInline

@JvmInline
value class Latitude(val value: Double) : Comparable<Latitude> {
    override fun compareTo(other: Latitude): Int {
        return value.compareTo(other.value)
    }
}
