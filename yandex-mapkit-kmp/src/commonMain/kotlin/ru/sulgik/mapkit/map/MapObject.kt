package ru.sulgik.mapkit.map

public expect open class MapObject {

    public val parent: BaseMapObjectCollection

    public var isVisible: Boolean

    public var zIndex: Float

    public var isDraggable: Boolean

    public var userData: Any?

    public fun addTapListener(tapListener: MapObjectTapListener)

    public fun removeTapListener(tapListener: MapObjectTapListener)

    public fun setDragListener(dragListener: MapObjectDragListener?)

    public val isValid: Boolean
}

public inline fun <reified T : Any> MapObject.getCastedUserData(): T? {
    val data: Any = userData ?: return null
    if (data !is T) {
        throw IllegalStateException("MapObject: userData ($data) is not able to cast to ${T::class}")
    }
    return data
}