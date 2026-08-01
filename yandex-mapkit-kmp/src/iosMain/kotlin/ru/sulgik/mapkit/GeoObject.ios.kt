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
import YandexMapKit.YMKAttribution as NativeAttribution
import YandexMapKit.YMKGeoObject as NativeGeoObject
import YandexMapKit.YMKGeoObjectInspectionMetadata as NativeGeoObjectInspectionMetadata
import YandexMapKit.YMKGeoObjectSelectionMetadata as NativeGeoObjectSelectionMetadata
import YandexMapKit.YMKGeoObjectTags as NativeGeoObjectTags
import YandexMapKit.YMKGeometry as NativeGeometry
import YandexMapKit.YMKPersonalizedPoiExtraMetadata as NativePersonalizedPoiExtraMetadata
import YandexMapKit.YMKUriObjectMetadata as NativeUriObjectMetadata

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
    @Suppress("UNCHECKED_CAST")
    public actual val geometry: List<Geometry>
        get() = (nativeGeoObject.geometry as List<NativeGeometry>).map { it.toCommon() }

    /**
     * A rectangular box around the object.
     */
    public actual val boundingBox: BoundingBox?
        get() = nativeGeoObject.boundingBox?.toCommon()

    /**
     * The attribution of information to a specific author.
     */
    @Suppress("UNCHECKED_CAST")
    public actual val attributionMap: Map<String, Attribution>
        get() = (nativeGeoObject.attributionMap as Map<String, NativeAttribution>)
            .mapValues { it.value.toCommon() }

    /**
     * The name of the internet resource.
     */
    @Suppress("UNCHECKED_CAST")
    public actual val aref: List<String>
        get() = nativeGeoObject.aref as List<String>

    /**
     * Identifies the object so that it can be passed to
     * [ru.sulgik.mapkit.map.Map.selectGeoObject], or `null` if the object cannot be selected.
     */
    public actual val selectionMetadata: GeoObjectSelectionMetadata?
        get() = (nativeGeoObject.metadataContainer.getItemOfClass(NativeGeoObjectSelectionMetadata) as? NativeGeoObjectSelectionMetadata)
            ?.toCommon()

    /**
     * The geometry kind of the object, or `null` if MapKit reported none.
     */
    public actual val inspectionMetadata: GeoObjectInspectionMetadata?
        get() = (nativeGeoObject.metadataContainer.getItemOfClass(NativeGeoObjectInspectionMetadata) as? NativeGeoObjectInspectionMetadata)
            ?.toCommon()

    /**
     * The tags of the object, or `null` if MapKit reported none.
     */
    public actual val tags: GeoObjectTags?
        get() = (nativeGeoObject.metadataContainer.getItemOfClass(NativeGeoObjectTags) as? NativeGeoObjectTags)
            ?.toCommon()

    /**
     * The links to the object, or `null` if MapKit reported none.
     */
    public actual val uriMetadata: UriObjectMetadata?
        get() = (nativeGeoObject.metadataContainer.getItemOfClass(NativeUriObjectMetadata) as? NativeUriObjectMetadata)
            ?.toCommon()

    /**
     * The extra data of a personalized POI, or `null` if the object is not one.
     */
    public actual val personalizedPoiMetadata: PersonalizedPoiExtraMetadata?
        get() = (nativeGeoObject.metadataContainer.getItemOfClass(NativePersonalizedPoiExtraMetadata) as? NativePersonalizedPoiExtraMetadata)
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
