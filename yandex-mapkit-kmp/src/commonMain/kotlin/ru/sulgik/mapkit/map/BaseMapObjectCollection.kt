package ru.sulgik.mapkit.map

expect open class BaseMapObjectCollection: MapObject {

    fun traverse(mapObjectVisitor: MapObjectVisitor)

    fun remove(mapObject: MapObject)

    fun clear()

    fun addListener(collectionListener: MapObjectCollectionListener)

    fun removeListener(collectionListener: MapObjectCollectionListener)

}