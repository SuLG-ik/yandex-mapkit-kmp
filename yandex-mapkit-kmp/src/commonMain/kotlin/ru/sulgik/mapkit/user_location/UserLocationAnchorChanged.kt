package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent

public expect class UserLocationAnchorChanged: ObjectEvent {

    public val anchorType: UserLocationAnchorType

}