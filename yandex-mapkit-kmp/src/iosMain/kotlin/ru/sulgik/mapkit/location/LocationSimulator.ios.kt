package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKLocationSimulator as NativeLocationSimulator
import YandexMapKit.YMKSimulationSettings as NativeSimulationSettings

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

    @Suppress("UNCHECKED_CAST")
    public actual var settings: List<SimulationSettings>
        get() = (nativeLocationSimulator.settings as List<NativeSimulationSettings>).map { it.toCommon() }
        set(value) {
            nativeLocationSimulator.settings = value.map { it.toNative() }
        }

    public actual fun subscribeForSimulatorEvents(simulatorListener: WeakRef<LocationSimulatorListener>) {
        nativeLocationSimulator.subscribeForSimulatorEventsWithSimulatorListener(
            simulatorListener.toNative() ?: return,
        )
    }

    public actual fun unsubscribeFromSimulatorEvents(simulatorListener: WeakRef<LocationSimulatorListener>) {
        nativeLocationSimulator.unsubscribeFromSimulatorEventsWithSimulatorListener(
            simulatorListener.toNative() ?: return,
        )
    }

    public actual fun startSimulation(settings: List<SimulationSettings>) {
        nativeLocationSimulator.startSimulationWithSettings(settings.map { it.toNative() })
    }

    public actual fun stopSimulation() {
        nativeLocationSimulator.stopSimulation()
    }

    public actual fun polylinePosition(): PolylinePosition {
        return nativeLocationSimulator.polylinePosition().toCommon()
    }

    public actual val isActive: Boolean
        get() = nativeLocationSimulator.isActive()
}

public fun NativeLocationSimulator.toCommon(): LocationSimulator {
    return LocationSimulator(this)
}
