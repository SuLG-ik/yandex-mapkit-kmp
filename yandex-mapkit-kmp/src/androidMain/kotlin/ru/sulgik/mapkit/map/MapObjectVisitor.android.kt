package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.map.CircleMapObject as NativeCircleMapObject
import com.yandex.mapkit.map.ClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection
import com.yandex.mapkit.map.MapObjectCollection as NativeMapObjectCollection
import com.yandex.mapkit.map.MapObjectVisitor as NativeMapObjectVisitor
import com.yandex.mapkit.map.PlacemarkMapObject as NativePlacemarkMapObject
import com.yandex.mapkit.map.PolygonMapObject as NativePolygonMapObject
import com.yandex.mapkit.map.PolylineMapObject as NativePolylineMapObject

public actual class MapObjectVisitor actual constructor(
    private val onPlacemarkVisited: (placemark: PlacemarkMapObject) -> Unit,
    private val onPolylineVisited: (polyline: PolylineMapObject) -> Unit,
    private val onPolygonVisited: (polygon: PolygonMapObject) -> Unit,
    private val onCircleVisited: (circle: CircleMapObject) -> Unit,
    private val onCollectionVisitStart: (collection: MapObjectCollection) -> Boolean,
    private val onCollectionVisitEnd: (collection: MapObjectCollection) -> Unit,
    private val onClusterizedCollectionVisitStart: (collection: ClusterizedPlacemarkCollection) -> Boolean,
    private val onClusterizedCollectionVisitEnd: (collection: ClusterizedPlacemarkCollection) -> Unit,
) : NativeConvertible<NativeMapObjectVisitor> {

    private val nativeVisitor = object : NativeMapObjectVisitor {

        override fun onPlacemarkVisited(placemark: NativePlacemarkMapObject) {
            this@MapObjectVisitor.onPlacemarkVisited(placemark.toCommon())
        }

        override fun onPolylineVisited(polyline: NativePolylineMapObject) {
            this@MapObjectVisitor.onPolylineVisited(polyline.toCommon())
        }

        override fun onPolygonVisited(polygon: NativePolygonMapObject) {
            this@MapObjectVisitor.onPolygonVisited(polygon.toCommon())
        }

        override fun onCircleVisited(circle: NativeCircleMapObject) {
            this@MapObjectVisitor.onCircleVisited(circle.toCommon())
        }

        override fun onCollectionVisitStart(collection: NativeMapObjectCollection): Boolean {
            return this@MapObjectVisitor.onCollectionVisitStart(collection.toCommon())
        }

        override fun onCollectionVisitEnd(collection: NativeMapObjectCollection) {
            this@MapObjectVisitor.onCollectionVisitEnd(collection.toCommon())
        }

        override fun onClusterizedCollectionVisitStart(collection: NativeClusterizedPlacemarkCollection): Boolean {
            return this@MapObjectVisitor.onClusterizedCollectionVisitStart(collection.toCommon())
        }

        override fun onClusterizedCollectionVisitEnd(collection: NativeClusterizedPlacemarkCollection) {
            this@MapObjectVisitor.onClusterizedCollectionVisitEnd(collection.toCommon())
        }
    }

    override fun toNative(): NativeMapObjectVisitor {
        return nativeVisitor
    }
}
