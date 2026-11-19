package ru.sulgik.mapkit.search

import YandexMapKit.YMKSuggestItem as NativeSuggestItem
import YandexMapKit.YMKSuggestResponse as NativeSuggestResponse

public fun SuggestResponse.toNative(): NativeSuggestResponse {
    return NativeSuggestResponse.suggestResponseWithItems(items.map { it.toNative() })
}

@Suppress("UNCHECKED_CAST")
public fun NativeSuggestResponse.toCommon(): SuggestResponse {
    return SuggestResponse((items as List<NativeSuggestItem>).map { it.toCommon() })
}
