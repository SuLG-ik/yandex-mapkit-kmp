package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.Icon as NativeIcon

/**
 * Provides an interface to set icon and its style for a placemark.
 */
public actual class Icon internal constructor(
    private val nativeIcon: NativeIcon,
) : PlacemarkPresentation(nativeIcon) {

    override fun toNative(): NativeIcon {
        return nativeIcon
    }

    /**
     * The style properties (scale, zIndex, etc.) of the icon placemark.
     */
    public actual var style: IconStyle
        get() = nativeIcon.style.toCommon()
        set(value) {
            nativeIcon.style = value.toNative()
        }

    /**
     * Sets the image for the icon.
     *
     * @param onFinished Called when the image is applied.
     */
    public actual fun setImage(
        image: ImageProvider,
        style: IconStyle?,
        onFinished: Callback?,
    ) {
        nativeIcon.setImage(image.toNative(), style?.toNative(), onFinished?.toNative())
    }
}

public fun NativeIcon.toCommon(): Icon {
    return Icon(this)
}
