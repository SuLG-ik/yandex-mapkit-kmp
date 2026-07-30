---
title: "YMKMasstransitInclineSection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitInclineSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitInclineSection.html"
---
# YMKMasstransitInclineSection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitInclineSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitInclineSection : NSObject
```

represents a section of continuous non-trivial gradient

## Summary

### Class methods

```swift
 init(type: YMKMasstransitInclineType, subpolyline: YMKSubpolyline)
```

### Properties

```swift
var type: YMKMasstransitInclineType { get }
```

Vague characteristic of this gradient secion

```swift
var subpolyline: YMKSubpolyline { get }
```

A subpolyline of the route where the section is located

## Class methods

### init(type:subpolyline:)

```swift
 init(type: YMKMasstransitInclineType, subpolyline: YMKSubpolyline)
```

## Properties

### type

```swift
var type: YMKMasstransitInclineType { get }
```

Vague characteristic of this gradient secion

### subpolyline

```swift
var subpolyline: YMKSubpolyline { get }
```

A subpolyline of the route where the section is located
