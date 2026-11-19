package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.toCommon as toRuntimeError
import com.yandex.runtime.Error as NativeError

/** A failure reported by the driving router. */
public actual class DrivingRouteError internal constructor(private val nativeError: NativeError) {

    /** Returns the native failure. */
    public fun toNative(): NativeError {
        return nativeError
    }

    /** The typed MapKit failure, when the platform supplies one. */
    public actual val error: Error?
        get() = nativeError.toRuntimeError()

    /** The native message, when the platform supplies one. */
    public actual val description: String?
        get() = null
}

/** Wraps this native driving failure. */
public fun NativeError.toCommon(): DrivingRouteError {
    return DrivingRouteError(this)
}
