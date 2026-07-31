package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.toCommon
import com.yandex.mapkit.mapview.MapView as NativeMapView

public actual class MapView internal constructor(private val nativeMapView: NativeMapView) {

    public fun toNative(): NativeMapView {
        return nativeMapView
    }

    public actual fun onStart() {
        nativeMapView.onStart()
    }

    public actual fun onStop() {
        nativeMapView.onStop()
    }

    public actual val mapWindow: MapWindow = nativeMapView.mapWindow.toCommon()

    public actual fun setNoninteractive(value: Boolean) {
        nativeMapView.setNoninteractive(value)
    }

    /**
     * Explicitly destroys MapView, releasing its native resources.
     */
    public actual fun destroy() {
        nativeMapView.destroy()
    }

    /**
     * Is debug mode enabled.
     */
    public val isDebugModeEnabled: Boolean
        get() = nativeMapView.isDebugModeEnabled
}

public fun NativeMapView.toCommon(): MapView {
    return MapView(this)
}
