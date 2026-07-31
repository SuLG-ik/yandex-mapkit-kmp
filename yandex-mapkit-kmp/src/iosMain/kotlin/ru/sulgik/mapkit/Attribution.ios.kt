package ru.sulgik.mapkit

import YandexMapKit.YMKAttribution as NativeAttribution
import YandexMapKit.YMKAttributionAuthor as NativeAuthor
import YandexMapKit.YMKAttributionLink as NativeLink

public fun Attribution.toNative(): NativeAttribution {
    return NativeAttribution.attributionWithAuthor(
        author = author?.toNative(),
        link = link?.toNative(),
        avatarImage = avatarImage?.toNative(),
    )
}

public fun NativeAttribution.toCommon(): Attribution {
    return Attribution(
        author = author?.toCommon(),
        link = link?.toCommon(),
        avatarImage = avatarImage?.toCommon(),
    )
}

public fun Attribution.Author.toNative(): NativeAuthor {
    return NativeAuthor.authorWithName(name = name, uri = uri, email = email)
}

public fun NativeAuthor.toCommon(): Attribution.Author {
    return Attribution.Author(name = name, uri = uri, email = email)
}

public fun Attribution.Link.toNative(): NativeLink {
    return NativeLink.linkWithHref(href)
}

public fun NativeLink.toCommon(): Attribution.Link {
    return Attribution.Link(href = href)
}
