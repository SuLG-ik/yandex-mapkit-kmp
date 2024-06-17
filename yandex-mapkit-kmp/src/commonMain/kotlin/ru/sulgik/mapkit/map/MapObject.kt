package ru.sulgik.mapkit.map

expect open class MapObject {

    var isVisible: Boolean

    var zIndex: Float

    var isDraggable: Boolean

    var userData: Any?

    fun addTapListener(tapListener: MapObjectTapListener)

    fun removeTapListener(tapListener: MapObjectTapListener)

    fun setDragListener(dragListener: MapObjectDragListener?)

}

inline fun <reified T : Any> MapObject.getCastedUserData(): T? {
    val data: Any = userData ?: return null
    if (data !is T) {
        throw IllegalStateException("MapObject: userData ($data) is not able to cast to ${T::class}")
    }
    return data
}