package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Logo as NativeLogo

public actual class Logo internal constructor(private val nativeLogo: NativeLogo) {

    public fun toNative(): NativeLogo {
        return nativeLogo
    }

    public actual fun setAlignment(alignment: LogoAlignment) {
        nativeLogo.setAlignment(alignment.toNative())
    }

    public actual fun setPadding(logoPadding: LogoPadding) {
        nativeLogo.setPadding(logoPadding.toNative())
    }

}

public fun NativeLogo.toCommon(): Logo {
    return Logo(this)
}