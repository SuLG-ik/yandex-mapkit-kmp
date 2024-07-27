package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.PlacemarkMapObject

expect class UserLocationView{
    val arrow: PlacemarkMapObject
    val pin: PlacemarkMapObject
    val accuracyCircle: CircleMapObject
}