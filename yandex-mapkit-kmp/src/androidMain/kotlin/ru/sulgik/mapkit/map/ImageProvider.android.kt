package ru.sulgik.mapkit.map

import com.yandex.runtime.image.ImageProvider as NativeImageProvider

public actual interface ImageProvider {

    public fun toNative(): NativeImageProvider

    public companion object

}