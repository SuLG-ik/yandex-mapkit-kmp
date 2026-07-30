---
title: "YMKDrivingSection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSection.html"
---
# YMKDrivingSection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingSection : NSObject
```

Route section.

## Summary

### Class methods

```swift
 init(metadata: YMKDrivingSectionMetadata, geometry: YMKSubpolyline)
```

### Properties

```swift
var metadata: YMKDrivingSectionMetadata { get }
```

Metadata information for the route section

```swift
var geometry: YMKSubpolyline { get }
```

A polyline of the route section

## Class methods

### init(metadata:geometry:)

```swift
 init(metadata: YMKDrivingSectionMetadata, geometry: YMKSubpolyline)
```

## Properties

### metadata

```swift
var metadata: YMKDrivingSectionMetadata { get }
```

Metadata information for the route section.

### geometry

```swift
var geometry: YMKSubpolyline { get }
```

A polyline of the route section.
