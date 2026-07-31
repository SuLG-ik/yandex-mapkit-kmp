package ru.sulgik.mapkit

import com.yandex.mapkit.GeoObjectCollection as NativeGeoObjectCollection

/**
 * An entry of a [GeoObjectCollection]: either a [GeoObject] or a nested collection.
 */
public actual class GeoObjectCollectionItem internal constructor(
    private val nativeItem: NativeGeoObjectCollection.Item,
) {

    public fun toNative(): NativeGeoObjectCollection.Item {
        return nativeItem
    }

    public actual val obj: GeoObject?
        get() = nativeItem.obj?.toCommon()

    public actual val collection: GeoObjectCollection?
        get() = nativeItem.collection?.toCommon()
}

public fun NativeGeoObjectCollection.Item.toCommon(): GeoObjectCollectionItem {
    return GeoObjectCollectionItem(this)
}
