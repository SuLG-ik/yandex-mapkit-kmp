package ru.sulgik.mapkit.geometry

import kotlin.jvm.JvmInline

@JvmInline
value class Longitude(val value: Double) : Comparable<Longitude> {
    override fun compareTo(other: Longitude): Int {
        return value.compareTo(other.value)
    }
}