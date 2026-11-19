package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.Point

/**
 * Fine-tunes a suggest request.
 *
 * @property suggestTypes A bitmask of [SuggestType] values. Zero uses the server's defaults.
 * @property userPosition The user's position for distances to the results.
 * @property suggestWords Enables word-by-word suggestions.
 * @property strictBounds Limits results to the requested window.
 */
public data class SuggestOptions(
    val suggestTypes: Int = SuggestType.UNSPECIFIED.value,
    val userPosition: Point? = null,
    val suggestWords: Boolean = false,
    val strictBounds: Boolean = false,
)
