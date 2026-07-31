package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKSimulationSettings as NativeSimulationSettings

public fun SimulationSettings.toNative(): NativeSimulationSettings {
    return NativeSimulationSettings.simulationSettingsWithGeometry(
        geometry = geometry.toNative(),
        locationSettings = locationSettings.toNative(),
    )
}

public fun NativeSimulationSettings.toCommon(): SimulationSettings {
    return SimulationSettings(
        geometry = geometry.toCommon(),
        locationSettings = locationSettings.toCommon(),
    )
}
