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
}

public fun NativeGeoObjectCollectionItem.toCommon(): GeoObjectCollectionItem {
    return GeoObjectCollectionItem(this)
}
