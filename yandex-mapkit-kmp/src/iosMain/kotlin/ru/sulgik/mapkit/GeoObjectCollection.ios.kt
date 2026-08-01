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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GeoObjectCollection) return false
        if (this::class != other::class) return false
        return nativeGeoObjectCollection == other.nativeGeoObjectCollection
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeGeoObjectCollection.hashCode()
    }
}

public fun NativeGeoObjectCollection.toCommon(): GeoObjectCollection {
    return GeoObjectCollection(this)
}
