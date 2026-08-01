package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.map.GeoObjectInspectionMetadata
import ru.sulgik.mapkit.map.GeoObjectSelectionMetadata
import ru.sulgik.mapkit.map.GeoObjectTags
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.personalized_poi.PersonalizedPoiExtraMetadata
import ru.sulgik.mapkit.personalized_poi.toCommon
import ru.sulgik.mapkit.uri.UriObjectMetadata
import ru.sulgik.mapkit.uri.toCommon
import com.yandex.mapkit.GeoObject as NativeGeoObject
import com.yandex.mapkit.map.GeoObjectInspectionMetadata as NativeGeoObjectInspectionMetadata
import com.yandex.mapkit.map.GeoObjectSelectionMetadata as NativeGeoObjectSelectionMetadata
import com.yandex.mapkit.map.GeoObjectTags as NativeGeoObjectTags
import com.yandex.mapkit.personalized_poi.PersonalizedPoiExtraMetadata as NativePersonalizedPoiExtraMetadata
import com.yandex.mapkit.uri.UriObjectMetadata as NativeUriObjectMetadata

/**
 * An object of the base map: a POI, a building, a toponym.
 *
 * This is a wrapper class rather than a value type because MapKit keeps the object's metadata in a
 * dictionary keyed by native types, which has no common representation; the metadata is read
 * through the typed accessors below.
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

    /**
     * The links to the object, or `null` if MapKit reported none.
     */
    public actual val uriMetadata: UriObjectMetadata?
        get() = nativeGeoObject.metadataContainer
            .getItem(NativeUriObjectMetadata::class.java)
            ?.toCommon()

    /**
     * The extra data of a personalized POI, or `null` if the object is not one.
     */
    public actual val personalizedPoiMetadata: PersonalizedPoiExtraMetadata?
        get() = nativeGeoObject.metadataContainer
            .getItem(NativePersonalizedPoiExtraMetadata::class.java)
            ?.toCommon()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GeoObject) return false
        if (this::class != other::class) return false
        return nativeGeoObject == other.nativeGeoObject
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeGeoObject.hashCode()
    }
}

public fun NativeGeoObject.toCommon(): GeoObject {
    return GeoObject(this)
}
