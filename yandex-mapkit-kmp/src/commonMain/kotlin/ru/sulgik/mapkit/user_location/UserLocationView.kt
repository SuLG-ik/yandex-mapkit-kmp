package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.PlacemarkMapObject

public expect class UserLocationView{
    public val arrow: PlacemarkMapObject
    public val pin: PlacemarkMapObject
    public val accuracyCircle: CircleMapObject
}