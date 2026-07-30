---
title: "YMKDrivingAnnotation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingAnnotation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingAnnotation.html"
---
# YMKDrivingAnnotation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingAnnotation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingAnnotation : NSObject
```

The annotation that is displayed on the map.

## Summary

### Class methods

```swift
 init(action: YMKDrivingAction,
     toponym: String?,
 descriptionText: String,
 actionMetadata: YMKDrivingActionMetadata?,
   landmarks: [NSNumber],
 toponymPhrase: [YMKDrivingToponymPhrase])
```

### Properties

```swift
var action: YMKDrivingAction { get }
```

Driver action

```swift
var toponym: String? { get }
```

The toponym of the location

```swift
var descriptionText: String { get }
```

Description text to display

```swift
var actionMetadata: YMKDrivingActionMetadata? { get }
```

Action metadata

```swift
var landmarks: [NSNumber] { get }
```

Significant landmarks

```swift
var toponymPhrase: [YMKDrivingToponymPhrase] { get }
```

Toponym phrases with positions for pronunciation

## Class methods

### init(action:toponym:descriptionText:actionMetadata:landmarks:toponymPhrase:)

```swift
 init(action: YMKDrivingAction,
     toponym: String?,
 descriptionText: String,
 actionMetadata: YMKDrivingActionMetadata?,
   landmarks: [NSNumber],
 toponymPhrase: [YMKDrivingToponymPhrase])
```

## Properties

### action

```swift
var action: YMKDrivingAction { get }
```

Driver action.

### toponym

```swift
var toponym: String? { get }
```

The toponym of the location.

Optional field, can be nil.

### descriptionText

```swift
var descriptionText: String { get }
```

Description text to display.

### actionMetadata

```swift
var actionMetadata: YMKDrivingActionMetadata? { get }
```

Action metadata.

Optional field, can be nil.

### landmarks

```swift
var landmarks: [NSNumber] { get }
```

Significant landmarks.

### toponymPhrase

```swift
var toponymPhrase: [YMKDrivingToponymPhrase] { get }
```

Toponym phrases with positions for pronunciation.
