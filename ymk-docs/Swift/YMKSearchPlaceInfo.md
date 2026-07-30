---
title: "YMKSearchPlaceInfo"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchPlaceInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPlaceInfo.html"
---
# YMKSearchPlaceInfo

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPlaceInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchPlaceInfo : NSObject
```

Related place information.

## Summary

### Class methods

```swift
 init(name: String,
       uri: String?,
 photoUrlTemplate: String?,
     logId: String?,
     point: YMKPoint?,
  category: String?,
 shortName: String?,
    rating: NSNumber?,
 workingHours: YMKSearchWorkingHours?,
   address: String?,
       tag: [String])
```

### Properties

```swift
var name: String { get }
```

Place name

```swift
var uri: String? { get }
```

Place URI

```swift
var photoUrlTemplate: String? { get }
```

Url template for place photo

```swift
var logId: String? { get }
```

Server-generated log identifier

```swift
var point: YMKPoint? { get }
```

Place position

```swift
var category: String? { get }
```

Place category as a string

```swift
var shortName: String? { get }
```

Short name for a place

```swift
var rating: NSNumber? { get }
```

Place rating as number in 0 to 10 range

```swift
var workingHours: YMKSearchWorkingHours? { get }
```

Open hours for a place

```swift
var address: String? { get }
```

Formatted address for an organization

```swift
var tag: [String] { get }
```

Tags

## Class methods

### init(name:uri:photoUrlTemplate:logId:point:category:shortName:rating:workingHours:address:tag:)

```swift
 init(name: String,
       uri: String?,
 photoUrlTemplate: String?,
     logId: String?,
     point: YMKPoint?,
  category: String?,
 shortName: String?,
    rating: NSNumber?,
 workingHours: YMKSearchWorkingHours?,
   address: String?,
       tag: [String])
```

## Properties

### name

```swift
var name: String { get }
```

Place name.

### uri

```swift
var uri: String? { get }
```

Place URI.

Optional field, can be nil.

### photoUrlTemplate

```swift
var photoUrlTemplate: String? { get }
```

Url template for place photo.

Optional field, can be nil.

### logId

```swift
var logId: String? { get }
```

Server-generated log identifier.

Optional field, can be nil.

### point

```swift
var point: YMKPoint? { get }
```

Place position.

Optional field, can be nil.

### category

```swift
var category: String? { get }
```

Place category as a string.

Optional field, can be nil.

### shortName

```swift
var shortName: String? { get }
```

Short name for a place.

Optional field, can be nil.

### rating

```swift
var rating: NSNumber? { get }
```

Place rating as number in 0 to 10 range.

Optional field, can be nil.

### workingHours

```swift
var workingHours: YMKSearchWorkingHours? { get }
```

Open hours for a place.

Optional field, can be nil.

### address

```swift
var address: String? { get }
```

Formatted address for an organization.

Optional field, can be nil.

### tag

```swift
var tag: [String] { get }
```

Tags
