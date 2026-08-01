package ru.sulgik.mapkit.uri

import ru.sulgik.mapkit.map.BaseMetadata

/**
 * The links attached to a [ru.sulgik.mapkit.GeoObject].
 */
public data class UriObjectMetadata(
    val uris: List<Uri>,
) : BaseMetadata
