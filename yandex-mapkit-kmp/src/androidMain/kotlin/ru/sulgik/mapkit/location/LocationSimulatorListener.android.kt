package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.location.LocationSimulatorListener as NativeLocationSimulatorListener

/**
 * Notifies when a location simulation reaches the end of its route.
 */
public actual abstract class LocationSimulatorListener actual constructor() : NativeConvertible<NativeLocationSimulatorListener> {

    private val nativeListener = NativeLocationSimulatorListener { onSimulationFinished() }

    override fun toNative(): NativeLocationSimulatorListener {
        return nativeListener
    }

    /**
     * Simulation is finished.
     */
    public actual abstract fun onSimulationFinished()
}
