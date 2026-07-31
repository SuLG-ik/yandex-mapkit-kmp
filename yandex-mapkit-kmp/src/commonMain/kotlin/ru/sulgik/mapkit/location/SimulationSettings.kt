package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.geometry.Polyline

/**
 * One leg of a location simulation.
 */
public data class SimulationSettings(
    val geometry: Polyline,
    val locationSettings: LocationSettings,
)
