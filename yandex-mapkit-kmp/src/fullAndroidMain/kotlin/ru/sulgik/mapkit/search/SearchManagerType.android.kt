package ru.sulgik.mapkit.search

import com.yandex.mapkit.search.SearchManagerType as NativeSearchManagerType

public fun SearchManagerType.toNative(): NativeSearchManagerType {
    return when (this) {
        SearchManagerType.ONLINE -> NativeSearchManagerType.ONLINE
        SearchManagerType.OFFLINE -> NativeSearchManagerType.OFFLINE
        SearchManagerType.COMBINED -> NativeSearchManagerType.COMBINED
    }
}

public fun NativeSearchManagerType.toCommon(): SearchManagerType {
    return when (this) {
        NativeSearchManagerType.ONLINE -> SearchManagerType.ONLINE
        NativeSearchManagerType.OFFLINE -> SearchManagerType.OFFLINE
        NativeSearchManagerType.COMBINED -> SearchManagerType.COMBINED
    }
}
