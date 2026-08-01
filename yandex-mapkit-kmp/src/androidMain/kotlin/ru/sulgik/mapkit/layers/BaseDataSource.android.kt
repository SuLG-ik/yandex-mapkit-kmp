package ru.sulgik.mapkit.layers

import com.yandex.mapkit.layers.BaseDataSource as NativeBaseDataSource
import com.yandex.mapkit.layers.DataSource as NativeDataSource
import com.yandex.mapkit.layers.TileDataSource as NativeTileDataSource

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
        get() = nativeBaseDataSource.id

    /**
     * Tells if this **BaseDataSource** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeBaseDataSource.isValid

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseDataSource) return false
        if (this::class != other::class) return false
        return nativeBaseDataSource == other.nativeBaseDataSource
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeBaseDataSource.hashCode()
    }
}

public fun NativeBaseDataSource.toCommon(): BaseDataSource {
    return when (this) {
        is NativeDataSource -> toCommon()
        is NativeTileDataSource -> toCommon()
        else -> BaseDataSource(this)
    }
}
