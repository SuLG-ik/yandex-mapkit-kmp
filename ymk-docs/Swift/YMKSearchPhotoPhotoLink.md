---
title: "YMKSearchPhotoPhotoLink"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchPhotoPhotoLink"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPhotoPhotoLink.html"
---
# YMKSearchPhotoPhotoLink

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPhotoPhotoLink.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchPhotoPhotoLink : NSObject
```

Photo link details.

## Summary

### Class methods

```swift
 init(type: String?, uri: String)
```

### Properties

```swift
var type: String? { get }
```

Optional link type, for example "panorama"

```swift
var uri: String { get }
```

Link URI

## Class methods

### init(type:uri:)

```swift
 init(type: String?, uri: String)
```

## Properties

### type

```swift
var type: String? { get }
```

Optional link type, for example "panorama".

Optional field, can be nil.

### uri

```swift
var uri: String { get }
```

Link URI.
