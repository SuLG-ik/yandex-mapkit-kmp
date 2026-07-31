package ru.sulgik.mapkit.location

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKLocationSimulatorListenerProtocol as NativeLocationSimulatorListener

/**
 * Notifies when a location simulation reaches the end of its route.
 */
public actual abstract class LocationSimulatorListener actual constructor() : NativeConvertible<NativeLocationSimulatorListener> {

    private val nativeListener = object : NativeLocationSimulatorListener, NSObject() {
        override fun onSimulationFinished() {
            this@LocationSimulatorListener.onSimulationFinished()
        }
    }

    override fun toNative(): NativeLocationSimulatorListener {
        return nativeListener
    }

    /**
     * Simulation is finished.
     */
    public actual abstract fun onSimulationFinished()
}
