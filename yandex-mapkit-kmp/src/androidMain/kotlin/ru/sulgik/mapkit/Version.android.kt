package ru.sulgik.mapkit

import com.yandex.mapkit.Version as NativeVersion

public fun Version.toNative(): NativeVersion {
    return NativeVersion(str)
}

public fun NativeVersion.toCommon(): Version {
    return Version(str = str)
}
