package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ConflictResolutionMode

public expect class RootMapObjectCollection : MapObjectCollection {

    public var conflictResolutionMode: ConflictResolutionMode
}
