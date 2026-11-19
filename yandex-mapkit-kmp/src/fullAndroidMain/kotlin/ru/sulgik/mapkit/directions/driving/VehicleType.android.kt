package ru.sulgik.mapkit.directions.driving

import com.yandex.mapkit.directions.driving.VehicleType as NativeVehicleType

public fun VehicleType.toNative(): NativeVehicleType {
    return when (this) {
        VehicleType.DEFAULT -> NativeVehicleType.DEFAULT
        VehicleType.TAXI -> NativeVehicleType.TAXI
        VehicleType.TRUCK -> NativeVehicleType.TRUCK
        VehicleType.MOTO -> NativeVehicleType.MOTO
    }
}

public fun NativeVehicleType.toCommon(): VehicleType {
    return when (this) {
        NativeVehicleType.DEFAULT -> VehicleType.DEFAULT
        NativeVehicleType.TAXI -> VehicleType.TAXI
        NativeVehicleType.TRUCK -> VehicleType.TRUCK
        NativeVehicleType.MOTO -> VehicleType.MOTO
    }
}
