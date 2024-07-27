package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent
import ru.sulgik.mapkit.layers.toCommon
import com.yandex.mapkit.layers.ObjectEvent as NativeObjectEvent
import com.yandex.mapkit.user_location.UserLocationObjectListener as NativeUserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView as NativeUserLocationView

actual abstract class UserLocationObjectListener actual constructor() {

    private val nativeListener = object : NativeUserLocationObjectListener {
        override fun onObjectAdded(p0: NativeUserLocationView) {
            onObjectAdded(p0.toCommon())
        }

        override fun onObjectRemoved(p0: NativeUserLocationView) {
            onObjectRemoved(p0.toCommon())
        }

        override fun onObjectUpdated(
            p0: NativeUserLocationView,
            p1: NativeObjectEvent,
        ) {
            onObjectUpdated(p0.toCommon(), p1.toCommon())
        }
    }

    fun toNative(): NativeUserLocationObjectListener {
        return nativeListener
    }

    actual abstract fun onObjectAdded(view: UserLocationView)
    actual abstract fun onObjectRemoved(view: UserLocationView)
    actual abstract fun onObjectUpdated(view: UserLocationView, event: ObjectEvent)
}