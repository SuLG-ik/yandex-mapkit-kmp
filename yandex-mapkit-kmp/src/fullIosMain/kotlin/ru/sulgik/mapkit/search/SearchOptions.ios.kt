package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toNSNumber
import YandexMapKit.YMKSearchOptions as NativeSearchOptions

/** Converts the supported text search options to MapKit. */
public fun SearchOptions.toNative(): NativeSearchOptions {
    return NativeSearchOptions.searchOptionsWithSearchTypes(
        searchTypes = searchTypes.toUInt().toULong(),
        resultPageSize = resultPageSize?.toNSNumber(),
        snippets = snippets.toUInt().toULong(),
        userPosition = userPosition?.toNative(),
        origin = origin,
        geometry = geometry,
        disableSpellingCorrection = disableSpellingCorrection,
        filters = null,
    )
}

/** Reads the supported text search options from MapKit. */
public fun NativeSearchOptions.toCommon(): SearchOptions {
    return SearchOptions(
        searchTypes = searchTypes.toInt(),
        resultPageSize = resultPageSize?.intValue,
        snippets = snippets.toInt(),
        userPosition = userPosition?.toCommon(),
        origin = origin,
        geometry = geometry,
        disableSpellingCorrection = disableSpellingCorrection,
    )
}
