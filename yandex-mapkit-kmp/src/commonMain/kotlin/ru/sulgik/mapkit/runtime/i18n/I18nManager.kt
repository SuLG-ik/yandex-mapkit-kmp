package ru.sulgik.mapkit.runtime.i18n

/**
 * Formats distances, durations and speeds for the current locale.
 */
public expect class I18nManager {

    /**
     * Converts a distance value to the current locale.
     */
    public fun localizeDistance(distance: Int): String

    /**
     * Converts a duration to the current locale.
     */
    public fun localizeDuration(duration: Int): String

    /**
     * Converts speed to the current locale.
     */
    public fun localizeSpeed(speed: Double): String

    /**
     * Converts data size to the current locale.
     */
    public fun localizeDataSize(dataSize: Long): String

    /**
     * Represents the speed with the value and unit of measurement separated.
     */
    public fun canonicalSpeed(speed: Double): CanonicalUnit

    /**
     * Localizes a value represented by canonical units.
     */
    public fun localizeCanonicalUnit(canonicalUnit: CanonicalUnit): String

    /**
     * Localization preferences.
     */
    public var prefs: I18nPrefs

    /**
     * System of measurement used.
     */
    public var som: SystemOfMeasurement

    /**
     * Preferred time format.
     */
    public var timeFormat: TimeFormat

    /**
     * Tells if this **I18nManager** is valid or not.
     */
    public val isValid: Boolean

    public companion object {

        /**
         * The locale currently used by the runtime.
         */
        public fun getLocale(): String

        /**
         * Sets the application's locale.
         */
        public fun setLocale(locale: String?)

        /**
         * Gets the internationalization manager interface.
         */
        public fun getInstance(): I18nManager
    }
}
