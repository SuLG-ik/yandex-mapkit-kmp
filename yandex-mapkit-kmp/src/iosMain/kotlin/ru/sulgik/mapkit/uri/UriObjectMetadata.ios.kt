package ru.sulgik.mapkit.uri

import YandexMapKit.YMKUri as NativeUri
import YandexMapKit.YMKUriObjectMetadata as NativeUriObjectMetadata

public fun UriObjectMetadata.toNative(): NativeUriObjectMetadata {
    return NativeUriObjectMetadata.uriObjectMetadataWithUris(uris.map { it.toNative() })
}

@Suppress("UNCHECKED_CAST")
public fun NativeUriObjectMetadata.toCommon(): UriObjectMetadata {
    return UriObjectMetadata(uris = (uris as List<NativeUri>).map { it.toCommon() })
}
