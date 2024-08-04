package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogo as NativeLogo

public actual class Logo internal constructor(private val nativeLogo: NativeLogo){

    public fun toNative(): NativeLogo {
        return nativeLogo
    }

    public actual fun setAlignment(alignment: Alignment) {
        nativeLogo.setAlignmentWithAlignment(alignment.toNative())
    }

    public actual fun setPadding(padding: Padding) {
        nativeLogo.setPaddingWithPadding(padding.toNative())
    }

}

public fun NativeLogo.toCommon(): Logo {
    return Logo(this)
}