---
title: "YMKAdjustedClock"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAdjustedClock"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAdjustedClock.html"
---
# YMKAdjustedClock

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAdjustedClock.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKAdjustedClock : NSObject
```

## Summary

### Instance methods

```swift
func now() -> Date
```

This method returns the time that has been synchronized with Yandex servers

```swift
func resume()
```

Notifies AdjustedClock when the application resumes the foreground state

```swift
func pause()
```

Notifies AdjustedClock when the application pauses and goes to the background

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### now()

```swift
func now() -> Date
```

This method returns the time that has been synchronized with Yandex servers. Use it if you don't trust the time on the local device because the user could have set it incorrectly. If time synchronization has failed or not yet finished, the returned value equals the local device's time.

**Returns**

POSIX time. For more information, see

https://en.wikipedia.org/wiki/Unix_time.

### resume()

```swift
func resume()
```

Notifies AdjustedClock when the application resumes the foreground state.

### pause()

```swift
func pause()
```

Notifies AdjustedClock when the application pauses and goes to the background.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
