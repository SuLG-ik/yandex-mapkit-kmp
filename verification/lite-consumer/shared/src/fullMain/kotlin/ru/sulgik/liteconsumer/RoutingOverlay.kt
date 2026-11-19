package ru.sulgik.liteconsumer

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.PolylineMapObject

internal class RoutingOverlay(private val parent: MapObjectCollection) {

    private val objects = parent.addCollection()

    val isValid: Boolean
        get() = objects.isValid

    fun show(geometry: Polyline?): PolylineMapObject? {
        clear()
        if (geometry == null || !objects.isValid) return null
        return objects.addPolyline(geometry).also { line ->
            line.style = line.style.copy(strokeWidth = 7f)
            line.setStrokeColor(Color.fromArgb(0xff2b55cb.toInt()))
        }
    }

    fun clear() {
        if (objects.isValid) {
            objects.clear()
        }
    }

    fun dispose() {
        if (parent.isValid && objects.isValid) {
            parent.remove(objects)
        }
    }
}
