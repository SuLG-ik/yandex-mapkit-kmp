package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.BaseMapObjectCollection as NativeBaseMapObjectCollection
import com.yandex.mapkit.map.CircleMapObject as NativeCircleMapObject
import com.yandex.mapkit.map.MapObject as NativeMapObject
import com.yandex.mapkit.map.PlacemarkMapObject as NativePlacemarkMapObject
import com.yandex.mapkit.map.PolygonMapObject as NativePolygonMapObject
import com.yandex.mapkit.map.PolylineMapObject as NativePolylineMapObject

actual open class MapObject internal constructor(private val nativeMapObject: NativeMapObject) {

    open fun toNative(): NativeMapObject {
        return nativeMapObject
    }

    actual var isVisible: Boolean
        get() = nativeMapObject.isVisible
        set(value) {
            nativeMapObject.isVisible = value
        }
    actual var zIndex: Float
        get() = nativeMapObject.zIndex
        set(value) {
            nativeMapObject.zIndex = value
        }
    actual var isDraggable: Boolean
        get() = nativeMapObject.isDraggable
        set(value) {
            nativeMapObject.isDraggable = value
        }
    actual var userData: Any?
        get() = nativeMapObject.userData
        set(value) {
            nativeMapObject.userData = value
        }

    actual fun addTapListener(tapListener: MapObjectTapListener) {
        nativeMapObject.addTapListener(tapListener)
    }

    actual fun removeTapListener(tapListener: MapObjectTapListener) {
        nativeMapObject.removeTapListener(tapListener)
    }

    actual fun setDragListener(dragListener: MapObjectDragListener?) {
        nativeMapObject.setDragListener(dragListener)
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