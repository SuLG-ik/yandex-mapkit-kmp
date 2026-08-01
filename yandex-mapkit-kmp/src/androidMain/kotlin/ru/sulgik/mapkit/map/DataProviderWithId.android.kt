package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.runtime.DataProviderWithId as NativeDataProviderWithId

/**
 * Provides a named data buffer to MapKit.
 */
public actual abstract class DataProviderWithId actual constructor() : NativeConvertible<NativeDataProviderWithId> {

    private val nativeDataProvider = object : NativeDataProviderWithId {
        override fun providerId(): String {
            return this@DataProviderWithId.providerId()
        }

        override fun load(): ByteArray {
            return this@DataProviderWithId.load()
        }
    }

    override fun toNative(): NativeDataProviderWithId {
        return nativeDataProvider
    }

    /**
     * Use the same id for the identical data, to prevent repeated loading of the same data into RAM
     * and VRAM.
     */
    public actual abstract fun providerId(): String

    /**
     * Returns data.
     */
    public actual abstract fun load(): ByteArray
}
