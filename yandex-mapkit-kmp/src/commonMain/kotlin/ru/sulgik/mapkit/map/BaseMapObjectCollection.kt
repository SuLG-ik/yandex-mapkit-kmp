package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.WeakRef

public expect open class BaseMapObjectCollection : MapObject {

    public fun traverse(mapObjectVisitor: WeakRef<MapObjectVisitor>)

    public fun remove(mapObject: MapObject)

    public fun clear()

    public fun addListener(collectionListener: WeakRef<MapObjectCollectionListener>)

    public fun removeListener(collectionListener: WeakRef<MapObjectCollectionListener>)
}
