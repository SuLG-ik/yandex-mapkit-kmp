---
title: "YMKSearchPanorama"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchPanorama"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPanorama.html"
---
# YMKSearchPanorama

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPanorama.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchPanorama : NSObject
```

Panorama info.

## Summary

### Class methods

```swift
 init(id: String, direction: YMKDirection, span: YMKSpan, point: YMKPoint)
```

### Properties

```swift
var id: String { get }
```

Machine readable panorama identifier

```swift
var direction: YMKDirection { get }
```

Direction of the panorama center

```swift
var span: YMKSpan { get }
```

H-Span and V-Span hints for the panorama player

```swift
var point: YMKPoint { get }
```

Panorama point

## Class methods

### init(id:direction:span:point:)

```swift
 init(id: String, direction: YMKDirection, span: YMKSpan, point: YMKPoint)
```

## Properties

### id

```swift
var id: String { get }
```

Machine readable panorama identifier.

### direction

```swift
var direction: YMKDirection { get }
```

Direction of the panorama center.

### span

```swift
var span: YMKSpan { get }
```

H-Span and V-Span hints for the panorama player.

### point

```swift
var point: YMKPoint { get }
```

Panorama point.
