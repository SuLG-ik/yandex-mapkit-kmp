package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKArrow as NativeArrow

actual class Arrow internal constructor(private val nativeArrow: NativeArrow) {

    fun toNative(): NativeArrow {
        return nativeArrow
    }

    actual val position: PolylinePosition
        get() = nativeArrow.position.toCommon()

    actual var fillColor: Color
        get() = nativeArrow.fillColor.toCommon()
        set(value) {
            nativeArrow.fillColor = value.toNative()
        }
    actual var outlineColor: Color
        get() = nativeArrow.outlineColor.toCommon()
        set(value) {
            nativeArrow.outlineColor = value.toNative()
        }

    actual var outlineWidth: Float
        get() = nativeArrow.outlineWidth
        set(value) {
            nativeArrow.outlineWidth = value
        }
    actual var length: Float
        get() = nativeArrow.length
        set(value) {
            nativeArrow.length = value
        }
    actual var isVisible: Boolean
        get() = nativeArrow.isVisible()
        set(value) {
            nativeArrow.setVisible(value)
        }
    actual var triangleHeight: Float
        get() = nativeArrow.triangleHeight
        set(value) {
            nativeArrow.triangleHeight = value
        }

}

fun NativeArrow.toCommon(): Arrow {
    return Arrow(this)
}