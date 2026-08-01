package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.GeoObjectSelectionMetadata as NativeGeoObjectSelectionMetadata

public fun GeoObjectSelectionMetadata.toNative(): NativeGeoObjectSelectionMetadata {
    return NativeGeoObjectSelectionMetadata(objectId, dataSourceName, layerId, groupId)
}

public fun NativeGeoObjectSelectionMetadata.toCommon(): GeoObjectSelectionMetadata {
    return GeoObjectSelectionMetadata(
        objectId = objectId,
        dataSourceName = dataSourceName,
        layerId = layerId,
        groupId = groupId,
    )
}
