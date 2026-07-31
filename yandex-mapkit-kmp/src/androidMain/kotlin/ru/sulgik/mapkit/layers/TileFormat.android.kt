package ru.sulgik.mapkit.layers

import com.yandex.mapkit.layers.TileFormat as NativeTileFormat

public fun TileFormat.toNative(): NativeTileFormat {
    return when (this) {
        TileFormat.PNG -> NativeTileFormat.PNG
        TileFormat.JPG -> NativeTileFormat.JPG
        TileFormat.VECTOR2 -> NativeTileFormat.VECTOR2
        TileFormat.VECTOR3 -> NativeTileFormat.VECTOR3
        TileFormat.GEO_JSON -> NativeTileFormat.GEO_JSON
    }
}

public fun NativeTileFormat.toCommon(): TileFormat {
    return when (this) {
        NativeTileFormat.PNG -> TileFormat.PNG
        NativeTileFormat.JPG -> TileFormat.JPG
        NativeTileFormat.VECTOR2 -> TileFormat.VECTOR2
        NativeTileFormat.VECTOR3 -> TileFormat.VECTOR3
        NativeTileFormat.GEO_JSON -> TileFormat.GEO_JSON
    }
}
