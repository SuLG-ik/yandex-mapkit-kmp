package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent

public expect abstract class UserLocationObjectListener() {

    public abstract fun onObjectAdded(view: UserLocationView)

    public abstract fun onObjectRemoved(view: UserLocationView)

    public abstract fun onObjectUpdated(view: UserLocationView, event: ObjectEvent)

}

public inline fun UserLocationObjectListener(
    crossinline onObjectAdded: (view: UserLocationView) -> Unit,
    crossinline onObjectRemoved: (view: UserLocationView) -> Unit,
    crossinline onObjectUpdated: (view: UserLocationView, event: ObjectEvent) -> Unit,
): UserLocationObjectListener {
    return object : UserLocationObjectListener() {
        override fun onObjectAdded(view: UserLocationView) {
            onObjectAdded.invoke(view)
        }

        override fun onObjectRemoved(view: UserLocationView) {
            onObjectRemoved.invoke(view)
        }

        override fun onObjectUpdated(view: UserLocationView, event: ObjectEvent) {
            onObjectUpdated.invoke(view, event)
        }

    }
}