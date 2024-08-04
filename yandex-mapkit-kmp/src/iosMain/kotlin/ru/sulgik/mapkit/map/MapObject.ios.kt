package ru.sulgik.mapkit.map

import YandexMapKit.YMKBaseMapObjectCollection as NativeBaseMapObjectCollection
import YandexMapKit.YMKCircleMapObject as NativeCircleMapObject
import YandexMapKit.YMKMapObject as NativeMapObject
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject
import YandexMapKit.YMKPolygonMapObject as NativePolygonMapObject
import YandexMapKit.YMKPolylineMapObject as NativePolylineMapObject

public actual open class MapObject internal constructor(private val nativeMapObject: NativeMapObject) {

    public open fun toNative(): NativeMapObject {
        return nativeMapObject
    }

    public actual var isVisible: Boolean
        get() = nativeMapObject.isVisible()
        set(value) {
            nativeMapObject.setVisible(value)
        }

    public actual var zIndex: Float
        get() = nativeMapObject.zIndex()
        set(value) {
            nativeMapObject.setZIndex(value)
        }

    public actual var isDraggable: Boolean
        get() = nativeMapObject.isDraggable()
        set(value) {
            nativeMapObject.setDraggable(value)
        }

    public actual var userData: Any?
        get() = nativeMapObject.userData()
        set(value) {
            nativeMapObject.setUserData(value)
        }

    public actual fun addTapListener(tapListener: MapObjectTapListener) {
        nativeMapObject.addTapListenerWithTapListener(tapListener.toNative())
    }

    public actual fun removeTapListener(tapListener: MapObjectTapListener) {
        nativeMapObject.removeTapListenerWithTapListener(tapListener.toNative())
    }

    public actual fun setDragListener(dragListener: MapObjectDragListener?) {
        nativeMapObject.setDragListenerWithDragListener(dragListener?.toNative())
    }

    public actual val parent: BaseMapObjectCollection
        get() = nativeMapObject.parent.toCommon()

}

public fun NativeMapObject.toCommon(): MapObject {
    return when (this) {
        is NativeBaseMapObjectCollection -> toCommon()
        is NativeCircleMapObject -> toCommon()
        is NativePlacemarkMapObject -> toCommon()
        is NativePolygonMapObject -> toCommon()
        is NativePolylineMapObject -> toCommon()
        else -> MapObject(this)
    }
}