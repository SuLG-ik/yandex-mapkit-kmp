package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.Point

/**
 * Options for a text search request.
 *
 * @property searchTypes Requested source mask. Zero searches all sources. Combine [SearchType]
 * values with the bitwise OR operator.
 * @property resultPageSize Maximum number of results per page, or `null` for the SDK default.
 * @property snippets Requested snippet mask. The default leaves snippets unrequested.
 * @property userPosition Position used by the service for distances to the results.
 * @property origin Identifier for the request source.
 * @property geometry Requests additional geometry in the response.
 * @property disableSpellingCorrection Disables spelling correction.
 */
public data class SearchOptions(
    val searchTypes: Int = SearchType.NONE.value,
    val resultPageSize: Int? = null,
    val snippets: Int = 0,
    val userPosition: Point? = null,
    val origin: String? = null,
    val geometry: Boolean = false,
    val disableSpellingCorrection: Boolean = false,
)
