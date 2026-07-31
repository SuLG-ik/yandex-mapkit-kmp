package ru.sulgik.mapkit.offline_cache

import YandexMapKit.YMKOfflineCacheRegionState as NativeRegionState

public fun RegionState.toNative(): NativeRegionState {
    return when (this) {
        RegionState.AVAILABLE -> NativeRegionState.YMKOfflineCacheRegionStateAvailable
        RegionState.DOWNLOADING -> NativeRegionState.YMKOfflineCacheRegionStateDownloading
        RegionState.PAUSED -> NativeRegionState.YMKOfflineCacheRegionStatePaused
        RegionState.COMPLETED -> NativeRegionState.YMKOfflineCacheRegionStateCompleted
        RegionState.OUTDATED -> NativeRegionState.YMKOfflineCacheRegionStateOutdated
        RegionState.UNSUPPORTED -> NativeRegionState.YMKOfflineCacheRegionStateUnsupported
        RegionState.NEED_UPDATE -> NativeRegionState.YMKOfflineCacheRegionStateNeedUpdate
    }
}

public fun NativeRegionState.toCommon(): RegionState {
    return when (this) {
        NativeRegionState.YMKOfflineCacheRegionStateAvailable -> RegionState.AVAILABLE
        NativeRegionState.YMKOfflineCacheRegionStateDownloading -> RegionState.DOWNLOADING
        NativeRegionState.YMKOfflineCacheRegionStatePaused -> RegionState.PAUSED
        NativeRegionState.YMKOfflineCacheRegionStateCompleted -> RegionState.COMPLETED
        NativeRegionState.YMKOfflineCacheRegionStateOutdated -> RegionState.OUTDATED
        NativeRegionState.YMKOfflineCacheRegionStateUnsupported -> RegionState.UNSUPPORTED
        NativeRegionState.YMKOfflineCacheRegionStateNeedUpdate -> RegionState.NEED_UPDATE
        else -> throw IllegalArgumentException("Unknown NativeRegionState ($this)")
    }
}
