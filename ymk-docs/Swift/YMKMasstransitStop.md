---
title: "YMKMasstransitStop"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitStop.html"
---
# YMKMasstransitStop

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitStop : NSObject, YMKBaseMetadata
```

Describes a public transport stop.

## Summary

### Class methods

```swift
 init(id: String,
    name: String,
 additionalName: String?,
 features: YMKMasstransitStopFeatureMask?,
 transportContours: [YMKMasstransitTransportContour])
```

### Properties

```swift
var id: String { get }
```

Stop ID

```swift
var name: String { get }
```

Stop name

```swift
var additionalName: String? { get }
```

Additional stop name

```swift
var features: YMKMasstransitStopFeatureMask? { get }
```

Additional stop features

```swift
var transportContours: [YMKMasstransitTransportContour] { get }
```

Describes transport contours represented at this Stop

## Class methods

### init(id:name:additionalName:features:transportContours:)

```swift
 init(id: String,
    name: String,
 additionalName: String?,
 features: YMKMasstransitStopFeatureMask?,
 transportContours: [YMKMasstransitTransportContour])
```

## Properties

### id

```swift
var id: String { get }
```

Stop ID.

### name

```swift
var name: String { get }
```

Stop name.

### additionalName

```swift
var additionalName: String? { get }
```

Additional stop name. Can be a local number or specifying index. Similar to thread description, but for stops

Optional field, can be nil.

### features

```swift
var features: YMKMasstransitStopFeatureMask? { get }
```

Additional stop features.

Optional field, can be nil.

### transportContours

```swift
var transportContours: [YMKMasstransitTransportContour] { get }
```

Describes transport contours represented at this Stop.
