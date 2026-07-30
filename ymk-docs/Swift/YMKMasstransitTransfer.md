---
title: "YMKMasstransitTransfer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitTransfer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransfer.html"
---
# YMKMasstransitTransfer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransfer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitTransfer : NSObject
```

Represents a transfer to another mass transit line or to another stop. For example, transfer from one underground line to another.

## Summary

### Class methods

```swift
 init(constructions: [YMKMasstransitConstructionSegment],
       transferStop: YMKMasstransitTransferStop)
```

### Properties

```swift
var constructions: [YMKMasstransitConstructionSegment] { get }
```

Compressed information about pedestrian constructions along the transfer path

```swift
var transferStop: YMKMasstransitTransferStop { get }
```

The stop you need to transfer to

## Class methods

### init(constructions:transferStop:)

```swift
 init(constructions: [YMKMasstransitConstructionSegment],
       transferStop: YMKMasstransitTransferStop)
```

## Properties

### constructions

```swift
var constructions: [YMKMasstransitConstructionSegment] { get }
```

Compressed information about pedestrian constructions along the transfer path. YMKMasstransitConstructionSegment::subpolyline fields of all segments cover the entire geometry of corresponding section".

### transferStop

```swift
var transferStop: YMKMasstransitTransferStop { get }
```

The stop you need to transfer to
