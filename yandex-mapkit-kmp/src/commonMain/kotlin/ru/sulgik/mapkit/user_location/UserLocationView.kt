package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.PlacemarkMapObject

public expect class UserLocationView {
    public val arrow: PlacemarkMapObject
    public val pin: PlacemarkMapObject
    public val accuracyCircle: CircleMapObject
    public val isValid: Boolean

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
