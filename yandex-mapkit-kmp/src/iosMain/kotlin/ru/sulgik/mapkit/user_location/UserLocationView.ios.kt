package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.toCommon
import YandexMapKit.YMKUserLocationView as NativeUserLocationView

public actual class UserLocationView internal constructor(
    private val nativeUserLocationView: NativeUserLocationView,
) {
    public fun toNative(): NativeUserLocationView {
        return nativeUserLocationView
    }

    public actual val arrow: PlacemarkMapObject
        get() = nativeUserLocationView.arrow.toCommon()
    public actual val pin: PlacemarkMapObject
        get() = nativeUserLocationView.pin.toCommon()
    public actual val accuracyCircle: CircleMapObject
        get() = nativeUserLocationView.accuracyCircle.toCommon()
    public actual val isValid: Boolean
        get() = nativeUserLocationView.isValid()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserLocationView) return false
        if (this::class != other::class) return false
        return nativeUserLocationView == other.nativeUserLocationView
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeUserLocationView.hashCode()
    }
}

public fun NativeUserLocationView.toCommon(): UserLocationView {
    return UserLocationView(this)
}
