package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.map.GeoObjectInspectionMetadata
import ru.sulgik.mapkit.map.GeoObjectSelectionMetadata
import ru.sulgik.mapkit.map.GeoObjectTags
import ru.sulgik.mapkit.personalized_poi.PersonalizedPoiExtraMetadata
import ru.sulgik.mapkit.uri.UriObjectMetadata

/**
 * An object of the base map: a POI, a building, a toponym.
 *
 * This is a wrapper class rather than a value type because MapKit keeps the object's metadata in a
 * dictionary keyed by native types, which has no common representation; the metadata is read
 * through the typed accessors below.
 */
public expect class GeoObject {

    /**
     * Object name.
     */
    public val name: String?

    /**
     * The description of the object.
     */
    public val descriptionText: String?

    /**
     * The object's geometry.
     */
    public val geometry: List<Geometry>

    /**
     * A rectangular box around the object.
     */
    public val boundingBox: BoundingBox?

    /**
     * The attribution of information to a specific author.
     */
    public val attributionMap: Map<String, Attribution>

    /**
     * The name of the internet resource.
     */
    public val aref: List<String>

    /**
     * Identifies the object so that it can be passed to
     * [ru.sulgik.mapkit.map.Map.selectGeoObject], or `null` if the object cannot be selected.
     */
    public val selectionMetadata: GeoObjectSelectionMetadata?

    /**
     * The geometry kind of the object, or `null` if MapKit reported none.
     */
    public val inspectionMetadata: GeoObjectInspectionMetadata?

    /**
     * The tags of the object, or `null` if MapKit reported none.
     */
    public val tags: GeoObjectTags?

    /**
     * The links to the object, or `null` if MapKit reported none.
     */
    public val uriMetadata: UriObjectMetadata?

    /**
     * The extra data of a personalized POI, or `null` if the object is not one.
     */
    public val personalizedPoiMetadata: PersonalizedPoiExtraMetadata?

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
