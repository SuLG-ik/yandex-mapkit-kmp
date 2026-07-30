---
title: "YMKMasstransitRouteSettings"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRouteSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteSettings.html"
---
# YMKMasstransitRouteSettings

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteSettings.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRouteSettings : NSObject
```

Route settings that were used by the mass transit router for a specific route.

## Summary

### Class methods

```swift
 init(avoidTypes: [String], acceptTypes: [String])
```

### Properties

```swift
var avoidTypes: [String] { get }
```

Transport types that the router avoided

```swift
var acceptTypes: [String] { get }
```

Transport types that were allowed even if they are in the list of avoided types

## Class methods

### init(avoidTypes:acceptTypes:)

```swift
 init(avoidTypes: [String], acceptTypes: [String])
```

## Properties

### avoidTypes

```swift
var avoidTypes: [String] { get }
```

Transport types that the router avoided.

### acceptTypes

```swift
var acceptTypes: [String] { get }
```

Transport types that were allowed even if they are in the list of avoided types.
