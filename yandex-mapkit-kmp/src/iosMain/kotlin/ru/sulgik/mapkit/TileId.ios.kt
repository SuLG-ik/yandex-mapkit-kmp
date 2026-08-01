package ru.sulgik.mapkit

import YandexMapKit.YMKTileId as NativeTileId

public fun TileId.toNative(): NativeTileId {
    return NativeTileId.tileIdWithX(x = x.toULong(), y = y.toULong(), z = z.toULong())
}

public fun NativeTileId.toCommon(): TileId {
    return TileId(x = x.toInt(), y = y.toInt(), z = z.toInt())
}
