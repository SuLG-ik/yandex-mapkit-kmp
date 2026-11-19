package ru.sulgik.mapkit.transport.masstransit

/** Vehicle types that may be excluded from a public transit request. */
public enum class FilterVehicleTypes(public val value: Int) {
    NONE(0),
    BUS(1 shl 0),
    MINIBUS(1 shl 1),
    RAILWAY(1 shl 2),
    SUBURBAN(1 shl 3),
    TRAMWAY(1 shl 4),
    TROLLEYBUS(1 shl 5),
    UNDERGROUND(1 shl 6),
    METROBUS(1 shl 7),
    DOLMUS(1 shl 8),
    HISTORIC_TRAM(1 shl 9),
    RAPID_TRAM(1 shl 10),
    LIGHT_RAIL(1 shl 11),
    SUBURBAN_EXPRESS(1 shl 12),
    AEROEXPRESS(1 shl 13),
    WATER(1 shl 14),
    FERRY(1 shl 15),
    FUNICULAR(1 shl 16),
    CABLE(1 shl 17),
    AERO(1 shl 18),
    S_BAHN(1 shl 19),
}
