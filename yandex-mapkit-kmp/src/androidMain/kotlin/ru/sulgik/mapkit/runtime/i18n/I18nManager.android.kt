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

    public actual fun localizeDistance(distance: Int): String {
        return nativeI18nManager.localizeDistance(distance)
    }

    public actual fun localizeDuration(duration: Int): String {
        return nativeI18nManager.localizeDuration(duration)
    }

    public actual fun localizeSpeed(speed: Double): String {
        return nativeI18nManager.localizeSpeed(speed)
    }

    public actual fun localizeDataSize(dataSize: Long): String {
        return nativeI18nManager.localizeDataSize(dataSize)
    }

    public actual fun canonicalSpeed(speed: Double): CanonicalUnit {
        return nativeI18nManager.canonicalSpeed(speed).toCommon()
    }

    public actual fun localizeCanonicalUnit(canonicalUnit: CanonicalUnit): String {
        return nativeI18nManager.localizeCanonicalUnit(canonicalUnit.toNative())
    }

    public actual var prefs: I18nPrefs
        get() = nativeI18nManager.prefs.toCommon()
        set(value) {
            nativeI18nManager.prefs = value.toNative()
        }

    public actual var som: SystemOfMeasurement
        get() = nativeI18nManager.som.toCommon()
        set(value) {
            nativeI18nManager.som = value.toNative()
        }

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

        public actual fun getLocale(): String {
            return NativeI18nManagerFactory.getLocale()
        }

        public actual fun setLocale(locale: String?) {
            NativeI18nManagerFactory.setLocale(locale)
        }

        public actual fun getInstance(): I18nManager {
            return NativeI18nManagerFactory.getI18nManagerInstance().toCommon()
        }
    }
}

public fun NativeI18nManager.toCommon(): I18nManager {
    return I18nManager(this)
}
