package ru.sulgik.mapkit.search

import com.yandex.mapkit.search.SuggestResponse as NativeSuggestResponse

public fun SuggestResponse.toNative(): NativeSuggestResponse {
    return NativeSuggestResponse(items.map { it.toNative() })
}

public fun NativeSuggestResponse.toCommon(): SuggestResponse {
    return SuggestResponse(items.map { it.toCommon() })
}
