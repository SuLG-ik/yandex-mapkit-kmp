package ru.sulgik.mapkit.uri

import com.yandex.mapkit.uri.UriObjectMetadata as NativeUriObjectMetadata

public fun UriObjectMetadata.toNative(): NativeUriObjectMetadata {
    return NativeUriObjectMetadata(uris.map { it.toNative() })
}

public fun NativeUriObjectMetadata.toCommon(): UriObjectMetadata {
    return UriObjectMetadata(uris = uris.map { it.toCommon() })
}
