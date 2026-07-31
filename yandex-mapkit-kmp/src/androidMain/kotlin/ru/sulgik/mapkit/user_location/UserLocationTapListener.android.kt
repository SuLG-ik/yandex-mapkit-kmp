package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.user_location.UserLocationTapListener as NativeUserLocationTapListener

public actual abstract class UserLocationTapListener actual constructor() : NativeConvertible<NativeUserLocationTapListener> {
    private val nativeListener = NativeUserLocationTapListener {
        onUserLocationObjectTap(it.toCommon())
    }

    override fun toNative(): NativeUserLocationTapListener {
        return nativeListener
    }

    public actual abstract fun onUserLocationObjectTap(point: Point)
}