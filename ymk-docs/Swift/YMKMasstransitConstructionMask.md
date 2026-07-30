---
title: "YMKMasstransitConstructionMask"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitConstructionMask"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitConstructionMask.html"
---
# YMKMasstransitConstructionMask

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitConstructionMask.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitConstructionMask : NSObject
```

Constructions that can be found on pedestrian, bicycle paths or on mass transit transfers.

## Summary

### Class methods

```swift
 init(stairs: YMKMasstransitStairs?,
        pass: NSNumber?,
   crosswalk: Bool,
     binding: Bool,
  transition: Bool,
      tunnel: Bool,
  travolator: NSNumber?,
      indoor: Bool,
      spiral: Bool,
   escalator: NSNumber?,
    elevator: NSNumber?)
```

### Properties

```swift
var stairs: YMKMasstransitStairs? { get }
```

Optional field, can be nil

```swift
var pass: NSNumber? { get }
```

Optional field, can be nil

```swift
var crosswalk: Bool { get }
```

Crossing that is not an underground tunnel or a bridge

```swift
var binding: Bool { get }
```

Edge connecting the route endpoint to the route network

```swift
var transition: Bool { get }
```

Transfer

```swift
var tunnel: Bool { get }
```

Tunnel that is not a crossing

```swift
var travolator: NSNumber? { get }
```

Optional field, can be nil

```swift
var indoor: Bool { get }
```

Air-conditioned place

```swift
var spiral: Bool { get }
```

Spiral object, e

```swift
var escalator: NSNumber? { get }
```

Optional field, can be nil

```swift
var elevator: NSNumber? { get }
```

Optional field, can be nil

## Class methods

### init(stairs:pass:crosswalk:binding:transition:tunnel:travolator:indoor:spiral:escalator:elevator:)

```swift
 init(stairs: YMKMasstransitStairs?,
        pass: NSNumber?,
   crosswalk: Bool,
     binding: Bool,
  transition: Bool,
      tunnel: Bool,
  travolator: NSNumber?,
      indoor: Bool,
      spiral: Bool,
   escalator: NSNumber?,
    elevator: NSNumber?)
```

## Properties

### stairs

```swift
var stairs: YMKMasstransitStairs? { get }
```

Optional field, can be nil.

### pass

```swift
var pass: NSNumber? { get }
```

Optional field, can be nil.

### crosswalk

```swift
var crosswalk: Bool { get }
```

Crossing that is not an underground tunnel or a bridge.

### binding

```swift
var binding: Bool { get }
```

Edge connecting the route endpoint to the route network.

### transition

```swift
var transition: Bool { get }
```

Transfer. For example, transfer from one underground line to another or transfer from an underground station to an exit from it.

### tunnel

```swift
var tunnel: Bool { get }
```

Tunnel that is not a crossing.

### travolator

```swift
var travolator: NSNumber? { get }
```

Optional field, can be nil.

### indoor

```swift
var indoor: Bool { get }
```

Air-conditioned place. Can be a covered gallery, a mall or any other climate-static edges.

### spiral

```swift
var spiral: Bool { get }
```

Spiral object, e.g. stairs

### escalator

```swift
var escalator: NSNumber? { get }
```

Optional field, can be nil.

### elevator

```swift
var elevator: NSNumber? { get }
```

Optional field, can be nil.
