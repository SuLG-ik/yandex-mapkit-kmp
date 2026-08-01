package ru.sulgik.mapkit.runtime.i18n

import com.yandex.runtime.i18n.CanonicalUnit as NativeCanonicalUnit

public fun CanonicalUnit.toNative(): NativeCanonicalUnit {
    return NativeCanonicalUnit(unit, value)
}

public fun NativeCanonicalUnit.toCommon(): CanonicalUnit {
    return CanonicalUnit(unit = unit, value = value)
}
