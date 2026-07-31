package ru.sulgik.mapkit.layers

import YandexMapKit.YMKBaseDataSource as NativeBaseDataSource
import YandexMapKit.YMKDataSource as NativeDataSource
import YandexMapKit.YMKTileDataSource as NativeTileDataSource

/**
 * The data behind a layer.
 */
public actual open class BaseDataSource internal constructor(
    private val nativeBaseDataSource: NativeBaseDataSource,
) {

    public open fun toNative(): NativeBaseDataSource {
        return nativeBaseDataSource
    }

    /**
     * Stores id of data source.
     */
    public actual val id: String
        get() = nativeBaseDataSource.id()

    /**
     * Tells if this **BaseDataSource** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeBaseDataSource.isValid()
}

public fun NativeBaseDataSource.toCommon(): BaseDataSource {
    return when (this) {
        is NativeDataSource -> toCommon()
        is NativeTileDataSource -> toCommon()
        else -> BaseDataSource(this)
    }
}
