package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent

expect abstract class UserLocationObjectListener() {

    abstract fun onObjectAdded(view: UserLocationView)

    abstract fun onObjectRemoved(view: UserLocationView)

    abstract fun onObjectUpdated(view: UserLocationView, event: ObjectEvent)

}

inline fun UserLocationObjectListener(
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