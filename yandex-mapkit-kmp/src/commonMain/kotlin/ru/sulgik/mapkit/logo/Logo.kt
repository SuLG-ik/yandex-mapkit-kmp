package ru.sulgik.mapkit.logo

public expect class Logo {

    public fun setAlignment(alignment: LogoAlignment)

    public fun setPadding(logoPadding: LogoPadding)

    public val isValid: Boolean
}