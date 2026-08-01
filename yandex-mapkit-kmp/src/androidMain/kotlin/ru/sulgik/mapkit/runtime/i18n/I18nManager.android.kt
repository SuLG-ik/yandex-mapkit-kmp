package ru.sulgik.mapkit.runtime.i18n

import com.yandex.runtime.i18n.I18nManager as NativeI18nManager
import com.yandex.runtime.i18n.I18nManagerFactory as NativeI18nManagerFactory

/**
 * Formats distances, durations and speeds for the current locale.
 */
public actual class I18nManager internal constructor(private val nativeI18nManager: NativeI18nManager) {

    public fun toNative(): NativeI18nManager {
        return nativeI18nManager
    }

    /**
     * Converts a distance value to the current locale.
     */
    public actual fun localizeDistance(distance: Int): String {
        return nativeI18nManager.localizeDistance(distance)
    }

    /**
     * Converts a duration to the current locale.
     */
    public actual fun localizeDuration(duration: Int): String {
        return nativeI18nManager.localizeDuration(duration)
    }

    /**
     * Converts speed to the current locale.
     */
    public actual fun localizeSpeed(speed: Double): String {
        return nativeI18nManager.localizeSpeed(speed)
    }

    /**
     * Converts data size to the current locale.
     */
    public actual fun localizeDataSize(dataSize: Long): String {
        return nativeI18nManager.localizeDataSize(dataSize)
    }

    /**
     * Represents the speed with the value and unit of measurement separated.
     */
    public actual fun canonicalSpeed(speed: Double): CanonicalUnit {
        return nativeI18nManager.canonicalSpeed(speed).toCommon()
    }

    /**
     * Localizes a value represented by canonical units.
     */
    public actual fun localizeCanonicalUnit(canonicalUnit: CanonicalUnit): String {
        return nativeI18nManager.localizeCanonicalUnit(canonicalUnit.toNative())
    }

    /**
     * Localization preferences.
     */
    public actual var prefs: I18nPrefs
        get() = nativeI18nManager.prefs.toCommon()
        set(value) {
            nativeI18nManager.prefs = value.toNative()
        }

    /**
     * System of measurement used.
     */
    public actual var som: SystemOfMeasurement
        get() = nativeI18nManager.som.toCommon()
        set(value) {
            nativeI18nManager.som = value.toNative()
        }

    /**
     * Preferred time format.
     */
    public actual var timeFormat: TimeFormat
        get() = nativeI18nManager.timeFormat.toCommon()
        set(value) {
            nativeI18nManager.timeFormat = value.toNative()
        }

    /**
     * Tells if this **I18nManager** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeI18nManager.isValid

    public actual companion object {

        /**
         * The locale currently used by the runtime.
         */
        public actual fun getLocale(): String {
            return NativeI18nManagerFactory.getLocale()
        }

        /**
         * Sets the application's locale.
         */
        public actual fun setLocale(locale: String?) {
            NativeI18nManagerFactory.setLocale(locale)
        }

        /**
         * Gets the internationalization manager interface.
         */
        public actual fun getInstance(): I18nManager {
            return NativeI18nManagerFactory.getI18nManagerInstance().toCommon()
        }
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is I18nManager) return false
        if (this::class != other::class) return false
        return nativeI18nManager == other.nativeI18nManager
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeI18nManager.hashCode()
    }
}

public fun NativeI18nManager.toCommon(): I18nManager {
    return I18nManager(this)
}
