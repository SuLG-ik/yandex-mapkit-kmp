---
title: "YMKMasstransitTransportThreadAlert"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitTransportThreadAlert"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransportThreadAlert.html"
---
# YMKMasstransitTransportThreadAlert

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransportThreadAlert.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitTransportThreadAlert : NSObject
```

TransportThreadAlert are important annotations for mass transit ride sections of routes.

## Summary

### Class methods

```swift
 init(text: String,
    closed: YMKMasstransitTransportThreadAlertClosed?,
 closedUntil: YMKMasstransitTransportThreadAlertClosedUntil?,
  lastTrip: YMKMasstransitTransportThreadAlertLastTrip?)
```

### Properties

```swift
var text: String { get }
```

Standard alert text

```swift
var closed: YMKMasstransitTransportThreadAlertClosed? { get }
```

The value is set if the thread is not operational on that day

```swift
var closedUntil: YMKMasstransitTransportThreadAlertClosedUntil? { get }
```

The value is set if the thread is not operational until the specified time

```swift
var lastTrip: YMKMasstransitTransportThreadAlertLastTrip? { get }
```

The value is set if this trip is the last trip for the thread

## Class methods

### init(text:closed:closedUntil:lastTrip:)

```swift
 init(text: String,
    closed: YMKMasstransitTransportThreadAlertClosed?,
 closedUntil: YMKMasstransitTransportThreadAlertClosedUntil?,
  lastTrip: YMKMasstransitTransportThreadAlertLastTrip?)
```

## Properties

### text

```swift
var text: String { get }
```

Standard alert text. Simple clients could use this text to get a pre-formatted message. If the client is unable to recognize the known structured alert, it should use the text field instead.

### closed

```swift
var closed: YMKMasstransitTransportThreadAlertClosed? { get }
```

The value is set if the thread is not operational on that day. Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be nil.

### closedUntil

```swift
var closedUntil: YMKMasstransitTransportThreadAlertClosedUntil? { get }
```

The value is set if the thread is not operational until the specified time. Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be nil.

### lastTrip

```swift
var lastTrip: YMKMasstransitTransportThreadAlertLastTrip? { get }
```

The value is set if this trip is the last trip for the thread. Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be nil.
