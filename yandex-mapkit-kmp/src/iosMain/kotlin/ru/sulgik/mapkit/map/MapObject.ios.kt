package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapObject as NativeMapObject

actual open class MapObject(private val nativeMapObject: NativeMapObject) {

    open fun toNative(): NativeMapObject {
        return nativeMapObject
    }

    actual var isVisible: Boolean
        get() = nativeMapObject.isVisible()
        set(value) {
            nativeMapObject.setVisible(value)
        }

    actual var zIndex: Float
        get() = nativeMapObject.zIndex()
        set(value) {
            nativeMapObject.setZIndex(value)
        }

    actual var isDraggable: Boolean
        get() = nativeMapObject.isDraggable()
        set(value) {
            nativeMapObject.setDraggable(value)
        }

    actual var userData: Any?
        get() = nativeMapObject.userData()
        set(value) {
            nativeMapObject.setUserData(value)
        }

    actual fun addTapListener(tapListener: MapObjectTapListener) {
        nativeMapObject.addTapListenerWithTapListener(tapListener)
    }

    actual fun removeTapListener(tapListener: MapObjectTapListener) {
        nativeMapObject.removeTapListenerWithTapListener(tapListener)
    }

    actual fun setDragListener(dragListener: MapObjectDragListener?) {
        nativeMapObject.setDragListenerWithDragListener(dragListener)
    }

}

fun NativeMapObject.toCommon(): MapObject {
    return MapObject(this)
}