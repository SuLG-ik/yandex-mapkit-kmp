package ru.sulgik.mapkit.layers

import YandexMapKit.YMKTileFormat as NativeTileFormat

public fun TileFormat.toNative(): NativeTileFormat {
    return when (this) {
        TileFormat.PNG -> NativeTileFormat.YMKTileFormatPng
        TileFormat.JPG -> NativeTileFormat.YMKTileFormatJpg
        TileFormat.VECTOR2 -> NativeTileFormat.YMKTileFormatVector2
        TileFormat.VECTOR3 -> NativeTileFormat.YMKTileFormatVector3
        TileFormat.GEO_JSON -> NativeTileFormat.YMKTileFormatGeoJson
    }
}

public fun NativeTileFormat.toCommon(): TileFormat {
    return when (this) {
        NativeTileFormat.YMKTileFormatPng -> TileFormat.PNG
        NativeTileFormat.YMKTileFormatJpg -> TileFormat.JPG
        NativeTileFormat.YMKTileFormatVector2 -> TileFormat.VECTOR2
        NativeTileFormat.YMKTileFormatVector3 -> TileFormat.VECTOR3
        NativeTileFormat.YMKTileFormatGeoJson -> TileFormat.GEO_JSON
        else -> throw IllegalArgumentException("Unknown NativeTileFormat ($this)")
    }
}
