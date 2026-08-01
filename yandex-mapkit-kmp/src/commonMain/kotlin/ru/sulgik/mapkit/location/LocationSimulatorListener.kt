package ru.sulgik.mapkit.location

/**
 * Notifies when a location simulation reaches the end of its route.
 */
public expect abstract class LocationSimulatorListener() {

    /**
     * Simulation is finished.
     */
    public abstract fun onSimulationFinished()
}

public inline fun LocationSimulatorListener(
    crossinline onSimulationFinished: () -> Unit,
): LocationSimulatorListener {
    return object : LocationSimulatorListener() {
        override fun onSimulationFinished() {
            onSimulationFinished.invoke()
        }
    }
}
