package ru.sulgik.mapkit.runtime.i18n

/**
 * Localization preferences.
 */
public data class I18nPrefs(
    /**
     * System of measurement (metric or imperial).
     */
    val som: SystemOfMeasurement,
    /**
     * Time format (12- or 24-hour).
     */
    val timeFormat: TimeFormat,
)
