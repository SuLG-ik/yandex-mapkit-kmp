package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapType as NativeMapType

public fun MapType.toNative(): NativeMapType {
    return when (this) {
        MapType.NONE -> NativeMapType.YMKMapTypeNone
        MapType.MAP -> NativeMapType.YMKMapTypeMap
        MapType.SATELLITE -> NativeMapType.YMKMapTypeSatellite
        MapType.HYBRID -> NativeMapType.YMKMapTypeHybrid
        MapType.VECTOR_MAP -> NativeMapType.YMKMapTypeVectorMap
    }
}

public fun NativeMapType.toCommon(): MapType {
    return when (this) {
        NativeMapType.YMKMapTypeVectorMap -> MapType.VECTOR_MAP
        NativeMapType.YMKMapTypeNone -> MapType.NONE
        NativeMapType.YMKMapTypeSatellite -> MapType.SATELLITE
        NativeMapType.YMKMapTypeMap -> MapType.MAP
        NativeMapType.YMKMapTypeHybrid -> MapType.HYBRID
        else -> throw IllegalArgumentException("Unknown NativeMapType ($this)")
    }
}