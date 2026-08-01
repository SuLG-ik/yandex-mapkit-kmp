package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
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

    /**
     * Manages visibility of the object on the map.
     */
    public actual var isVisible: Boolean
        get() = nativeMapObject.visible
        set(value) {
            nativeMapObject.visible = value
        }

    /**
     * Manages visibility of the object.
     *
     * @param animation Describes the transition between visible and not visible states.
     * @param onFinished Called when the transition is finished.
     */
    public actual fun setVisible(visible: Boolean, animation: Animation, onFinished: Callback?) {
        nativeMapObject.setVisibleWithVisible(visible, animation.toNative(), onFinished?.toNative())
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

    public actual fun addTapListener(tapListener: WeakRef<MapObjectTapListener>) {
        nativeMapObject.addTapListenerWithTapListener(tapListener.toNative() ?: return)
    }

    public actual fun removeTapListener(tapListener: WeakRef<MapObjectTapListener>) {
        nativeMapObject.removeTapListenerWithTapListener(tapListener.toNative() ?: return)
    }

    public actual fun setDragListener(dragListener: WeakRef<MapObjectDragListener>?) {
        nativeMapObject.setDragListenerWithDragListener(dragListener?.toNative())
    }

    public actual val parent: BaseMapObjectCollection
        get() = nativeMapObject.parent.toCommon()

    public actual val isValid: Boolean
        get() = nativeMapObject.isValid()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MapObject) return false
        if (this::class != other::class) return false
        return nativeMapObject == other.nativeMapObject
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeMapObject.hashCode()
    }
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
