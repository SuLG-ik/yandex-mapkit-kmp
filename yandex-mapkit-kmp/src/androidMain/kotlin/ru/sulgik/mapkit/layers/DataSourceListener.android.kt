package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.layers.DataSourceListener as NativeDataSourceListener

/**
 * Notifies when the data behind a layer changed.
 */
public actual abstract class DataSourceListener actual constructor() : NativeConvertible<NativeDataSourceListener> {

    private val nativeListener = NativeDataSourceListener { dataSource ->
        onDataSourceUpdated(dataSource.toCommon())
    }

    override fun toNative(): NativeDataSourceListener {
        return nativeListener
    }

    public actual abstract fun onDataSourceUpdated(dataSource: BaseDataSource)
}
