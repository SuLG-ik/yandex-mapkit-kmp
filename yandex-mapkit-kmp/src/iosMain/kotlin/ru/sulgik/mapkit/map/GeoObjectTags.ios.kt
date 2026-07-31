package ru.sulgik.mapkit.map

import YandexMapKit.YMKGeoObjectTags as NativeGeoObjectTags

public fun GeoObjectTags.toNative(): NativeGeoObjectTags {
    return NativeGeoObjectTags.geoObjectTagsWithTags(tags)
}

@Suppress("UNCHECKED_CAST")
public fun NativeGeoObjectTags.toCommon(): GeoObjectTags {
    return GeoObjectTags(tags = tags as List<String>)
}
