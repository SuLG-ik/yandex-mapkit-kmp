package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapType as NativeMapType

fun MapType.toNative(): NativeMapType {
    return when (this) {
        MapType.NONE -> NativeMapType.NONE
        MapType.MAP -> NativeMapType.MAP
        MapType.SATELLITE -> NativeMapType.SATELLITE
        MapType.HYBRID -> NativeMapType.HYBRID
        MapType.VECTOR_MAP -> NativeMapType.VECTOR_MAP
    }
}

fun NativeMapType.toCommon(): MapType {
    return when (this) {
        NativeMapType.NONE -> MapType.NONE
        NativeMapType.MAP -> MapType.MAP
        NativeMapType.SATELLITE -> MapType.SATELLITE
        NativeMapType.HYBRID -> MapType.HYBRID
        NativeMapType.VECTOR_MAP -> MapType.VECTOR_MAP
    }
}