package ru.sulgik.mapkit.runtime.i18n

import YandexMapKit.YRTCanonicalUnit as NativeCanonicalUnit

public fun CanonicalUnit.toNative(): NativeCanonicalUnit {
    return NativeCanonicalUnit.canonicalUnitWithUnit(unit = unit, value = value)
}

public fun NativeCanonicalUnit.toCommon(): CanonicalUnit {
    return CanonicalUnit(unit = unit, value = value)
}
