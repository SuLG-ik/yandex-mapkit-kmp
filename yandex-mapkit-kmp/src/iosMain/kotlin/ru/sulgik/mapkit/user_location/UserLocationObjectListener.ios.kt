package ru.sulgik.mapkit.user_location

import platform.darwin.NSObject
import ru.sulgik.mapkit.layers.ObjectEvent
import ru.sulgik.mapkit.layers.toCommon
import YandexMapKit.YMKObjectEvent as NativeObjectEvent
import YandexMapKit.YMKUserLocationObjectListenerProtocol as NativeUserLocationObjectListener
import YandexMapKit.YMKUserLocationView as NativeUserLocationView

actual class UserLocationObjectListener actual constructor(
    private val onObjectAdded: (view: UserLocationView) -> Unit,
    private val onObjectRemoved: (view: UserLocationView) -> Unit,
    private val onObjectUpdated: (view: UserLocationView, event: ObjectEvent) -> Unit,
) : NativeUserLocationObjectListener, NSObject() {

    override fun onObjectAddedWithView(view: NativeUserLocationView) {
        onObjectAdded.invoke(view.toCommon())
    }

    override fun onObjectRemovedWithView(view: NativeUserLocationView) {
        onObjectRemoved.invoke(view.toCommon())
    }

    override fun onObjectUpdatedWithView(view: NativeUserLocationView, event: NativeObjectEvent) {
        onObjectUpdated.invoke(view.toCommon(), event.toCommon())
    }
}
