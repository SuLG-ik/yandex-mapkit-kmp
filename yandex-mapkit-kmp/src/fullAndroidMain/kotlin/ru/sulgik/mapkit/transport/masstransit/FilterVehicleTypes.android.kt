package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.FilterVehicleTypes as NativeFilterVehicleTypes

/** Converts one vehicle type to its native enum value. */
public fun FilterVehicleTypes.toNative(): NativeFilterVehicleTypes {
    return when (this) {
        FilterVehicleTypes.NONE -> NativeFilterVehicleTypes.NONE
        FilterVehicleTypes.BUS -> NativeFilterVehicleTypes.BUS
        FilterVehicleTypes.MINIBUS -> NativeFilterVehicleTypes.MINIBUS
        FilterVehicleTypes.RAILWAY -> NativeFilterVehicleTypes.RAILWAY
        FilterVehicleTypes.SUBURBAN -> NativeFilterVehicleTypes.SUBURBAN
        FilterVehicleTypes.TRAMWAY -> NativeFilterVehicleTypes.TRAMWAY
        FilterVehicleTypes.TROLLEYBUS -> NativeFilterVehicleTypes.TROLLEYBUS
        FilterVehicleTypes.UNDERGROUND -> NativeFilterVehicleTypes.UNDERGROUND
        FilterVehicleTypes.METROBUS -> NativeFilterVehicleTypes.METROBUS
        FilterVehicleTypes.DOLMUS -> NativeFilterVehicleTypes.DOLMUS
        FilterVehicleTypes.HISTORIC_TRAM -> NativeFilterVehicleTypes.HISTORIC_TRAM
        FilterVehicleTypes.RAPID_TRAM -> NativeFilterVehicleTypes.RAPID_TRAM
        FilterVehicleTypes.LIGHT_RAIL -> NativeFilterVehicleTypes.LIGHT_RAIL
        FilterVehicleTypes.SUBURBAN_EXPRESS -> NativeFilterVehicleTypes.SUBURBAN_EXPRESS
        FilterVehicleTypes.AEROEXPRESS -> NativeFilterVehicleTypes.AEROEXPRESS
        FilterVehicleTypes.WATER -> NativeFilterVehicleTypes.WATER
        FilterVehicleTypes.FERRY -> NativeFilterVehicleTypes.FERRY
        FilterVehicleTypes.FUNICULAR -> NativeFilterVehicleTypes.FUNICULAR
        FilterVehicleTypes.CABLE -> NativeFilterVehicleTypes.CABLE
        FilterVehicleTypes.AERO -> NativeFilterVehicleTypes.AERO
        FilterVehicleTypes.S_BAHN -> NativeFilterVehicleTypes.S_BAHN
    }
}

/** Reads one vehicle type from its native enum value. */
public fun NativeFilterVehicleTypes.toCommon(): FilterVehicleTypes {
    return when (this) {
        NativeFilterVehicleTypes.NONE -> FilterVehicleTypes.NONE
        NativeFilterVehicleTypes.BUS -> FilterVehicleTypes.BUS
        NativeFilterVehicleTypes.MINIBUS -> FilterVehicleTypes.MINIBUS
        NativeFilterVehicleTypes.RAILWAY -> FilterVehicleTypes.RAILWAY
        NativeFilterVehicleTypes.SUBURBAN -> FilterVehicleTypes.SUBURBAN
        NativeFilterVehicleTypes.TRAMWAY -> FilterVehicleTypes.TRAMWAY
        NativeFilterVehicleTypes.TROLLEYBUS -> FilterVehicleTypes.TROLLEYBUS
        NativeFilterVehicleTypes.UNDERGROUND -> FilterVehicleTypes.UNDERGROUND
        NativeFilterVehicleTypes.METROBUS -> FilterVehicleTypes.METROBUS
        NativeFilterVehicleTypes.DOLMUS -> FilterVehicleTypes.DOLMUS
        NativeFilterVehicleTypes.HISTORIC_TRAM -> FilterVehicleTypes.HISTORIC_TRAM
        NativeFilterVehicleTypes.RAPID_TRAM -> FilterVehicleTypes.RAPID_TRAM
        NativeFilterVehicleTypes.LIGHT_RAIL -> FilterVehicleTypes.LIGHT_RAIL
        NativeFilterVehicleTypes.SUBURBAN_EXPRESS -> FilterVehicleTypes.SUBURBAN_EXPRESS
        NativeFilterVehicleTypes.AEROEXPRESS -> FilterVehicleTypes.AEROEXPRESS
        NativeFilterVehicleTypes.WATER -> FilterVehicleTypes.WATER
        NativeFilterVehicleTypes.FERRY -> FilterVehicleTypes.FERRY
        NativeFilterVehicleTypes.FUNICULAR -> FilterVehicleTypes.FUNICULAR
        NativeFilterVehicleTypes.CABLE -> FilterVehicleTypes.CABLE
        NativeFilterVehicleTypes.AERO -> FilterVehicleTypes.AERO
        NativeFilterVehicleTypes.S_BAHN -> FilterVehicleTypes.S_BAHN
    }
}
