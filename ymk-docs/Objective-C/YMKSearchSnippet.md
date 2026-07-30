---
title: "YMKSearchSnippet"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchSnippet"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSnippet.html"
---
# YMKSearchSnippet

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSnippet.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchSnippet : NSUInteger {}
```

Requested snippets bitmask.

Snippets are additional pieces of information (possibly from different services) which are not directly stored in object metadata but may be requested separately based on client needs.

Different snippets are applicable to different objects: some of the snippets can be provided only for toponyms, some for businesses and some for all object types.

## Summary

### Enum cases

```objectivec
YMKSearchSnippetNone = 0
```

Default value: no snippets requested

```objectivec
YMKSearchSnippetPhotos = 1
```

Related photos snippet (can be requested for a business or toponym)

```objectivec
YMKSearchSnippetBusinessRating1x = 1 << 1
```

Information about ratings (can be requested for a business)

```objectivec
YMKSearchSnippetPanoramas = 1 << 5
```

Nearest panoramas to this point

## Enum cases

### YMKSearchSnippetNone

```objectivec
YMKSearchSnippetNone = 0
```

Default value: no snippets requested.

### YMKSearchSnippetPhotos

```objectivec
YMKSearchSnippetPhotos = 1
```

Related photos snippet (can be requested for a business or toponym). See YMKSearchBusinessPhotoObjectMetadata.

### YMKSearchSnippetBusinessRating1x

```objectivec
YMKSearchSnippetBusinessRating1x = 1 << 1
```

Information about ratings (can be requested for a business). See YMKSearchBusinessRating1xObjectMetadata.

### YMKSearchSnippetPanoramas

```objectivec
YMKSearchSnippetPanoramas = 1 << 5
```

Nearest panoramas to this point. See YMKSearchPanoramasObjectMetadata.
