package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.search.SuggestOptions as NativeSuggestOptions

public fun SuggestOptions.toNative(): NativeSuggestOptions {
    return NativeSuggestOptions(suggestTypes, userPosition?.toNative(), suggestWords, strictBounds)
}

public fun NativeSuggestOptions.toCommon(): SuggestOptions {
    return SuggestOptions(
        suggestTypes = suggestTypes,
        userPosition = userPosition?.toCommon(),
        suggestWords = suggestWords,
        strictBounds = strictBounds,
    )
}
