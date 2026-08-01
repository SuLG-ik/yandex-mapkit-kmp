package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.geometry.Point

public expect class PlacemarkMapObject : MapObject {

    public var geometry: Point

    /**
     * Angle between the direction of an object and the direction to north.
     */
    public var direction: Float

    /**
     * Opacity multiplicator for the placemark content.
     */
    public var opacity: Float

    /**
     * Sets the text with the given style for the placemark.
     */
    public fun setText(
        text: String,
        style: TextStyle = TextStyle(),
    )

    /**
     * Changes the text style.
     */
    public fun setTextStyle(style: TextStyle)

    /**
     * Sets an icon with the given style for the placemark.
     */
    public fun setIcon(
        image: ImageProvider,
        style: IconStyle = IconStyle(),
        onFinished: Callback? = null,
    )

    /**
     * Changes the icon style.
     */
    public fun setIconStyle(style: IconStyle)

    /**
     * Sets piecewise linear scale, depending on the zoom.
     */
    public fun setScaleFunction(points: List<PointF>)

    /**
     * Returns [Icon] object that can be used to set image and its style for the placemark.
     */
    public fun useIcon(): Icon

    /**
     * Returns [CompositeIcon] object that can be used to set icons and their styles for the
     * placemark.
     */
    public fun useCompositeIcon(): CompositeIcon

    /**
     * Returns [Model] object that can be used to set model and its style for the placemark.
     */
    public fun useModel(): Model

    /**
     * Returns [PlacemarkAnimation] object that can be used to control animation of the placemark.
     */
    public fun useAnimation(): PlacemarkAnimation

    /**
     * [PlacemarkText] can be used to set text and its style for the placemark.
     */
    public val text: PlacemarkText
}
