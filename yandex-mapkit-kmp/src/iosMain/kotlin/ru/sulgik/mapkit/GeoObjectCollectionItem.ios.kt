package ru.sulgik.mapkit

import YandexMapKit.YMKGeoObjectCollectionItem as NativeGeoObjectCollectionItem

/**
 * An entry of a [GeoObjectCollection]: either a [GeoObject] or a nested collection.
 */
public actual class GeoObjectCollectionItem internal constructor(
    private val nativeItem: NativeGeoObjectCollectionItem,
) {

    public fun toNative(): NativeGeoObjectCollectionItem {
        return nativeItem
    }

    public actual val obj: GeoObject?
        get() = nativeItem.obj()?.toCommon()

    public actual val collection: GeoObjectCollection?
        get() = nativeItem.collection()?.toCommon()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GeoObjectCollectionItem) return false
        if (this::class != other::class) return false
        return nativeItem == other.nativeItem
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeItem.hashCode()
    }
}

public fun NativeGeoObjectCollectionItem.toCommon(): GeoObjectCollectionItem {
    return GeoObjectCollectionItem(this)
}
