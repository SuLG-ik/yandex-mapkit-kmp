package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.toCommon
import YandexMapKit.YMKMapView as NativeMapView

public actual class MapView internal constructor(private val nativeMapView: NativeMapView) {

    public fun toNative(): NativeMapView {
        return nativeMapView
    }

    /**
     * Should be called from the corresponding method of activity or fragment containing this view
     */
    public actual fun onStart() {
    }

    /**
     * Should be called from the corresponding method of activity or fragment containing this view
     */
    public actual fun onStop() {
    }

    public actual val mapWindow: MapWindow = nativeMapView.mapWindow!!.toCommon()

    public actual fun setNoninteractive(value: Boolean) {
        nativeMapView.setNoninteractive(value)
    }

    /**
     * Explicitly destroys MapView, releasing its native resources.
     */
    public actual fun destroy() {
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MapView) return false
        if (this::class != other::class) return false
        return nativeMapView == other.nativeMapView
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeMapView.hashCode()
    }
}

public fun NativeMapView.toCommon(): MapView {
    return MapView(this)
}
