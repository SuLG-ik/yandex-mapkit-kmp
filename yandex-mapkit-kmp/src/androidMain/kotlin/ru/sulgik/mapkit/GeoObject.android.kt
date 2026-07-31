package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.map.GeoObjectInspectionMetadata
import ru.sulgik.mapkit.map.GeoObjectSelectionMetadata
import ru.sulgik.mapkit.map.GeoObjectTags
import ru.sulgik.mapkit.map.toCommon
import com.yandex.mapkit.GeoObject as NativeGeoObject
import com.yandex.mapkit.map.GeoObjectInspectionMetadata as NativeGeoObjectInspectionMetadata
import com.yandex.mapkit.map.GeoObjectSelectionMetadata as NativeGeoObjectSelectionMetadata
import com.yandex.mapkit.map.GeoObjectTags as NativeGeoObjectTags

/**
 * An object of the base map: a POI, a building, a toponym.
 */
public actual class GeoObject internal constructor(private val nativeGeoObject: NativeGeoObject) {

    public fun toNative(): NativeGeoObject {
        return nativeGeoObject
    }

    /**
     * Object name.
     */
    public actual val name: String?
        get() = nativeGeoObject.name

    /**
     * The description of the object.
     */
    public actual val descriptionText: String?
        get() = nativeGeoObject.descriptionText

    /**
     * The object's geometry.
     */
    public actual val geometry: List<Geometry>
        get() = nativeGeoObject.geometry.map { it.toCommon() }

    /**
     * A rectangular box around the object.
     */
    public actual val boundingBox: BoundingBox?
        get() = nativeGeoObject.boundingBox?.toCommon()

    /**
     * The attribution of information to a specific author.
     */
    public actual val attributionMap: Map<String, Attribution>
        get() = nativeGeoObject.attributionMap.mapValues { it.value.toCommon() }

    /**
     * The name of the internet resource.
     */
    public actual val aref: List<String>
        get() = nativeGeoObject.aref

    /**
     * Identifies the object so that it can be passed to
     * [ru.sulgik.mapkit.map.Map.selectGeoObject], or `null` if the object cannot be selected.
     */
    public actual val selectionMetadata: GeoObjectSelectionMetadata?
        get() = nativeGeoObject.metadataContainer
            .getItem(NativeGeoObjectSelectionMetadata::class.java)
            ?.toCommon()

    /**
     * The geometry kind of the object, or `null` if MapKit reported none.
     */
    public actual val inspectionMetadata: GeoObjectInspectionMetadata?
        get() = nativeGeoObject.metadataContainer
            .getItem(NativeGeoObjectInspectionMetadata::class.java)
            ?.toCommon()

    /**
     * The tags of the object, or `null` if MapKit reported none.
     */
    public actual val tags: GeoObjectTags?
        get() = nativeGeoObject.metadataContainer
            .getItem(NativeGeoObjectTags::class.java)
            ?.toCommon()
}

public fun NativeGeoObject.toCommon(): GeoObject {
    return GeoObject(this)
}
