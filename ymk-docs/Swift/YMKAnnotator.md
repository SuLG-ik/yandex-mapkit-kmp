---
title: "YMKAnnotator"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAnnotator"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAnnotator.html"
---
# YMKAnnotator

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAnnotator.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKAnnotator : NSObject
```

## Summary

### Instance methods

```swift
func setSpeakerWith(_ speaker: (any YMKSpeaker)?)
```

The class does not retain the object in the 'speaker' parameter

```swift
func mute()
```

```swift
func unmute()
```

```swift
func addListener(with annotatorListener: any YMKAnnotatorListener)
```

The class does not retain the object in the 'annotatorListener' parameter

```swift
func removeListener(with annotatorListener: any YMKAnnotatorListener)
```

### Properties

```swift
var annotatedEvents: YMKAnnotatedEvents { get set }
```

```swift
var annotatedRoadEvents: YMKAnnotatedRoadEvents { get set }
```

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setSpeakerWith(_:)

```swift
func setSpeakerWith(_ speaker: (any YMKSpeaker)?)
```

The class does not retain the object in the 'speaker' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### mute()

```swift
func mute()
```

### unmute()

```swift
func unmute()
```

### addListener(with:)

```swift
func addListener(with annotatorListener: any YMKAnnotatorListener)
```

The class does not retain the object in the 'annotatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with annotatorListener: any YMKAnnotatorListener)
```

## Properties

### annotatedEvents

```swift
var annotatedEvents: YMKAnnotatedEvents { get set }
```

### annotatedRoadEvents

```swift
var annotatedRoadEvents: YMKAnnotatedRoadEvents { get set }
```

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
