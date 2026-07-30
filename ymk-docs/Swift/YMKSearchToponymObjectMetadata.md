---
title: "YMKSearchToponymObjectMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchToponymObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchToponymObjectMetadata.html"
---
# YMKSearchToponymObjectMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchToponymObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchToponymObjectMetadata : NSObject, YMKBaseMetadata
```

Additional data for toponym objects.

## Summary

### Class methods

```swift
 init(address: YMKSearchAddress,
    precision: NSNumber?,
   formerName: String?,
 balloonPoint: YMKPoint,
        geoId: Int,
           id: String?)
```

### Properties

```swift
var address: YMKSearchAddress { get }
```

Structured toponym address

```swift
var precision: NSNumber? { get }
```

Toponym precision

```swift
var formerName: String? { get }
```

Former name for toponym if any

```swift
var balloonPoint: YMKPoint { get }
```

Point where balloon for the toponym should be shown

```swift
var geoId: Int { get }
```

geobase id

```swift
var id: String? { get }
```

Persistent toponym id (available for Yandex-owned regions)

## Class methods

### init(address:precision:formerName:balloonPoint:geoId:id:)

```swift
 init(address: YMKSearchAddress,
    precision: NSNumber?,
   formerName: String?,
 balloonPoint: YMKPoint,
        geoId: Int,
           id: String?)
```

## Properties

### address

```swift
var address: YMKSearchAddress { get }
```

Structured toponym address

### precision

```swift
var precision: NSNumber? { get }
```

Toponym precision.

Optional field, can be nil.

### formerName

```swift
var formerName: String? { get }
```

Former name for toponym if any.

Optional field, can be nil.

### balloonPoint

```swift
var balloonPoint: YMKPoint { get }
```

Point where balloon for the toponym should be shown. Differs for direct and reverse search modes: Direct mode -- toponym center. Reverse mode -- toponym nearest point to the given coordinates.

### geoId

```swift
var geoId: Int { get }
```

geobase id

### id

```swift
var id: String? { get }
```

Persistent toponym id (available for Yandex-owned regions).

Optional field, can be nil.
