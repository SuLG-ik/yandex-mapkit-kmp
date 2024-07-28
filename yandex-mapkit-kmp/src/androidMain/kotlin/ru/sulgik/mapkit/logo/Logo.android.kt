package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Logo as NativeLogo

actual class Logo internal constructor(private val nativeLogo: NativeLogo) {

    fun toNative(): NativeLogo {
        return nativeLogo
    }

    actual fun setAlignment(alignment: Alignment) {
        nativeLogo.setAlignment(alignment.toNative())
    }

    actual fun setPadding(padding: Padding) {
        nativeLogo.setPadding(padding.toNative())
    }

}

fun NativeLogo.toCommon(): Logo {
    return Logo(this)
}