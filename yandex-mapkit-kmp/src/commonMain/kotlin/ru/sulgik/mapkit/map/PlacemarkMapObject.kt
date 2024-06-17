package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect class PlacemarkMapObject : MapObject {

    var geometry: Point

    var direction: Float

    var opacity: Float

    fun setText(
        text: String,
        style: TextStyle = TextStyle(),
    )

    fun setTextStyle(style: TextStyle)

    fun setIcon(
        image: ImageProvider,
        style: IconStyle = IconStyle(),
        onFinished: Callback? = null,
    )

}