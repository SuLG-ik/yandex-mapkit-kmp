package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent

expect class UserLocationObjectListener(
    onObjectAdded: (view: UserLocationView) -> Unit,
    onObjectRemoved: (view: UserLocationView) -> Unit,
    onObjectUpdated: (view: UserLocationView, event: ObjectEvent) -> Unit,
)