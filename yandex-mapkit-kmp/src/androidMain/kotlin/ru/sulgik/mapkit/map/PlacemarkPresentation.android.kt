package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.CompositeIcon as NativeCompositeIcon
import com.yandex.mapkit.map.Icon as NativeIcon
import com.yandex.mapkit.map.Model as NativeModel
import com.yandex.mapkit.map.PlacemarkAnimation as NativePlacemarkAnimation
import com.yandex.mapkit.map.PlacemarkPresentation as NativePlacemarkPresentation

/**
 * A general interface for placemark presentation objects.
 */
public actual open class PlacemarkPresentation internal constructor(
    private val nativePlacemarkPresentation: NativePlacemarkPresentation,
) {

    public open fun toNative(): NativePlacemarkPresentation {
        return nativePlacemarkPresentation
    }

    /**
     * Removes the presentation.
     */
    public actual fun remove() {
        nativePlacemarkPresentation.remove()
    }

    /**
     * Tells if this **PlacemarkPresentation** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativePlacemarkPresentation.isValid
}

public fun NativePlacemarkPresentation.toCommon(): PlacemarkPresentation {
    return when (this) {
        is NativeIcon -> toCommon()
        is NativeCompositeIcon -> toCommon()
        is NativeModel -> toCommon()
        is NativePlacemarkAnimation -> toCommon()
        else -> PlacemarkPresentation(this)
    }
}
