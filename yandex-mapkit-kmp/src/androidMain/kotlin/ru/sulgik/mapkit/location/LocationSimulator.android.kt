package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.location.LocationSimulator as NativeLocationSimulator

/**
 * Replays a route as if the device were driving it.
 */
public actual class LocationSimulator internal constructor(
    private val nativeLocationSimulator: NativeLocationSimulator,
) {

    public fun toNative(): NativeLocationSimulator {
        return nativeLocationSimulator
    }

    public actual var speed: Double
        get() = nativeLocationSimulator.speed
        set(value) {
            nativeLocationSimulator.speed = value
        }

    public actual var settings: List<SimulationSettings>
        get() = nativeLocationSimulator.settings.map { it.toCommon() }
        set(value) {
            nativeLocationSimulator.settings = value.map { it.toNative() }
        }

    public actual fun subscribeForSimulatorEvents(simulatorListener: WeakRef<LocationSimulatorListener>) {
        nativeLocationSimulator.subscribeForSimulatorEvents(simulatorListener.toNative())
    }

    public actual fun unsubscribeFromSimulatorEvents(simulatorListener: WeakRef<LocationSimulatorListener>) {
        nativeLocationSimulator.unsubscribeFromSimulatorEvents(simulatorListener.toNative())
    }

    public actual fun startSimulation(settings: List<SimulationSettings>) {
        nativeLocationSimulator.startSimulation(settings.map { it.toNative() })
    }

    public actual fun stopSimulation() {
        nativeLocationSimulator.stopSimulation()
    }

    public actual fun polylinePosition(): PolylinePosition {
        return nativeLocationSimulator.polylinePosition().toCommon()
    }

    public actual val isActive: Boolean
        get() = nativeLocationSimulator.isActive
}

public fun NativeLocationSimulator.toCommon(): LocationSimulator {
    return LocationSimulator(this)
}
