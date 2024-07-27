package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogo as NativeLogo

actual class Logo internal constructor(private val nativeLogo: NativeLogo){

    fun toNative(): NativeLogo {
        return nativeLogo
    }

    actual fun setAlignment(alignment: Alignment) {
        nativeLogo.setAlignmentWithAlignment(alignment.toNative())
    }

    actual fun setPadding(padding: Padding) {
        nativeLogo.setPaddingWithPadding(padding.toNative())
    }

}

fun NativeLogo.toCommon(): Logo {
    return Logo(this)
}