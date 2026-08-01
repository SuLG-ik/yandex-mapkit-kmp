package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toNSNumber
import YandexMapKit.YMKGeoObjectSelectionMetadata as NativeGeoObjectSelectionMetadata

public fun GeoObjectSelectionMetadata.toNative(): NativeGeoObjectSelectionMetadata {
    return NativeGeoObjectSelectionMetadata.geoObjectSelectionMetadataWithObjectId(
        objectId = objectId,
        dataSourceName = dataSourceName,
        layerId = layerId,
        groupId = groupId?.toNSNumber(),
    )
}

public fun NativeGeoObjectSelectionMetadata.toCommon(): GeoObjectSelectionMetadata {
    return GeoObjectSelectionMetadata(
        objectId = objectId,
        dataSourceName = dataSourceName,
        layerId = layerId,
        groupId = groupId?.longValue,
    )
}
