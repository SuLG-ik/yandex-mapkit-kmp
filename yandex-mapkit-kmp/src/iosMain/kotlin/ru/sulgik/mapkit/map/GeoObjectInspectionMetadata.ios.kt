package ru.sulgik.mapkit.map

import YandexMapKit.YMKGeoObjectInspectionMetadata as NativeGeoObjectInspectionMetadata
import YandexMapKit.YMKGeoObjectInspectionMetadataObjectType as NativeObjectType

public fun GeoObjectInspectionMetadata.toNative(): NativeGeoObjectInspectionMetadata {
    return NativeGeoObjectInspectionMetadata.geoObjectInspectionMetadataWithLayerId(
        layerId = layerId,
        objectType = objectType.toNative(),
    )
}

public fun NativeGeoObjectInspectionMetadata.toCommon(): GeoObjectInspectionMetadata {
    return GeoObjectInspectionMetadata(
        layerId = layerId,
        objectType = objectType.toCommon(),
    )
}

public fun GeoObjectInspectionMetadata.ObjectType.toNative(): NativeObjectType {
    return when (this) {
        GeoObjectInspectionMetadata.ObjectType.POINT -> NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypePoint
        GeoObjectInspectionMetadata.ObjectType.POLYLINE -> NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypePolyline
        GeoObjectInspectionMetadata.ObjectType.POLYGON -> NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypePolygon
        GeoObjectInspectionMetadata.ObjectType.CIRCLE -> NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypeCircle
    }
}

public fun NativeObjectType.toCommon(): GeoObjectInspectionMetadata.ObjectType {
    return when (this) {
        NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypePoint -> GeoObjectInspectionMetadata.ObjectType.POINT
        NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypePolyline -> GeoObjectInspectionMetadata.ObjectType.POLYLINE
        NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypePolygon -> GeoObjectInspectionMetadata.ObjectType.POLYGON
        NativeObjectType.YMKGeoObjectInspectionMetadataObjectTypeCircle -> GeoObjectInspectionMetadata.ObjectType.CIRCLE
        else -> throw IllegalArgumentException("Unknown NativeObjectType ($this)")
    }
}
