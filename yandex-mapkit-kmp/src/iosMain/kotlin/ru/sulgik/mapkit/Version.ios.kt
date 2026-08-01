package ru.sulgik.mapkit

import YandexMapKit.YMKVersion as NativeVersion

public fun Version.toNative(): NativeVersion {
    return NativeVersion.versionWithStr(str)
}

public fun NativeVersion.toCommon(): Version {
    return Version(str = str)
}
