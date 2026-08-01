package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.GeoObjectInspectionMetadata as NativeGeoObjectInspectionMetadata

public fun GeoObjectInspectionMetadata.toNative(): NativeGeoObjectInspectionMetadata {
    return NativeGeoObjectInspectionMetadata(layerId, objectType.toNative())
}

public fun NativeGeoObjectInspectionMetadata.toCommon(): GeoObjectInspectionMetadata {
    return GeoObjectInspectionMetadata(
        layerId = layerId,
        objectType = objectType.toCommon(),
    )
}

public fun GeoObjectInspectionMetadata.ObjectType.toNative(): NativeGeoObjectInspectionMetadata.ObjectType {
    return when (this) {
        GeoObjectInspectionMetadata.ObjectType.POINT -> NativeGeoObjectInspectionMetadata.ObjectType.POINT
        GeoObjectInspectionMetadata.ObjectType.POLYLINE -> NativeGeoObjectInspectionMetadata.ObjectType.POLYLINE
        GeoObjectInspectionMetadata.ObjectType.POLYGON -> NativeGeoObjectInspectionMetadata.ObjectType.POLYGON
        GeoObjectInspectionMetadata.ObjectType.CIRCLE -> NativeGeoObjectInspectionMetadata.ObjectType.CIRCLE
    }
}

public fun NativeGeoObjectInspectionMetadata.ObjectType.toCommon(): GeoObjectInspectionMetadata.ObjectType {
    return when (this) {
        NativeGeoObjectInspectionMetadata.ObjectType.POINT -> GeoObjectInspectionMetadata.ObjectType.POINT
        NativeGeoObjectInspectionMetadata.ObjectType.POLYLINE -> GeoObjectInspectionMetadata.ObjectType.POLYLINE
        NativeGeoObjectInspectionMetadata.ObjectType.POLYGON -> GeoObjectInspectionMetadata.ObjectType.POLYGON
        NativeGeoObjectInspectionMetadata.ObjectType.CIRCLE -> GeoObjectInspectionMetadata.ObjectType.CIRCLE
    }
}
