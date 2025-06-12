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
        get() = nativeMapObject.visible
        set(value) {
            nativeMapObject.visible = value
        }

    public actual var zIndex: Float
        get() = nativeMapObject.zIndex
        set(value) {
            nativeMapObject.zIndex = value
        }

    public actual var isDraggable: Boolean
        get() = nativeMapObject.draggable
        set(value) {
            nativeMapObject.draggable = value
        }

    public actual var userData: Any?
        get() = nativeMapObject.userData
        set(value) {
            nativeMapObject.userData = value
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