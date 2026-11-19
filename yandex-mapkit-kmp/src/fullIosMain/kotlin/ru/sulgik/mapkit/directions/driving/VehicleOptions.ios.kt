package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.toNSNumber
import YandexMapKit.YMKDrivingVehicleOptions as NativeVehicleOptions

public fun VehicleOptions.toNative(): NativeVehicleOptions {
    return NativeVehicleOptions.vehicleOptionsWithVehicleType(
        vehicleType = vehicleType.toNative(),
        weight = weight?.toNSNumber(),
        axleWeight = axleWeight?.toNSNumber(),
        maxWeight = maxWeight?.toNSNumber(),
        height = height?.toNSNumber(),
        width = width?.toNSNumber(),
        length = length?.toNSNumber(),
        payload = payload?.toNSNumber(),
        ecoClass = ecoClass?.toNSNumber(),
        hasTrailer = hasTrailer?.toNSNumber(),
        buswayPermitted = buswayPermitted?.toNSNumber(),
    )
}

public fun NativeVehicleOptions.toCommon(): VehicleOptions {
    return VehicleOptions(
        vehicleType = vehicleType.toCommon(),
        weight = weight?.floatValue,
        axleWeight = axleWeight?.floatValue,
        maxWeight = maxWeight?.floatValue,
        height = height?.floatValue,
        width = width?.floatValue,
        length = length?.floatValue,
        payload = payload?.floatValue,
        ecoClass = ecoClass?.intValue,
        hasTrailer = hasTrailer?.boolValue,
        buswayPermitted = buswayPermitted?.boolValue,
    )
}
