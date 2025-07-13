package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapMode as NativeMapMode

public fun MapMode.toNative(): NativeMapMode {
    return when (this) {
        MapMode.MAP -> NativeMapMode.MAP
        MapMode.TRANSIT -> NativeMapMode.TRANSIT
        MapMode.DRIVING -> NativeMapMode.DRIVING
        MapMode.ADMIN -> NativeMapMode.ADMIN
        MapMode.LEGACY_MAP -> NativeMapMode.LEGACY_MAP
        MapMode.FUTURE_MAP -> NativeMapMode.FUTURE_MAP
    }
}

public fun NativeMapMode.toCommon(): MapMode {
    return when (this) {
        NativeMapMode.MAP -> MapMode.MAP
        NativeMapMode.TRANSIT -> MapMode.TRANSIT
        NativeMapMode.DRIVING -> MapMode.DRIVING
        NativeMapMode.ADMIN -> MapMode.ADMIN
        NativeMapMode.LEGACY_MAP -> MapMode.LEGACY_MAP
        NativeMapMode.FUTURE_MAP -> MapMode.FUTURE_MAP
    }
}