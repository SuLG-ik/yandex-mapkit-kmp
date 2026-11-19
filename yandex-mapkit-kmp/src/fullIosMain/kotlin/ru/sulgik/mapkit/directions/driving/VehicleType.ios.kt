package ru.sulgik.mapkit.directions.driving

import YandexMapKit.YMKDrivingVehicleType as NativeVehicleType

public fun VehicleType.toNative(): NativeVehicleType {
    return when (this) {
        VehicleType.DEFAULT -> NativeVehicleType.YMKDrivingVehicleTypeDefault
        VehicleType.TAXI -> NativeVehicleType.YMKDrivingVehicleTypeTaxi
        VehicleType.TRUCK -> NativeVehicleType.YMKDrivingVehicleTypeTruck
        VehicleType.MOTO -> NativeVehicleType.YMKDrivingVehicleTypeMoto
    }
}

public fun NativeVehicleType.toCommon(): VehicleType {
    return when (this) {
        NativeVehicleType.YMKDrivingVehicleTypeDefault -> VehicleType.DEFAULT
        NativeVehicleType.YMKDrivingVehicleTypeTaxi -> VehicleType.TAXI
        NativeVehicleType.YMKDrivingVehicleTypeTruck -> VehicleType.TRUCK
        NativeVehicleType.YMKDrivingVehicleTypeMoto -> VehicleType.MOTO
        else -> throw IllegalArgumentException("Unknown NativeVehicleType ($this)")
    }
}
