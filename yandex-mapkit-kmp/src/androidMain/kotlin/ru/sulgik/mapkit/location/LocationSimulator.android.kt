package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.location.LocationManager as NativeLocationManager
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

    /**
     * The speed of the simulation in meters per second.
     *
     * Deprecated by MapKit in favour of [LocationSettings.speed] of each leg. [startSimulation]
     * replaces [settings], so a value assigned here before the simulation starts is overwritten by
     * the speed of the settings the simulation is started with. Set [LocationSettings.speed]
     * together with [LocationSettings.provideSpeed] on every [SimulationSettings] instead.
     */
    @Deprecated(
        message = "Now a field in settings. Set LocationSettings.speed together with " +
            "LocationSettings.provideSpeed on every SimulationSettings instead.",
        level = DeprecationLevel.WARNING,
    )
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

    /**
     * True if simulator is not suspended.
     *
     * Tracks the suspended state inherited from [LocationManager], not whether a simulation is
     * running. [ru.sulgik.mapkit.MapKit.createLocationSimulator] returns a suspended simulator and
     * [startSimulation] does not resume it, so this stays false while a simulation is running until
     * [LocationManager.resume] is called on [asLocationManager].
     */
    public actual val isActive: Boolean
        get() = nativeLocationSimulator.isActive
}

public fun NativeLocationSimulator.toCommon(): LocationSimulator {
    return LocationSimulator(this)
}

/**
 * Views the simulator as the [LocationManager] that MapKit derives it from.
 *
 * The returned manager drives the same underlying object, so
 * [LocationManager.subscribeForLocationUpdates] and [LocationManager.requestSingleUpdate] deliver
 * the locations the simulation generates, and [LocationManager.resume] lifts the suspended state
 * that [ru.sulgik.mapkit.MapKit.createLocationSimulator] returns the simulator in —
 * [LocationSimulator.isActive] stays false until it is called. The result can also be handed to
 * [ru.sulgik.mapkit.MapKit.setLocationManager] and [toLocationViewSource].
 */
public actual fun LocationSimulator.asLocationManager(): LocationManager {
    val nativeLocationManager: NativeLocationManager = toNative()
    return nativeLocationManager.toCommon()
}
