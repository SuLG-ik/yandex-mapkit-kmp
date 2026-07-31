package ru.sulgik.mapkit

import YandexMapKit.YMKRawTile as NativeRawTile
import YandexMapKit.YMKRawTileState as NativeState
import YandexMapKit.YMKRawTileUseCache as NativeUseCache

@Suppress("UNCHECKED_CAST")
public fun RawTile.toNative(): NativeRawTile {
    return NativeRawTile.rawTileWithVersion(
        version = version.toNative(),
        features = features as Map<Any?, *>,
        etag = etag,
        useCache = useCache.toNative(),
        state = state.toNative(),
        rawData = rawData.toNSData(),
    )
}

@Suppress("UNCHECKED_CAST")
public fun NativeRawTile.toCommon(): RawTile {
    return RawTile(
        version = version.toCommon(),
        features = features as Map<String, String>,
        etag = etag,
        useCache = useCache.toCommon(),
        state = state.toCommon(),
        rawData = rawData.toByteArray(),
    )
}

public fun RawTile.UseCache.toNative(): NativeUseCache {
    return when (this) {
        RawTile.UseCache.YES -> NativeUseCache.YMKRawTileUseCacheYes
        RawTile.UseCache.NO -> NativeUseCache.YMKRawTileUseCacheNo
    }
}

public fun NativeUseCache.toCommon(): RawTile.UseCache {
    return when (this) {
        NativeUseCache.YMKRawTileUseCacheYes -> RawTile.UseCache.YES
        NativeUseCache.YMKRawTileUseCacheNo -> RawTile.UseCache.NO
        else -> throw IllegalArgumentException("Unknown NativeUseCache ($this)")
    }
}

public fun RawTile.State.toNative(): NativeState {
    return when (this) {
        RawTile.State.OK -> NativeState.YMKRawTileStateOk
        RawTile.State.NOT_MODIFIED -> NativeState.YMKRawTileStateNotModified
        RawTile.State.ERROR -> NativeState.YMKRawTileStateError
    }
}

public fun NativeState.toCommon(): RawTile.State {
    return when (this) {
        NativeState.YMKRawTileStateOk -> RawTile.State.OK
        NativeState.YMKRawTileStateNotModified -> RawTile.State.NOT_MODIFIED
        NativeState.YMKRawTileStateError -> RawTile.State.ERROR
        else -> throw IllegalArgumentException("Unknown NativeState ($this)")
    }
}
