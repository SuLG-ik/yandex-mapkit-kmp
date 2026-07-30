---
title: "YMKMasstransitConnector"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitConnector"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitConnector.html"
---
# YMKMasstransitConnector

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitConnector.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitConnector : NSObject
```

Connectors connect two floors, indoor and outdoor, two indoor plans. Connectors do not have single level id and name but still are considered a part of the indoor plan. Examples: stairs, elevators, escalators, travolators, transitions, route segment that goes from outdoor to indoor (through the entrance) and vica versa.

## Summary

### Class methods

```swift
 init(from: YMKMasstransitIndoorLevel?, to: YMKMasstransitIndoorLevel?)
```

### Properties

```swift
var from: YMKMasstransitIndoorLevel? { get }
```

A level (floor) where the connector begins

```swift
var to: YMKMasstransitIndoorLevel? { get }
```

A level (floor) where the connector ends

## Class methods

### init(from:to:)

```swift
 init(from: YMKMasstransitIndoorLevel?, to: YMKMasstransitIndoorLevel?)
```

## Properties

### from

```swift
var from: YMKMasstransitIndoorLevel? { get }
```

A level (floor) where the connector begins. Null means outdoor.

Optional field, can be nil.

### to

```swift
var to: YMKMasstransitIndoorLevel? { get }
```

A level (floor) where the connector ends. Null means outdoor.

Optional field, can be nil.
