package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKGeoObjectCollection as NativeGeoObjectCollection
import YandexMapKit.YMKGeoObjectCollectionItem as NativeGeoObjectCollectionItem

/**
 * A tree of geo objects.
 */
public actual class GeoObjectCollection internal constructor(
    private val nativeGeoObjectCollection: NativeGeoObjectCollection,
) {

    public fun toNative(): NativeGeoObjectCollection {
        return nativeGeoObjectCollection
    }

    /**
     * The bounds around the collection of objects.
     */
    public actual val boundingBox: BoundingBox?
        get() = nativeGeoObjectCollection.boundingBox?.toCommon()

    /**
     * The objects and the nested collections.
     */
    @Suppress("UNCHECKED_CAST")
    public actual val children: List<GeoObjectCollectionItem>
        get() = (nativeGeoObjectCollection.children as List<NativeGeoObjectCollectionItem>)
            .map { it.toCommon() }
}

public fun NativeGeoObjectCollection.toCommon(): GeoObjectCollection {
    return GeoObjectCollection(this)
}
