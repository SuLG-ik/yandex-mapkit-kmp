package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.location.SimulationSettings as NativeSimulationSettings

public fun SimulationSettings.toNative(): NativeSimulationSettings {
    return NativeSimulationSettings(geometry.toNative(), locationSettings.toNative())
}

public fun NativeSimulationSettings.toCommon(): SimulationSettings {
    return SimulationSettings(
        geometry = geometry.toCommon(),
        locationSettings = locationSettings.toCommon(),
    )
}
