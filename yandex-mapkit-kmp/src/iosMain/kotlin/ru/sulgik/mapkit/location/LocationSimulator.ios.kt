package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKLocationManager as NativeLocationManager
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
     * [startSimulation] does not resume it, so this stays false while a simulation is running until
     * [LocationManager.resume] is called on [asLocationManager].
     */
    public actual val isActive: Boolean
        get() = nativeLocationSimulator.isActive()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LocationSimulator) return false
        if (this::class != other::class) return false
        return nativeLocationSimulator == other.nativeLocationSimulator
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLocationSimulator.hashCode()
    }
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
