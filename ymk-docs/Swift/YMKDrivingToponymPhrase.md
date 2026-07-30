---
title: "YMKDrivingToponymPhrase"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingToponymPhrase"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingToponymPhrase.html"
---
# YMKDrivingToponymPhrase

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingToponymPhrase.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingToponymPhrase : NSObject
```

The description of the object.

## Summary

### Class methods

```swift
 init(text: String, actionProximity: NSNumber?)
```

### Properties

```swift
var text: String { get }
```

The string containing the description

```swift
var actionProximity: NSNumber? { get }
```

Positions at which text should be pronounced

## Class methods

### init(text:actionProximity:)

```swift
 init(text: String, actionProximity: NSNumber?)
```

## Properties

### text

```swift
var text: String { get }
```

The string containing the description.

### actionProximity

```swift
var actionProximity: NSNumber? { get }
```

Positions at which text should be pronounced.

Optional field, can be nil.
