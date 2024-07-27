package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.user_location.UserLocationTapListener as NativeUserLocationTapListener

actual class UserLocationTapListener actual constructor(
    private val onUserLocationObjectTap: (point: Point) -> Unit,
) : NativeUserLocationTapListener {
    override fun onUserLocationObjectTap(p0: NativePoint) {
        onUserLocationObjectTap.invoke(p0.toCommon())
    }
}