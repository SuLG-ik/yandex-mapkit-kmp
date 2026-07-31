package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.PolylinePosition

/**
 * Replays a route as if the device were driving it.
 */
public expect class LocationSimulator {

    /**
     * The speed of the simulation in meters per second.
     */
    public var speed: Double

    /**
     * The legs of the simulation.
     */
    public var settings: List<SimulationSettings>

    /**
     * Subscribes to simulation events.
     *
     * The class does not retain the object in the 'simulatorListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun subscribeForSimulatorEvents(simulatorListener: WeakRef<LocationSimulatorListener>)

    /**
     * Unsubscribes from simulation events.
     */
    public fun unsubscribeFromSimulatorEvents(simulatorListener: WeakRef<LocationSimulatorListener>)

    /**
     * Start simulation.
     */
    public fun startSimulation(settings: List<SimulationSettings>)

    /**
     * Stop simulation.
     */
    public fun stopSimulation()

    /**
     * The position of the polyline.
     */
    public fun polylinePosition(): PolylinePosition

    /**
     * True if simulator is not suspended.
     */
    public val isActive: Boolean
}
