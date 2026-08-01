package ru.sulgik.mapkit.compose

import ru.sulgik.mapkit.logo.Logo
import ru.sulgik.mapkit.logo.LogoAlignment
import ru.sulgik.mapkit.logo.LogoPadding
import ru.sulgik.mapkit.map.Map

/**
 * Config to control Yandex logo object with [Map.logo]
 */
public data class MapLogoConfig(
    /**
     * Set Yandex Map logo alignment via [Logo.setAlignment].
     *
     * Left untouched when null: the value is applied only while it is not null, and setting it
     * back to null does not restore the map's default.
     */
    val alignment: LogoAlignment? = null,
    /**
     * Set Yandex Map logo alignment via [Logo.setPadding].
     *
     * Left untouched when null: the value is applied only while it is not null, and setting it
     * back to null does not restore the map's default.
     */
    val padding: LogoPadding? = null,
)
