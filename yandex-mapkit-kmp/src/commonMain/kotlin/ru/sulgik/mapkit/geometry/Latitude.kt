package ru.sulgik.mapkit.geometry

import kotlin.jvm.JvmInline

@JvmInline
public value class Latitude(public val value: Double) : Comparable<Latitude> {
    override fun compareTo(other: Latitude): Int {
        return value.compareTo(other.value)
    }
}
