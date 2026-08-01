package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.toNSData
import YandexMapKit.YMKDataSource as NativeDataSource

/**
 * A data source that is fed with a single blob.
 */
public actual class DataSource internal constructor(
    private val nativeDataSource: NativeDataSource,
) : BaseDataSource(nativeDataSource) {

    override fun toNative(): NativeDataSource {
        return nativeDataSource
    }

    /**
     * Updates all data.
     */
    public actual fun setData(data: ByteArray) {
        nativeDataSource.setDataWithData(data.toNSData())
    }
}

public fun NativeDataSource.toCommon(): DataSource {
    return DataSource(this)
}
