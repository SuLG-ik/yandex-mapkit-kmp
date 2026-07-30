---
title: "YMKBoundingBox"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBoundingBox"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBoundingBox.html"
---
# YMKBoundingBox

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBoundingBox.html)

```swift
class YMKBoundingBox : NSObject
```

A rectangular box around the object.

## Summary

### Class methods

```swift
 init(southWest: YMKPoint, northEast: YMKPoint)
```

### Properties

```swift
var southWest: YMKPoint { get }
```

The coordinates of the southwest corner of the box

```swift
var northEast: YMKPoint { get }
```

The coordinates of the northeast corner of the box

## Class methods

### init(southWest:northEast:)

```swift
 init(southWest: YMKPoint, northEast: YMKPoint)
```

## Properties

### southWest

```swift
var southWest: YMKPoint { get }
```

The coordinates of the southwest corner of the box.

### northEast

```swift
var northEast: YMKPoint { get }
```

The coordinates of the northeast corner of the box.
