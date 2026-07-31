---
title: "YMKFitnessOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKFitnessOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKFitnessOptions.html"
---
# YMKFitnessOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKFitnessOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKFitnessOptions : NSObject
```

## Summary

### Class methods

```swift
 init(avoidSteep: Bool, avoidStairs: Bool)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var avoidSteep: Bool { get }
```

If true, router will try avoid steep (in height meaning) routes

```swift
var avoidStairs: Bool { get }
```

If true, router will try avoid stairs

## Class methods

### init(avoidSteep:avoidStairs:)

```swift
 init(avoidSteep: Bool, avoidStairs: Bool)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### avoidSteep

```swift
var avoidSteep: Bool { get }
```

If true, router will try avoid steep (in height meaning) routes.

### avoidStairs

```swift
var avoidStairs: Bool { get }
```

If true, router will try avoid stairs.
