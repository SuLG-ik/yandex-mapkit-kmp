package ru.sulgik.mapkit.transport.masstransit

/** Converts one vehicle type to the unsigned `YMKFilterVehicleTypes` mask. */
public fun FilterVehicleTypes.toNative(): ULong {
    return value.toULong()
}

/** Reads one vehicle type. Use [TransitOptions] for combined masks. */
public fun FilterVehicleTypes.Companion.toCommon(native: ULong): FilterVehicleTypes {
    return FilterVehicleTypes.entries.firstOrNull { it.toNative() == native }
        ?: throw IllegalArgumentException("Unknown NativeFilterVehicleTypes ($native)")
}
