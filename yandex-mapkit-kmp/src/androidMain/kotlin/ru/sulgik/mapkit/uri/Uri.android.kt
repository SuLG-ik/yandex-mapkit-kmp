package ru.sulgik.mapkit.uri

import com.yandex.mapkit.uri.Uri as NativeUri

public fun Uri.toNative(): NativeUri {
    return NativeUri(value)
}

public fun NativeUri.toCommon(): Uri {
    return Uri(value = value)
}
