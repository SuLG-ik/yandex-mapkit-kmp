package ru.sulgik.mapkit.personalized_poi

import ru.sulgik.mapkit.map.BaseMetadata

/**
 * The extra data of a personalized POI.
 */
public data class PersonalizedPoiExtraMetadata(
    val data: List<Entry>,
) : BaseMetadata {

    public data class Entry(
        val key: String?,
        val value: String?,
    ) : BaseMetadata
}
