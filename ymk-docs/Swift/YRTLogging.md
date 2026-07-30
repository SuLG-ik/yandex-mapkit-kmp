---
title: "YRTLogging"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTLogging"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTLogging.html"
---
# YRTLogging

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTLogging.html)

```swift
class YRTLogging : NSObject
```

Interface for subscribing to and unsubscribing from log messages.

## Summary

### Instance methods

```swift
func subscribe(with logListener: any YRTLogListener)
```

Subscribes a listener to receive log messages

```swift
func unsubscribe(with logListener: any YRTLogListener)
```

Unsubscribes a listener from receiving log messages

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### subscribe(with:)

```swift
func subscribe(with logListener: any YRTLogListener)
```

Subscribes a listener to receive log messages.

The class does not retain the object in the 'logListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| logListener | The listener to subscribe. |

### unsubscribe(with:)

```swift
func unsubscribe(with logListener: any YRTLogListener)
```

Unsubscribes a listener from receiving log messages.

The class does not retain the object in the 'logListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| logListener | The listener to unsubscribe. |

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
