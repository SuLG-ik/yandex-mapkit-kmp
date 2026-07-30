---
title: "YMKSearchFuelMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchFuelMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFuelMetadata.html"
---
# YMKSearchFuelMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFuelMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchFuelMetadata : NSObject, YMKBaseMetadata
```

Fuel snippet.

## Summary

### Class methods

```swift
 init(timestamp: NSNumber?,
          fuels: [YMKSearchFuelType],
    attribution: YMKAttribution?)
```

### Properties

```swift
var timestamp: NSNumber? { get }
```

Snippet update time as UNIX timestamp

```swift
var fuels: [YMKSearchFuelType] { get }
```

Fuel list

```swift
var attribution: YMKAttribution? { get }
```

Attribution information

## Class methods

### init(timestamp:fuels:attribution:)

```swift
 init(timestamp: NSNumber?,
          fuels: [YMKSearchFuelType],
    attribution: YMKAttribution?)
```

## Properties

### timestamp

```swift
var timestamp: NSNumber? { get }
```

Snippet update time as UNIX timestamp.

Optional field, can be nil.

### fuels

```swift
var fuels: [YMKSearchFuelType] { get }
```

Fuel list.

### attribution

```swift
var attribution: YMKAttribution? { get }
```

Attribution information.

Optional field, can be nil.
