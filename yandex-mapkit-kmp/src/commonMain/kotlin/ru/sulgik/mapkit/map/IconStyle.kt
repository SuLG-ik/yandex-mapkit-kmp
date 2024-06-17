package ru.sulgik.mapkit.map

// TODO: add anchor and tappableArea
data class IconStyle(
    val rotationType: RotationType? = RotationType.NO_ROTATION,
    val zIndex: Float? = null,
    val flat: Boolean? = false,
    val isVisible: Boolean? = true,
    val scale: Float? = 1f,
)