package ru.sulgik.mapkit.geometry

data class Geometry internal constructor(
    val point: Point? = null,
    val polyline: Polyline? = null,
    val polygon: Polygon? = null,
    val multiPolygon: MultiPolygon? = null,
    val boundingBox: BoundingBox? = null,
    val circle: Circle? = null,
) {
    companion object {
        fun fromPoint(point: Point): Geometry {
            return Geometry(point = point)
        }

        fun fromPolyline(polyline: Polyline): Geometry {
            return Geometry(polyline = polyline)
        }

        fun fromPolygon(polygon: Polygon): Geometry {
            return Geometry(polygon = polygon)
        }

        fun fromMultipolygon(multiPolygon: MultiPolygon): Geometry {
            return Geometry(multiPolygon = multiPolygon)
        }

        fun fromBoundingBox(boundingBox: BoundingBox): Geometry {
            return Geometry(boundingBox = boundingBox)
        }

        fun fromCircle(circle: Circle): Geometry {
            return Geometry(circle = circle)
        }
    }
}