package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.location.LocationViewSource
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.user_location.UserLocationLayer as NativeUserLocationLayer

actual class UserLocationLayer internal constructor(private val nativeUserLocationLayer: NativeUserLocationLayer) {

    fun toNative(): NativeUserLocationLayer {
        return nativeUserLocationLayer
    }

    /**
     * User location visibility.
     */
    actual var isVisible: Boolean
        get() = nativeUserLocationLayer.isVisible
        set(value) {
            nativeUserLocationLayer.isVisible = value
        }

    /**
     * Heading mode.
     */
    actual var isHeadingEnabled: Boolean
        get() = nativeUserLocationLayer.isHeadingEnabled
        set(value) {
            nativeUserLocationLayer.isHeadingEnabled = value
        }

    /**
     * Returns true if anchor mode is set, and false otherwise.
     */
    actual val isAnchorEnabled: Boolean
        get() = nativeUserLocationLayer.isAnchorEnabled

    /**
     * Auto zoom.
     */
    actual var isAutoZoomEnabled: Boolean
        get() = nativeUserLocationLayer.isAutoZoomEnabled
        set(value) {
            nativeUserLocationLayer.isAutoZoomEnabled = value
        }

    /**
     * Calculates the camera position that projects the current location into view.
     */
    actual val cameraPosition: CameraPosition?
        get() = nativeUserLocationLayer.cameraPosition()?.toCommon()

    /**
     * Sets the anchor to the specified position in pixels and enables Anchor mode.
     */
    actual fun setAnchor(
        anchorNormal: PointF,
        anchorCourse: PointF,
    ) {
        nativeUserLocationLayer.setAnchor(anchorNormal.toNative(), anchorCourse.toNative())
    }

    /**
     * Resets anchor mode.
     */
    actual fun resetAnchor() {
        nativeUserLocationLayer.resetAnchor()
    }

    /**
     * Sets/gets the data source.
     */
    actual fun setSource(source: LocationViewSource?) {
        nativeUserLocationLayer.setSource(source?.toNative())
    }

    /**
     * Sets the data source with the global location manager
     */
    actual fun setDefaultSource() {
        nativeUserLocationLayer.setDefaultSource()
    }

    /**
     * Sets/resets the tap listener.
     *
     * The class does not retain the object in the 'tapListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object
     * while it is attached to a class.
     */
    actual fun setTapListener(tapListener: UserLocationTapListener?) {
        nativeUserLocationLayer.setTapListener(tapListener)
    }

    /**
     * Sets/resets the object listener.
     *
     * The class does not retain the object in the 'tapListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object
     * while it is attached to a class.
     */
    actual fun setObjectListener(objectListener: UserLocationObjectListener?) {
        nativeUserLocationLayer.setObjectListener(objectListener)
    }
}

fun NativeUserLocationLayer.toCommon(): UserLocationLayer {
    return UserLocationLayer(this)
}