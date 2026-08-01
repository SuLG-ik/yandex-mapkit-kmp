package ru.sulgik.mapkit.layers

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKBaseDataSource as NativeBaseDataSource
import YandexMapKit.YMKDataSourceListenerProtocol as NativeDataSourceListener

/**
 * Notifies when the data behind a layer changed.
 */
public actual abstract class DataSourceListener actual constructor() : NativeConvertible<NativeDataSourceListener> {

    private val nativeListener = object : NativeDataSourceListener, NSObject() {
        override fun onDataSourceUpdatedWithDataSource(dataSource: NativeBaseDataSource) {
            onDataSourceUpdated(dataSource.toCommon())
        }
    }

    override fun toNative(): NativeDataSourceListener {
        return nativeListener
    }

    public actual abstract fun onDataSourceUpdated(dataSource: BaseDataSource)
}
