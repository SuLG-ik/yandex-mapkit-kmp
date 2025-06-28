package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.location.LocationViewSource
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKUserLocationLayer as NativeUserLocationLayer

public actual class UserLocationLayer internal constructor(private val nativeUserLocationLayer: NativeUserLocationLayer) {

    public fun toNative(): NativeUserLocationLayer {
        return nativeUserLocationLayer
    }

    /**
     * User location visibility.
     */
    public actual var isVisible: Boolean
        get() = nativeUserLocationLayer.isVisible()
        set(value) {
            nativeUserLocationLayer.setVisibleWithOn(value)
        }

    /**
     * Heading mode.
     */
    public actual var isHeadingModeActive: Boolean
        get() = nativeUserLocationLayer.headingModeActive
        set(value) {
            nativeUserLocationLayer.headingModeActive = value
        }

    /**
     * Returns true if anchor mode is set, and false otherwise.
     */
    public actual val isAnchorEnabled: Boolean
        get() = nativeUserLocationLayer.isAnchorEnabled()

    /**
     * Auto zoom.
     */
    public actual var isAutoZoomEnabled: Boolean
        get() = nativeUserLocationLayer.autoZoomEnabled
        set(value) {
            nativeUserLocationLayer.autoZoomEnabled = value
        }

    /**
     * Calculates the camera position that projects the current location into view.
     */
    public actual val cameraPosition: CameraPosition?
        get() = nativeUserLocationLayer.cameraPosition()?.toCommon()

    /**
     * Sets the anchor to the specified position in pixels and enables Anchor mode.
     */
    public actual fun setAnchor(
        anchorNormal: PointF,
        anchorCourse: PointF,
    ) {
        nativeUserLocationLayer.setAnchorWithAnchorNormal(
            anchorNormal.toNative(),
            anchorCourse.toNative()
        )
    }

    /**
     * Resets anchor mode.
     */
    public actual fun resetAnchor() {
        nativeUserLocationLayer.resetAnchor()
    }

    /**
     * Sets/gets the data source.
     */
    public actual fun setSource(source: LocationViewSource?) {
        nativeUserLocationLayer.setSourceWithSource(source?.toNative())
    }

    /**
     * Sets the data source with the global location manager
     */
    public actual fun setDefaultSource() {
        nativeUserLocationLayer.setDefaultSource()
    }

    /**
     * Sets/resets the tap listener.
     *
     * The class does not retain the object in the 'tapListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object
     * while it is attached to a class.
     */
    public actual fun setTapListener(tapListener: UserLocationTapListener?) {
        nativeUserLocationLayer.setTapListenerWithTapListener(tapListener?.toNative())
    }

    /**
     * Sets/resets the object listener.
     *
     * The class does not retain the object in the 'tapListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object
     * while it is attached to a class.
     */
    public actual fun setObjectListener(objectListener: UserLocationObjectListener?) {
        nativeUserLocationLayer.setObjectListenerWithObjectListener(objectListener?.toNative())
    }

}

public fun NativeUserLocationLayer.toCommon(): UserLocationLayer {
    return UserLocationLayer(this)
}