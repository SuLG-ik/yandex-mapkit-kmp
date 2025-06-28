package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.location.LocationViewSource
import ru.sulgik.mapkit.map.CameraPosition

public expect class UserLocationLayer {

    /**
     * User location visibility.
     */
    public var isVisible: Boolean

    /**
     * Heading mode.
     */
    public var isHeadingModeActive: Boolean


    /**
     * Returns true if anchor mode is set, and false otherwise.
     */
    public val isAnchorEnabled: Boolean

    /**
     * Auto zoom.
     */
    public var isAutoZoomEnabled: Boolean

    /**
     * Calculates the camera position that projects the current location into view.
     */
    public val cameraPosition: CameraPosition?

    /**
     * Sets the anchor to the specified position in pixels and enables Anchor mode.
     */
    public fun setAnchor(
        anchorNormal: PointF,
        anchorCourse: PointF,
    )

    /**
     * Resets anchor mode.
     */
    public fun resetAnchor()

    /**
     * Sets/gets the data source.
     */
    public fun setSource(source: LocationViewSource?)

    /**
     * Sets the data source with the global location manager
     */
    public fun setDefaultSource()

    /**
     * Sets/resets the tap listener.
     *
     * The class does not retain the object in the 'tapListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object
     * while it is attached to a class.
     */
    public fun setTapListener(tapListener: UserLocationTapListener?)

    /**
     * Sets/resets the object listener.
     *
     * The class does not retain the object in the 'tapListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object
     * while it is attached to a class.
     */
    public fun setObjectListener(objectListener: UserLocationObjectListener?)

}