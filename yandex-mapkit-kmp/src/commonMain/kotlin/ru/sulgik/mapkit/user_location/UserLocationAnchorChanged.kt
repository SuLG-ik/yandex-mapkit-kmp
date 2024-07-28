package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent

expect class UserLocationAnchorChanged: ObjectEvent {

    val anchorType: UserLocationAnchorType

}