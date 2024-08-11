package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent

public expect class UserLocationIconChanged: ObjectEvent {

    public val iconType: UserLocationIconType

}