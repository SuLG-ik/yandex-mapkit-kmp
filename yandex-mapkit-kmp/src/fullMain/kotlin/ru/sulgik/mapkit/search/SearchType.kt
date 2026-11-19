package ru.sulgik.mapkit.search

/** A source bit for [SearchOptions.searchTypes]. */
public enum class SearchType(public val value: Int) {
    /** Default mask, which requests all sources. */
    NONE(0),

    /** Toponyms. */
    GEO(1),

    /** Companies. */
    BIZ(2),
}
