package ru.sulgik.mapkit.map

import YandexMapKit.YMKBaseMapObjectCollection as NativeBaseMapObjectCollection
import YandexMapKit.YMKCircleMapObject as NativeCircleMapObject
import YandexMapKit.YMKMapObject as NativeMapObject
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject
import YandexMapKit.YMKPolygonMapObject as NativePolygonMapObject
import YandexMapKit.YMKPolylineMapObject as NativePolylineMapObject

actual open class MapObject internal constructor(private val nativeMapObject: NativeMapObject) {

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
        nativeMapObject.addTapListenerWithTapListener(tapListener.toNative())
    }

    actual fun removeTapListener(tapListener: MapObjectTapListener) {
        nativeMapObject.removeTapListenerWithTapListener(tapListener.toNative())
    }

    actual fun setDragListener(dragListener: MapObjectDragListener?) {
        nativeMapObject.setDragListenerWithDragListener(dragListener?.toNative())
    }

}

fun NativeMapObject.toCommon(): MapObject {
    return when (this) {
        is NativeBaseMapObjectCollection -> toCommon()
        is NativeCircleMapObject -> toCommon()
        is NativePlacemarkMapObject -> toCommon()
        is NativePolygonMapObject -> toCommon()
        is NativePolylineMapObject -> toCommon()
        else -> MapObject(this)
    }
}