---
title: "YMKBicycleConstructionID"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKBicycleConstructionID"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleConstructionID.html"
---
# YMKBicycleConstructionID

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleConstructionID.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKBicycleConstructionID : UInt, @unchecked Sendable
```

Construction types for the segments in the geometry.

## Summary

### Enum cases

```swift
case unknown = 0
```

Regular bicycle path segment or a segment without any additional information known

```swift
case binding = 1
```

Edge connecting the route endpoint to the bicycle route network

```swift
case stairsUp = 2
```

Stairway with stairs going up along a path

```swift
case stairsDown = 3
```

Stairway with stairs going down along a path

```swift
case stairsUnknown = 4
```

Stairway with no information whether stairs go up or down along a path

```swift
case underpass = 5
```

Underground crossing

```swift
case overpass = 6
```

Overground crossing

```swift
case crossing = 7
```

Crossing that is not an underground tunnel or a bridge

```swift
case tunnel = 8
```

Tunnel that is not a crossing

## Enum cases

### unknown

```swift
case unknown = 0
```

Regular bicycle path segment or a segment without any additional information known.

### binding

```swift
case binding = 1
```

Edge connecting the route endpoint to the bicycle route network.

### stairsUp

```swift
case stairsUp = 2
```

Stairway with stairs going up along a path.

### stairsDown

```swift
case stairsDown = 3
```

Stairway with stairs going down along a path.

### stairsUnknown

```swift
case stairsUnknown = 4
```

Stairway with no information whether stairs go up or down along a path.

### underpass

```swift
case underpass = 5
```

Underground crossing.

### overpass

```swift
case overpass = 6
```

Overground crossing.

### crossing

```swift
case crossing = 7
```

Crossing that is not an underground tunnel or a bridge.

### tunnel

```swift
case tunnel = 8
```

Tunnel that is not a crossing.
