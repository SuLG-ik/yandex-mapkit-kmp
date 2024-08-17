package ru.sulgik.mapkit.compose

import ru.sulgik.mapkit.logo.Logo
import ru.sulgik.mapkit.logo.LogoAlignment
import ru.sulgik.mapkit.logo.LogoPadding
import ru.sulgik.mapkit.map.Map

/**
 * Config to control Yandex logo object with [Map.getLogo]
 */
public data class MapLogoConfig(
    /**
     * Set Yandex Map logo alignment via [Logo.setAlignment].
     *
     * If null use map's default value
     */
    val alignment: LogoAlignment? = null,
    /**
     * Set Yandex Map logo alignment via [Logo.setPadding].
     *
     * If null use map's default value
     */
    val padding: LogoPadding? = null,
)