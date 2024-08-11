package ru.sulgik.mapkit.geometry

public data class Geometry internal constructor(
    val point: Point? = null,
    val polyline: Polyline? = null,
    val polygon: Polygon? = null,
    val multiPolygon: MultiPolygon? = null,
    val boundingBox: BoundingBox? = null,
    val circle: Circle? = null,
) {
    public companion object {
        public fun fromPoint(point: Point): Geometry {
            return Geometry(point = point)
        }

        public fun fromPolyline(polyline: Polyline): Geometry {
            return Geometry(polyline = polyline)
        }

        public fun fromPolygon(polygon: Polygon): Geometry {
            return Geometry(polygon = polygon)
        }

        public fun fromMultipolygon(multiPolygon: MultiPolygon): Geometry {
            return Geometry(multiPolygon = multiPolygon)
        }

        public fun fromBoundingBox(boundingBox: BoundingBox): Geometry {
            return Geometry(boundingBox = boundingBox)
        }

        public fun fromCircle(circle: Circle): Geometry {
            return Geometry(circle = circle)
        }
    }
}

public fun Point.toGeometry(): Geometry {
    return Geometry.fromPoint(this)
}

public fun Polyline.toGeometry(): Geometry {
    return Geometry.fromPolyline(this)
}

public fun Polygon.toGeometry(): Geometry {
    return Geometry.fromPolygon(this)
}

public fun MultiPolygon.toGeometry(): Geometry {
    return Geometry.fromMultipolygon(this)
}

public fun BoundingBox.toGeometry(): Geometry {
    return Geometry.fromBoundingBox(this)
}

public fun Circle.toGeometry(): Geometry {
    return Geometry.fromCircle(this)
}
