@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit.map

import kotlinx.cinterop.ExperimentalForeignApi
import YandexMapKit.YMKMap as NativeMap

actual class Map(private val nativeMap: NativeMap) {

    fun toNative(): NativeMap {
        return nativeMap
    }

}

fun NativeMap.toCommon(): Map {
    return Map(this)
}