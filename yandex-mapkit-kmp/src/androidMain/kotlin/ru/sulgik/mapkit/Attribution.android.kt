package ru.sulgik.mapkit

import com.yandex.mapkit.Attribution as NativeAttribution

public fun Attribution.toNative(): NativeAttribution {
    return NativeAttribution(author?.toNative(), link?.toNative(), avatarImage?.toNative())
}

public fun NativeAttribution.toCommon(): Attribution {
    return Attribution(
        author = author?.toCommon(),
        link = link?.toCommon(),
        avatarImage = avatarImage?.toCommon(),
    )
}

public fun Attribution.Author.toNative(): NativeAttribution.Author {
    return NativeAttribution.Author(name, uri, email)
}

public fun NativeAttribution.Author.toCommon(): Attribution.Author {
    return Attribution.Author(name = name, uri = uri, email = email)
}

public fun Attribution.Link.toNative(): NativeAttribution.Link {
    return NativeAttribution.Link(href)
}

public fun NativeAttribution.Link.toCommon(): Attribution.Link {
    return Attribution.Link(href = href)
}
