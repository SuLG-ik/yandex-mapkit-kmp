package ru.sulgik.mapkit

/**
 * Color in ARGB color model
 */
public data class Color private constructor(internal val value: Int) {

    public companion object {
        public fun fromArgb(argb: Int): Color {
            return Color(value = argb)
        }
    }
}

public fun Color.toArgb(): Int {
    return value
}

internal fun Int.toColor(): Color {
    return Color.fromArgb(this)
}
