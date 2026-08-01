package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.runtime.Error
import YandexMapKit.YMKLocationUnavailableError as NativeLocationUnavailableError

/**
 * The device cannot determine its location.
 */
public actual class LocationUnavailableError internal constructor(
    private val nativeLocationUnavailableError: NativeLocationUnavailableError,
) : Error(nativeLocationUnavailableError) {

    override fun toNative(): NativeLocationUnavailableError {
        return nativeLocationUnavailableError
    }
}

public fun NativeLocationUnavailableError.toCommon(): LocationUnavailableError {
    return LocationUnavailableError(this)
}
