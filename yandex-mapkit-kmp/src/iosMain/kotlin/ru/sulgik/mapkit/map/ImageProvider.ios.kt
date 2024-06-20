package ru.sulgik.mapkit.map

import platform.UIKit.UIImage

actual interface ImageProvider {

    fun toNative(): UIImage

}