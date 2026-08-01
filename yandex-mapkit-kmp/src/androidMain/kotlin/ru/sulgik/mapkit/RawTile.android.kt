package ru.sulgik.mapkit

import com.yandex.mapkit.RawTile as NativeRawTile

public fun RawTile.toNative(): NativeRawTile {
    return NativeRawTile(
        version.toNative(),
        features,
        etag,
        useCache.toNative(),
        state.toNative(),
        rawData,
    )
}

public fun NativeRawTile.toCommon(): RawTile {
    return RawTile(
        version = version.toCommon(),
        features = features,
        etag = etag,
        useCache = useCache.toCommon(),
        state = state.toCommon(),
        rawData = rawData,
    )
}

public fun RawTile.UseCache.toNative(): NativeRawTile.UseCache {
    return when (this) {
        RawTile.UseCache.YES -> NativeRawTile.UseCache.YES
        RawTile.UseCache.NO -> NativeRawTile.UseCache.NO
    }
}

public fun NativeRawTile.UseCache.toCommon(): RawTile.UseCache {
    return when (this) {
        NativeRawTile.UseCache.YES -> RawTile.UseCache.YES
        NativeRawTile.UseCache.NO -> RawTile.UseCache.NO
    }
}

public fun RawTile.State.toNative(): NativeRawTile.State {
    return when (this) {
        RawTile.State.OK -> NativeRawTile.State.OK
        RawTile.State.NOT_MODIFIED -> NativeRawTile.State.NOT_MODIFIED
        RawTile.State.ERROR -> NativeRawTile.State.ERROR
    }
}

public fun NativeRawTile.State.toCommon(): RawTile.State {
    return when (this) {
        NativeRawTile.State.OK -> RawTile.State.OK
        NativeRawTile.State.NOT_MODIFIED -> RawTile.State.NOT_MODIFIED
        NativeRawTile.State.ERROR -> RawTile.State.ERROR
    }
}
