---
title: "YMKSearchSnippet"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSearchSnippet"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSnippet.html"
---
# YMKSearchSnippet

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSnippet.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
struct YMKSearchSnippet : OptionSet, @unchecked Sendable
```

Requested snippets bitmask.

Snippets are additional pieces of information (possibly from different services) which are not directly stored in object metadata but may be requested separately based on client needs.

Different snippets are applicable to different objects: some of the snippets can be provided only for toponyms, some for businesses and some for all object types.

## Summary

### Enum cases

```swift
static var photos: YMKSearchSnippet { get }
```

Related photos snippet (can be requested for a business or toponym)

```swift
static var businessRating1x: YMKSearchSnippet { get }
```

Information about ratings (can be requested for a business)

```swift
static var panoramas: YMKSearchSnippet { get }
```

Nearest panoramas to this point

## Enum cases

### photos

```swift
static var photos: YMKSearchSnippet { get }
```

Related photos snippet (can be requested for a business or toponym). See YMKSearchBusinessPhotoObjectMetadata.

### businessRating1x

```swift
static var businessRating1x: YMKSearchSnippet { get }
```

Information about ratings (can be requested for a business). See YMKSearchBusinessRating1xObjectMetadata.

### panoramas

```swift
static var panoramas: YMKSearchSnippet { get }
```

Nearest panoramas to this point. See YMKSearchPanoramasObjectMetadata.
