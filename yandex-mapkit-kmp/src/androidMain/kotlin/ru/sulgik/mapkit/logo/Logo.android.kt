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

    public actual val isValid: Boolean
        get() = nativeLogo.isValid

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Logo) return false
        if (this::class != other::class) return false
        return nativeLogo == other.nativeLogo
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLogo.hashCode()
    }
}

public fun NativeLogo.toCommon(): Logo {
    return Logo(this)
}
