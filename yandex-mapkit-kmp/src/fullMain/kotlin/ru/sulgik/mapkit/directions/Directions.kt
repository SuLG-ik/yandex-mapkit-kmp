package ru.sulgik.mapkit.directions

import ru.sulgik.mapkit.directions.driving.DrivingRouter
import ru.sulgik.mapkit.directions.driving.DrivingRouterType

/** Entry point for driving in the Full MapKit SDK. */
public expect class Directions {

    /** Creates a manager that builds driving routes. */
    public fun createDrivingRouter(type: DrivingRouterType): DrivingRouter

    /** Tells if this directions object is valid. */
    public val isValid: Boolean

    public companion object {

        /** Returns the directions entry point. */
        public fun getInstance(): Directions
    }

    /** Two wrappers are equal when they hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
