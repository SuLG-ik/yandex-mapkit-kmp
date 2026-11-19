package ru.sulgik.mapkit.directions.driving

import com.yandex.mapkit.directions.driving.VehicleOptions as NativeVehicleOptions

public fun VehicleOptions.toNative(): NativeVehicleOptions {
    return NativeVehicleOptions(
        vehicleType.toNative(),
        weight,
        axleWeight,
        maxWeight,
        height,
        width,
        length,
        payload,
        ecoClass,
        hasTrailer,
        buswayPermitted,
    )
}

public fun NativeVehicleOptions.toCommon(): VehicleOptions {
    return VehicleOptions(
        vehicleType = vehicleType.toCommon(),
        weight = weight,
        axleWeight = axleWeight,
        maxWeight = maxWeight,
        height = height,
        width = width,
        length = length,
        payload = payload,
        ecoClass = ecoClass,
        hasTrailer = hasTrailer,
        buswayPermitted = buswayPermitted,
    )
}
