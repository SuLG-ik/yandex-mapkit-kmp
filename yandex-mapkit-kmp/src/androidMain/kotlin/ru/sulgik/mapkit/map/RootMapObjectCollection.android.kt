package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ConflictResolutionMode
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.RootMapObjectCollection as NativeRootMapObjectCollection

public actual class RootMapObjectCollection internal constructor(
    private val nativeRootMapObjectCollection: NativeRootMapObjectCollection,
) : MapObjectCollection(nativeRootMapObjectCollection) {

    override fun toNative(): NativeRootMapObjectCollection {
        return nativeRootMapObjectCollection
    }

    public actual var conflictResolutionMode: ConflictResolutionMode
        get() = nativeRootMapObjectCollection.conflictResolutionMode.toCommon()
        set(value) {
            nativeRootMapObjectCollection.conflictResolutionMode = value.toNative()
        }
}

public fun NativeRootMapObjectCollection.toCommon(): RootMapObjectCollection {
    return RootMapObjectCollection(this)
}
