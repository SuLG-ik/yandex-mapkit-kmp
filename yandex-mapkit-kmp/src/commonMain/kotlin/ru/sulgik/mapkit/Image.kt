package ru.sulgik.mapkit

/**
 * An image of a geo object.
 */
public data class Image(
    /**
     * urlTemplate for the image.
     */
    val urlTemplate: String,
    /**
     * Image sizes.
     */
    val sizes: List<ImageSize>,
    /**
     * Image tags.
     */
    val tags: List<String>,
) {

    public data class ImageSize(
        val size: String,
        val width: Int?,
        val height: Int?,
    )
}
