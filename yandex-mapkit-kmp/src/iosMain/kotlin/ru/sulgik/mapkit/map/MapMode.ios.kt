package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapMode as NativeMapMode

public fun MapMode.toNative(): NativeMapMode {
    return when (this) {
        MapMode.MAP -> NativeMapMode.YMKMapModeMap
        MapMode.TRANSIT -> NativeMapMode.YMKMapModeTransit
        MapMode.DRIVING -> NativeMapMode.YMKMapModeDriving
        MapMode.ADMIN -> NativeMapMode.YMKMapModeAdmin
        MapMode.LEGACY_MAP -> NativeMapMode.YMKMapModeLegacyMap
        MapMode.FUTURE_MAP -> NativeMapMode.YMKMapModeFutureMap
    }
}

public fun NativeMapMode.toCommon(): MapMode {
    return when (this) {
        NativeMapMode.YMKMapModeMap -> MapMode.MAP
        NativeMapMode.YMKMapModeTransit -> MapMode.TRANSIT
        NativeMapMode.YMKMapModeDriving -> MapMode.DRIVING
        NativeMapMode.YMKMapModeAdmin -> MapMode.ADMIN
        NativeMapMode.YMKMapModeLegacyMap -> MapMode.LEGACY_MAP
        NativeMapMode.YMKMapModeFutureMap -> MapMode.FUTURE_MAP
        else -> throw IllegalArgumentException("Unknown map mode: $this")
    }
}