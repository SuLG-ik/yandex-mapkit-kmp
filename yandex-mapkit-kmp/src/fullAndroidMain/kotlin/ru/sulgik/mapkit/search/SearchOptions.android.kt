package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.search.SearchOptions as NativeSearchOptions

/** Converts the supported text search options to MapKit. */
public fun SearchOptions.toNative(): NativeSearchOptions {
    return NativeSearchOptions()
        .setSearchTypes(searchTypes)
        .setResultPageSize(resultPageSize)
        .setSnippets(snippets)
        .setUserPosition(userPosition?.toNative())
        .setOrigin(origin)
        .setGeometry(geometry)
        .setDisableSpellingCorrection(disableSpellingCorrection)
}

/** Reads the supported text search options from MapKit. */
public fun NativeSearchOptions.toCommon(): SearchOptions {
    return SearchOptions(
        searchTypes = searchTypes,
        resultPageSize = resultPageSize,
        snippets = snippets,
        userPosition = userPosition?.toCommon(),
        origin = origin,
        geometry = geometry,
        disableSpellingCorrection = disableSpellingCorrection,
    )
}
