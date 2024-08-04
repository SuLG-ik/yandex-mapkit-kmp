package ru.sulgik.mapkit.user_location

import platform.darwin.NSObject
import ru.sulgik.mapkit.layers.ObjectEvent
import ru.sulgik.mapkit.layers.toCommon
import YandexMapKit.YMKObjectEvent as NativeObjectEvent
import YandexMapKit.YMKUserLocationObjectListenerProtocol as NativeUserLocationObjectListener
import YandexMapKit.YMKUserLocationView as NativeUserLocationView

public actual abstract class UserLocationObjectListener actual constructor() {

    private val nativeListener = object : NativeUserLocationObjectListener, NSObject() {
        override fun onObjectAddedWithView(view: NativeUserLocationView) {
            onObjectAdded(view.toCommon())
        }

        override fun onObjectRemovedWithView(view: NativeUserLocationView) {
            onObjectRemoved(view.toCommon())
        }

        override fun onObjectUpdatedWithView(
            view: NativeUserLocationView,
            event: NativeObjectEvent,
        ) {
            onObjectUpdated(view.toCommon(), event.toCommon())
        }
    }

    public fun toNative(): NativeUserLocationObjectListener {
        return nativeListener
    }

    public actual abstract fun onObjectAdded(view: UserLocationView)
    public actual abstract fun onObjectRemoved(view: UserLocationView)
    public actual abstract fun onObjectUpdated(
        view: UserLocationView,
        event: ObjectEvent,
    )
}
