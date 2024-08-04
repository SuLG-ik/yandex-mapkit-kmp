package ru.sulgik.mapkit.map

public expect open class BaseMapObjectCollection: MapObject {

    public fun traverse(mapObjectVisitor: MapObjectVisitor)

    public fun remove(mapObject: MapObject)

    public fun clear()

    public fun addListener(collectionListener: MapObjectCollectionListener)

    public fun removeListener(collectionListener: MapObjectCollectionListener)

}