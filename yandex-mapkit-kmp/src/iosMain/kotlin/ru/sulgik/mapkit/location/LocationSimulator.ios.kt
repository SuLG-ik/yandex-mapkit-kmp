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

    /**
     * The speed of the simulation in meters per second.
     *
     * Deprecated by MapKit in favour of [LocationSettings.speed] of each leg. [startSimulation]
     * replaces [settings], so a value assigned here before the simulation starts is overwritten by
     * the speed of the settings the simulation is started with. Set [LocationSettings.speed]
     * together with [LocationSettings.provideSpeed] on every [SimulationSettings] instead.
     */
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

    /**
     * True if simulator is not suspended.
     *
     * Tracks the suspended state inherited from [LocationManager], not whether a simulation is
     * running. [ru.sulgik.mapkit.MapKit.createLocationSimulator] returns a suspended simulator and
     * [startSimulation] does not resume it, so this stays false while a simulation is running.
     */
    public actual val isActive: Boolean
        get() = nativeLocationSimulator.isActive()
}

public fun NativeLocationSimulator.toCommon(): LocationSimulator {
    return LocationSimulator(this)
}
