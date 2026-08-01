package ru.sulgik.mapkit.map

/**
 * Provides a named data buffer to MapKit.
 */
public expect abstract class DataProviderWithId() {

    /**
     * Use the same id for the identical data, to prevent repeated loading of the same data into RAM
     * and VRAM.
     */
    public abstract fun providerId(): String

    /**
     * Returns data.
     */
    public abstract fun load(): ByteArray
}

public inline fun DataProviderWithId(
    crossinline providerId: () -> String,
    crossinline load: () -> ByteArray,
): DataProviderWithId {
    return object : DataProviderWithId() {
        override fun providerId(): String {
            return providerId.invoke()
        }

        override fun load(): ByteArray {
            return load.invoke()
        }
    }
}
