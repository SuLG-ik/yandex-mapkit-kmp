package ru.sulgik.mapkit.map

import YandexMapKit.YMKCompositeIcon as NativeCompositeIcon

/**
 * Provides an interface to set several icons and their styles for a placemark.
 */
public actual class CompositeIcon internal constructor(
    private val nativeCompositeIcon: NativeCompositeIcon,
) : PlacemarkPresentation(nativeCompositeIcon) {

    override fun toNative(): NativeCompositeIcon {
        return nativeCompositeIcon
    }

    /**
     * Creates or resets a named layer with an icon and its style.
     *
     * @param onFinished Called when the icon is applied.
     */
    public actual fun setIcon(
        name: String,
        image: ImageProvider,
        style: IconStyle?,
        onFinished: Callback?,
    ) {
        nativeCompositeIcon.setIconWithName(
            name,
            image.toNative(),
            style?.toNative(),
            onFinished?.toNative(),
        )
    }

    /**
     * Changes the icon style for a specific layer.
     */
    public actual fun setIconStyle(name: String, style: IconStyle) {
        nativeCompositeIcon.setIconStyleWithName(name, style.toNative())
    }

    /**
     * Returns named [Icon] object that can be used to set icon and its style.
     */
    public actual fun icon(name: String): Icon {
        return nativeCompositeIcon.iconWithName(name).toCommon()
    }

    /**
     * Removes the named layer.
     */
    public actual fun removeIcon(name: String) {
        nativeCompositeIcon.removeIconWithName(name)
    }

    /**
     * Removes all layers.
     */
    public actual fun removeAll() {
        nativeCompositeIcon.removeAll()
    }
}

public fun NativeCompositeIcon.toCommon(): CompositeIcon {
    return CompositeIcon(this)
}
