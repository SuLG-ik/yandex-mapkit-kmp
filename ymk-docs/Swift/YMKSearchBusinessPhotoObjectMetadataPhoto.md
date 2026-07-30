---
title: "YMKSearchBusinessPhotoObjectMetadataPhoto"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessPhotoObjectMetadataPhoto"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessPhotoObjectMetadataPhoto.html"
---
# YMKSearchBusinessPhotoObjectMetadataPhoto

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessPhotoObjectMetadataPhoto.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessPhotoObjectMetadataPhoto : NSObject
```

Information about single photos.

## Summary

### Class methods

```swift
 init(id: String, links: [YMKSearchPhotoPhotoLink])
```

### Properties

```swift
var id: String { get }
```

To get a valid download link use the value of id + /[size], where [size] is one of: 1

```swift
var links: [YMKSearchPhotoPhotoLink] { get }
```

Photo links

## Class methods

### init(id:links:)

```swift
 init(id: String, links: [YMKSearchPhotoPhotoLink])
```

## Properties

### id

```swift
var id: String { get }
```

To get a valid download link use the value of id + /[size], where [size] is one of: 1. XXXS 2. XXS 3. XS 4. S 5. M 6. L 7. XL 8. XXL 9. XXXL 10. orig

### links

```swift
var links: [YMKSearchPhotoPhotoLink] { get }
```

Photo links.
