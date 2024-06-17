package ru.sulgik.mapkit.map

import com.yandex.runtime.image.ImageProvider as NativeImageProvider

actual interface ImageProvider {

    fun toNative(): NativeImageProvider

    companion object

}