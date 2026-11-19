package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKSuggestOptions as NativeSuggestOptions

public fun SuggestOptions.toNative(): NativeSuggestOptions {
    return NativeSuggestOptions.suggestOptionsWithSuggestTypes(
        suggestTypes = suggestTypes.toUInt().toULong(),
        userPosition = userPosition?.toNative(),
        suggestWords = suggestWords,
        strictBounds = strictBounds,
    )
}

public fun NativeSuggestOptions.toCommon(): SuggestOptions {
    return SuggestOptions(
        suggestTypes = suggestTypes.toInt(),
        userPosition = userPosition?.toCommon(),
        suggestWords = suggestWords,
        strictBounds = strictBounds,
    )
}
