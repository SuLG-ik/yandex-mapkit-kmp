package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.GeoObjectTags as NativeGeoObjectTags

public fun GeoObjectTags.toNative(): NativeGeoObjectTags {
    return NativeGeoObjectTags(tags)
}

public fun NativeGeoObjectTags.toCommon(): GeoObjectTags {
    return GeoObjectTags(tags = tags)
}
