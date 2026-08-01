package ru.sulgik.mapkit.runtime.i18n

import com.yandex.runtime.i18n.I18nPrefs as NativeI18nPrefs

public fun I18nPrefs.toNative(): NativeI18nPrefs {
    return NativeI18nPrefs(som.toNative(), timeFormat.toNative())
}

public fun NativeI18nPrefs.toCommon(): I18nPrefs {
    return I18nPrefs(som = som.toCommon(), timeFormat = timeFormat.toCommon())
}
