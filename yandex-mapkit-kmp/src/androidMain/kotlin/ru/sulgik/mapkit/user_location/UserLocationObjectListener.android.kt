package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent
import ru.sulgik.mapkit.layers.toCommon
import com.yandex.mapkit.layers.ObjectEvent as NativeObjectEvent
import com.yandex.mapkit.user_location.UserLocationObjectListener as NativeUserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView as NativeUserLocationView

actual class UserLocationObjectListener actual constructor(
    private val onObjectAdded: (view: UserLocationView) -> Unit,
    private val onObjectRemoved: (view: UserLocationView) -> Unit,
    private val onObjectUpdated: (view: UserLocationView, event: ObjectEvent) -> Unit,
) : NativeUserLocationObjectListener {
    override fun onObjectAdded(p0: NativeUserLocationView) {
        onObjectAdded.invoke(p0.toCommon())
    }

    override fun onObjectRemoved(p0: NativeUserLocationView) {
        onObjectRemoved.invoke(p0.toCommon())
    }

    override fun onObjectUpdated(
        p0: NativeUserLocationView,
        p1: NativeObjectEvent,
    ) {
        onObjectUpdated.invoke(p0.toCommon(), p1.toCommon())
    }
}