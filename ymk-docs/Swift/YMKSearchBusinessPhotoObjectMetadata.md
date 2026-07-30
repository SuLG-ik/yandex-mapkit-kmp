---
title: "YMKSearchBusinessPhotoObjectMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessPhotoObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessPhotoObjectMetadata.html"
---
# YMKSearchBusinessPhotoObjectMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessPhotoObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessPhotoObjectMetadata : NSObject, YMKBaseMetadata
```

Snippet for company-related photos (becoming obsolete).

## Summary

### Class methods

```swift
 init(count: UInt, photos: [YMKSearchBusinessPhotoObjectMetadataPhoto])
```

### Properties

```swift
var count: UInt { get }
```

Number of photos for the organisation

```swift
var photos: [YMKSearchBusinessPhotoObjectMetadataPhoto] { get }
```

List of photos for the company (usually first three)

## Class methods

### init(count:photos:)

```swift
 init(count: UInt, photos: [YMKSearchBusinessPhotoObjectMetadataPhoto])
```

## Properties

### count

```swift
var count: UInt { get }
```

Number of photos for the organisation. (see PhotosManager for details)

### photos

```swift
var photos: [YMKSearchBusinessPhotoObjectMetadataPhoto] { get }
```

List of photos for the company (usually first three)
