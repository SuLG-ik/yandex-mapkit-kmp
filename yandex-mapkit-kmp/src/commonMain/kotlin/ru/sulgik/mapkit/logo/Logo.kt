package ru.sulgik.mapkit.logo

public expect class Logo {

    public fun setAlignment(alignment: LogoAlignment)

    public fun setPadding(logoPadding: LogoPadding)

    public val isValid: Boolean

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
