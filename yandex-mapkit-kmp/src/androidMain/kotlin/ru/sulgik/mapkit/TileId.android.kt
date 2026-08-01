package ru.sulgik.mapkit

import com.yandex.mapkit.TileId as NativeTileId

public fun TileId.toNative(): NativeTileId {
    return NativeTileId(x, y, z)
}

public fun NativeTileId.toCommon(): TileId {
    return TileId(x = x, y = y, z = z)
}
