package ru.sulgik.mapkit.directions

import ru.sulgik.mapkit.directions.driving.DrivingRouter
import ru.sulgik.mapkit.directions.driving.DrivingRouterType
import ru.sulgik.mapkit.directions.driving.toCommon
import ru.sulgik.mapkit.directions.driving.toNative
import YandexMapKit.YMKDirections as NativeDirections
import YandexMapKit.YMKDirectionsFactory as NativeDirectionsFactory

/** Entry point for driving in the Full MapKit SDK. */
public actual class Directions internal constructor(private val nativeDirections: NativeDirections) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeDirections {
        return nativeDirections
    }

    /** Creates a manager that builds driving routes. */
    public actual fun createDrivingRouter(type: DrivingRouterType): DrivingRouter {
        return nativeDirections.createDrivingRouterWithType(type.toNative()).toCommon()
    }

    /** Tells if this directions object is valid. */
    public actual val isValid: Boolean
        get() = nativeDirections.isValid()

    public actual companion object {

        /** Returns the directions entry point. */
        public actual fun getInstance(): Directions {
            return NativeDirectionsFactory.instance().toCommon()
        }
    }

    /** Two wrappers are equal when they hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Directions) return false
        return nativeDirections == other.nativeDirections
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeDirections.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeDirections.toCommon(): Directions {
    return Directions(this)
}
