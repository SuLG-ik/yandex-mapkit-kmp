package ru.sulgik.mapkit.search

import YandexMapKit.YMKSearchManagerType as NativeSearchManagerType

public fun SearchManagerType.toNative(): NativeSearchManagerType {
    return when (this) {
        SearchManagerType.ONLINE -> NativeSearchManagerType.YMKSearchManagerTypeOnline
        SearchManagerType.OFFLINE -> NativeSearchManagerType.YMKSearchManagerTypeOffline
        SearchManagerType.COMBINED -> NativeSearchManagerType.YMKSearchManagerTypeCombined
    }
}

public fun NativeSearchManagerType.toCommon(): SearchManagerType {
    return when (this) {
        NativeSearchManagerType.YMKSearchManagerTypeOnline -> SearchManagerType.ONLINE
        NativeSearchManagerType.YMKSearchManagerTypeOffline -> SearchManagerType.OFFLINE
        NativeSearchManagerType.YMKSearchManagerTypeCombined -> SearchManagerType.COMBINED
        else -> throw IllegalArgumentException("Unknown NativeSearchManagerType ($this)")
    }
}
