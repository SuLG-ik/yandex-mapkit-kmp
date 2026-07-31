package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.BaseMapObjectCollection as NativeBaseMapObjectCollection
import com.yandex.mapkit.map.CircleMapObject as NativeCircleMapObject
import com.yandex.mapkit.map.MapObject as NativeMapObject
import com.yandex.mapkit.map.PlacemarkMapObject as NativePlacemarkMapObject
import com.yandex.mapkit.map.PolygonMapObject as NativePolygonMapObject
import com.yandex.mapkit.map.PolylineMapObject as NativePolylineMapObject

public actual open class MapObject internal constructor(private val nativeMapObject: NativeMapObject) {

    public open fun toNative(): NativeMapObject {
        return nativeMapObject
    }

    /**
     * Manages visibility of the object on the map.
     */
    public actual var isVisible: Boolean
        get() = nativeMapObject.isVisible
        set(value) {
            nativeMapObject.isVisible = value
        }

    /**
     * Manages visibility of the object.
     *
     * @param animation Describes the transition between visible and not visible states.
     * @param onFinished Called when the transition is finished.
     */
    public actual fun setVisible(visible: Boolean, animation: Animation, onFinished: Callback?) {
        nativeMapObject.setVisible(visible, animation.toNative(), onFinished?.toNative())
    }

    public actual var zIndex: Float
        get() = nativeMapObject.zIndex
        set(value) {
            nativeMapObject.zIndex = value
        }
    public actual var isDraggable: Boolean
        get() = nativeMapObject.isDraggable
        set(value) {
            nativeMapObject.isDraggable = value
        }
    public actual var userData: Any?
        get() = nativeMapObject.userData
        set(value) {
            nativeMapObject.userData = value
        }

    public actual fun addTapListener(tapListener: WeakRef<MapObjectTapListener>) {
        nativeMapObject.addTapListener(tapListener.toNative())
    }

    public actual fun removeTapListener(tapListener: WeakRef<MapObjectTapListener>) {
        nativeMapObject.removeTapListener(tapListener.toNative())
    }

    public actual fun setDragListener(dragListener: WeakRef<MapObjectDragListener>?) {
        nativeMapObject.setDragListener(dragListener?.toNative())
    }

    public actual val parent: BaseMapObjectCollection
        get() = nativeMapObject.parent.toCommon()

    public actual val isValid: Boolean
        get() = nativeMapObject.isValid
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
