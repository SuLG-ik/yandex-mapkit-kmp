package ru.sulgik.mapkit.search

/** Flags for [SuggestOptions.suggestTypes]. Combine [value] values with bitwise OR. */
public enum class SuggestType(public val value: Int) {
    /** Server-defined types. */
    UNSPECIFIED(0),

    /** Toponyms. */
    GEO(1),

    /** Companies. */
    BIZ(1 shl 1),

    /** Public transit routes. */
    TRANSIT(1 shl 2),

    /** Organization that can be uniquely identified by the query. */
    ONE_ORG(1 shl 4),

    /** Chains. */
    CHAIN(1 shl 5),

    /** Rubrics. */
    RUBRIC(1 shl 6),

    /** Text hints. */
    TEXT_HINT(1 shl 7),

    /** Promotional queries. */
    PROMO_QUERY(1 shl 8),

    /** Coordinates. */
    COORDS(1 shl 9),
}
