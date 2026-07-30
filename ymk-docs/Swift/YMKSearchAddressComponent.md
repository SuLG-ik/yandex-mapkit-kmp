---
title: "YMKSearchAddressComponent"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchAddressComponent"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchAddressComponent.html"
---
# YMKSearchAddressComponent

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchAddressComponent.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchAddressComponent : NSObject
```

Single address component.

Component represents a single entry in the administrative hierarchy of the address.

## Summary

### Class methods

```swift
 init(name: String, kinds: [NSNumber])
```

### Properties

```swift
var name: String { get }
```

Component name

```swift
var kinds: [NSNumber] { get }
```

Component kinds

## Class methods

### init(name:kinds:)

```swift
 init(name: String, kinds: [NSNumber])
```

## Properties

### name

```swift
var name: String { get }
```

Component name.

### kinds

```swift
var kinds: [NSNumber] { get }
```

Component kinds. May contain both general and specific kind, for example YMKSearchComponentKindStation and YMKSearchComponentKindMetroStation.
