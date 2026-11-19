package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.transport.masstransit.Fitness as NativeFitness

/** Walking or cycling section data. */
public actual class Fitness internal constructor(
    private val nativeFitness: NativeFitness,
) {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativeFitness = nativeFitness

    /** How the user travels through the section. */
    public actual val type: FitnessType
        get() = nativeFitness.type.toCommon()

    /** Via points projected onto the route. */
    public actual val viaPoints: List<PolylinePosition>
        get() = nativeFitness.viaPoints.map { it.toCommon() }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fitness) return false
        return nativeFitness == other.nativeFitness
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativeFitness.hashCode()
}

/** Wraps this native handle. */
public fun NativeFitness.toCommon(): Fitness = Fitness(this)
