package ru.sulgik.mapkit.offline_cache

import com.yandex.mapkit.offline_cache.RegionState as NativeRegionState

public fun RegionState.toNative(): NativeRegionState {
    return when (this) {
        RegionState.AVAILABLE -> NativeRegionState.AVAILABLE
        RegionState.DOWNLOADING -> NativeRegionState.DOWNLOADING
        RegionState.PAUSED -> NativeRegionState.PAUSED
        RegionState.COMPLETED -> NativeRegionState.COMPLETED
        RegionState.OUTDATED -> NativeRegionState.OUTDATED
        RegionState.UNSUPPORTED -> NativeRegionState.UNSUPPORTED
        RegionState.NEED_UPDATE -> NativeRegionState.NEED_UPDATE
    }
}

public fun NativeRegionState.toCommon(): RegionState {
    return when (this) {
        NativeRegionState.AVAILABLE -> RegionState.AVAILABLE
        NativeRegionState.DOWNLOADING -> RegionState.DOWNLOADING
        NativeRegionState.PAUSED -> RegionState.PAUSED
        NativeRegionState.COMPLETED -> RegionState.COMPLETED
        NativeRegionState.OUTDATED -> RegionState.OUTDATED
        NativeRegionState.UNSUPPORTED -> RegionState.UNSUPPORTED
        NativeRegionState.NEED_UPDATE -> RegionState.NEED_UPDATE
    }
}
